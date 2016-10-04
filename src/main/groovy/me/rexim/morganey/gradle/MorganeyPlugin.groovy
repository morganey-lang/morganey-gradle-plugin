package me.rexim.morganey.gradle

import org.apache.tools.ant.TaskContainer
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.artifacts.Configuration
import org.gradle.api.internal.file.collections.SimpleFileCollection
import org.gradle.api.plugins.JavaPlugin

/**
 * Created by thoma on 03/10/2016.
 */
class MorganeyPlugin implements Plugin<Project> {
    ArrayList<File> files;
    ArrayList<File> filesToAdd = new ArrayList<File>()
    Configuration configuration;
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
                println "Adding File: " + filesToAdd.get(i).name
            }
        }
        project.task('build-jar') << {
            type: 'jar'
            baseName: 'Morganey-Files.jar'
            from: filesToAdd.collect()
            println "Packaging " + filesToAdd.size() + " Morganey Files Into JAR"
        }
        project.getTasksByName('build', false)[0].finalizedBy(project.getTasksByName('package-module', false)[0])
        project.getTasksByName('package-module', false)[0].finalizedBy(project.getTasksByName('build-jar', false)[0])
    }

    void getFiles(Project project, String path) {
        File directory = new File(path);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            println file.name + " : " + file.isDirectory()
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
