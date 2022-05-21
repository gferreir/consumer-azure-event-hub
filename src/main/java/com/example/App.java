package com.example;

import com.azure.messaging.eventhubs.*;

public class App {

    public static void main( String[] args ){

		String connectionString = System.getenv("AZURE_EVENT_HUB_CONNECTION_STRING");
		String eventHubName = System.getenv("AZURE_EVENT_HUB_NAME");

        EventProcessorClient eventProcessorClient = new EventProcessorClientBuilder()
        .consumerGroup(EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME)
        .connectionString(connectionString,eventHubName)
        .checkpointStore(new SampleCheckpointStore())
        .processEvent(eventContext -> {
            System.out.println("Partition id = " + eventContext.getPartitionContext().getPartitionId() + "\n"
                + "Event = " + eventContext.getEventData().getBodyAsString());
        })
        .processError(errorContext -> {
            System.out
                .println("Error occurred while processing events " + errorContext.getThrowable().getMessage());
        })
        .buildEventProcessorClient();
    
        // This will start the processor. It will start processing events from all partitions.
        eventProcessorClient.start();
    }
}
