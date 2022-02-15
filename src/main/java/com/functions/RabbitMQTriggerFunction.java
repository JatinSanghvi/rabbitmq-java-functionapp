package com.functions;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.rabbitmq.annotation.*;
import com.microsoft.azure.functions.*;

import java.util.*;

/**
 * Azure Functions with RabbitMQ Trigger.
 * https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-rabbitmq-trigger?tabs=java
 */
public class RabbitMQTriggerFunction {
    /**
     * This function will be invoked when a http request is received. The message contents are provided as output to this function.
     */
    @FunctionName("RabbitMQTriggerAndOutput")
    public void run(
        @RabbitMQTrigger(connectionStringSetting = "RabbitMqConnectionString", queueName = "%RabbitMqInQueueName%") String name,
        @RabbitMQOutput(connectionStringSetting = "RabbitMqConnectionString", queueName = "%RabbitMqOutQueueName%") OutputBinding<String> greeting,
        final ExecutionContext context
    ) {
        context.getLogger().info("Name: " + name);
        greeting.setValue("Hi, " + name);
    }
}


