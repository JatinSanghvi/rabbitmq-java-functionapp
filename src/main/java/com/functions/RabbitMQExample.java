package com.functions;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.rabbitmq.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with RabbitMQ Trigger.
 * https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-rabbitmq-trigger?tabs=java
 */
public class RabbitMQExample {
    @FunctionName("RabbitMQExample")
    public void run(
            @RabbitMQTrigger(connectionStringSetting = "RabbitMqConnectionString", queueName = "%RabbitMqInQueueName%") String name,
            @RabbitMQOutput(connectionStringSetting = "RabbitMqConnectionString", queueName = "%RabbitMqOutQueueName%") OutputBinding<String> greeting,
            final ExecutionContext context) {
        context.getLogger().info("Message received: " + name);
        greeting.setValue("Hello, " + name + ".");
    }
}
