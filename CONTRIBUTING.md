# How To Contribute To The Morganey Gradle Plugin

# Building Gradle Plugin

## Dependencies 

1. Local Clone Of This Repository

## Plugin Build Instructions From Within IDEA

1. IntelliJ 2016.X.X Community Stable
2. Install All Dependencies
3. Run ./gradlew idea in the root directory 
4. Run ./gradlew build From IDEA Terminal
5. Run ./gradlew publish From IDEA Terminal

## Plugin Build Instructions From Command Line

1. Install All Dependencies
2. cd to the root of the repository
3. Run ./gradlew build 
4. Run ./gradlew publish


# Building Plugin Test Project

## Dependencies

1. Local Clone Of This Repository
2. Successful Build Of The Plugin Project

## Test Project Build Instructions From Within IDEA

1. IntelliJ 2016.X.X Community Stable
2. Install All Dependencies
3. cd plugin-Test
4. Run gradle idea
5. Run gradle build From IDEA Terminal
6. A JAR Containing All Morganey Files In The Project Will Be Outputted To build/libs

## Test Project Build Instructions From Command Line

1. Install All Dependencies
2. cd plugin-Test
3. Run ./gradlew build 
4. A JAR Containing All Morganey Files In The Project Will Be Outputted To build/libs