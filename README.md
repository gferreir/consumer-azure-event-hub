# Java Azure Event Hub Consumer

To use it
---

Set these environment variables in Linux/MacOS:

```Bash
export AZURE_EVENT_HUB_CONNECTION_STRING=<your_connection_string_here>
export AZURE_EVENT_HUB_NAME=<your_event_hub_name_here>
```

Clone this repo:

```Bash
git clone https://github.com/gferreir/consumer-azure-event-hub.git

cd consumer-azure-event-hub
```

Build the application:

```Bash
mvn clean package 
```

Run the application

```Bash
java -jar target/consumer-azure-events-1.0-SNAPSHOT.jar
```