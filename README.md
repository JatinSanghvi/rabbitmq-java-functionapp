## Setup Details

```ps1
> dotnet --version
6.0.101

> java -version
openjdk version "1.8.0_322"
OpenJDK Runtime Environment (Temurin)(build 1.8.0_322-b06)
OpenJDK 64-Bit Server VM (Temurin)(build 25.322-b06, mixed mode)

> mvn --version
Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
Maven home: C:\Users\jasanghv\scoop\apps\maven\current
Java version: 1.8.0_322, vendor: Temurin, runtime: C:\Users\jasanghv\scoop\apps\temurin8-jdk\current\jre
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

> func version
4.0.3971
```

## Running Function App

```ps1
> ./mvnw clean package azure-functions:run
```