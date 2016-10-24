Publising the Gradle plugin
===========================

If you're the morganey-gradle-plugin maintainer, then you need to perform the
following tasks to publish the Morganey plugin to the [Gradle plugin
portal][gradle-plugins]:

1.  [Log into the plugin portal][login].
2.  Get your API key from the "API Keys" tab and save it to the file
    `~/.gradle/gradle.properties`.
3.  Make sure you've set up the proper plugin version in the `build.gradle`.
3.  `./gradlew publishPlugins`

[gradle-plugins]: https://plugins.gradle.org/
[login]: https://login.gradle.org/user/login
