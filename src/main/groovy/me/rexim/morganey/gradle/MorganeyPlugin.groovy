package me.rexim.morganey.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by thoma on 03/10/2016.
 */
class MorganeyPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        project.task('hello') << {
            println "Hello from the Morganey Plugin"
        }
    }
}
