package me.rexim.morganey.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.bundling.Jar

/**
 * Created by thoma on 03/10/2016.
 */
class MorganeyPlugin implements Plugin<Project> {
    ArrayList<File> filesToAdd = new ArrayList<File>()
    String[] paths;
    @Override
    void apply(Project project) {
        project.plugins.apply(JavaPlugin.class)
        project.task('hello') << { // This is to be used for testing purposes only
            println "Hello from the Morganey Plugin"
        }
        project.task('package-module') << {
            println "Packaging Morganey Module"
            getFiles(project, project.projectDir.path + "/src")
            for (int i = 0; i < filesToAdd.size(); i++) {
                println "Adding File: " + filesToAdd.get(i).path
            }
        }
        project.task([type: Jar.class], 'build-jar') {
            mustRunAfter(getPaths(project))
            baseName = 'Morganey-Files'
            from(paths)
            with(project.jar)
        }
        project.getTasksByName('build', false)[0].finalizedBy(project.getTasksByName('package-module', false)[0])
        project.getTasksByName('package-module', false)[0].finalizedBy(project.getTasksByName('build-jar', false)[0])
    }

    def getPaths(Project project) {
        String[] paths = new String[filesToAdd.size()]
        println("Function Called")
        String basepath = project.path
        for(int i = 0; i < filesToAdd.size(); i++){
            String currentPath = filesToAdd.get(i).path
            paths[i] = filesToAdd.get(i).path.substring(basepath.length(), currentPath.length())
            println paths[i]
        }
        this.paths = paths
    }

    void getFiles(Project project, String path) {
        File directory = new File(path);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                if(file.name.substring(file.name.length() - 3 , file.name.length())) { // Get File Extension
                    filesToAdd.add(file)
                }
            } else if (file.isDirectory()) {
                getFiles(project, file.getAbsolutePath());
            }
        }
    }
}
