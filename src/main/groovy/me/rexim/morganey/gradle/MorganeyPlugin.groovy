package me.rexim.morganey.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.bundling.Jar

/**
 * Created by thoma on 03/10/2016.
 */
class MorganeyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.plugins.apply(JavaPlugin.class)
        project.task('hello') << { // This is to be used for testing purposes only
            println "Hello from the Morganey Plugin"
        }
        project.task([type: Jar.class], 'package-module') {
            from('src/main/morganey/package')
            with(project.jar)
        }
        project.getTasksByName('build', false)[0].finalizedBy(project.getTasksByName('package-module', false)[0])
    }
}
