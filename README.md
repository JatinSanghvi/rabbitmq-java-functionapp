## Prerequisites

Although, the versions listed below are not strict requirements, if in case a particular command fails at your end, just make sure that your tool's version is not far off.

```console
> docker --version
Docker version 20.10.12, build e91ed57

> dotnet --version
6.0.101

> func version
4.0.3971

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
```

## Test Instructions

1. Run RabbitMQ Docker container (Reference: https://www.rabbitmq.com/download.html).

    ```console
    > docker run --interactive --tty --rm --name rabbitmq --publish 5672:5672 --publish 15672:15672 rabbitmq:3-management
    ```

2. Login to http://localhost:15672. with `guest/guest` as username/password.

3. Open page http://localhost:15672/#/queues. Add queues `inputQueue` and `outputQueue`. Use default options.

4. In another console, start this Function App locally.

    ```console
    > ./mvnw clean package azure-functions:run
    ```

5. Open page http://localhost:15672/#/queues/%2F/inputQueue and publish message `World` to queue.

6. Verify that the event shows up in the Function App logs.

    ```log
    [2022-02-26T04:54:35.845Z] Executing 'Functions.RabbitMQExample' (Reason='RabbitMQ message detected from queue: inputQueue at 2022-02-26 10:24:35', Id=910ba874-75a4-4b59-aa76-ed76b66ee24b)
    [2022-02-26T04:54:35.860Z] Message received: World
    [2022-02-26T04:54:35.867Z] Function "RabbitMQExample" (Id: 910ba874-75a4-4b59-aa76-ed76b66ee24b) invoked by Java Worker
    [2022-02-26T04:54:35.880Z] Executed 'Functions.RabbitMQExample' (Succeeded, Id=910ba874-75a4-4b59-aa76-ed76b66ee24b, Duration=36ms)
    ```

7. Open page http://localhost:15672/#/queues/%2F/outputQueue and get the message from queue. The payload should be `Hello, World.`.

8. Stop the function app and stop/remove the Docker container by pressing `Ctrl+C` in both console windows.
