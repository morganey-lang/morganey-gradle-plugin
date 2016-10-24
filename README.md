[![Build Status](https://travis-ci.org/morganey-lang/morganey-gradle-plugin.svg?branch=master)](https://travis-ci.org/morganey-lang/morganey-gradle-plugin)

# Morganey Gradle Plugin

## What Is The Morganey Gradle Plugin
The Morganey Gradle plugin makes it easy to package
Morganey modules in the JAR created from your project

## How To Build The Morganey Gradle Plugin
To build the Morganey Gradle plugin follow the instructions in CONTRIBUTING.md

## How To Use The Morganey Gradle Plugin

To use the plugin in your project add the following to your `build.gradle`:

```groovy
plugins {
    id 'me.rexim.morganey' version '0.0.1'
}
```

If the build completed sucessfully a JAR file should be generated
in the project build directory called `projectname-version.jar`
