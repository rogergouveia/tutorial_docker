# Docker Compose/Swarm Example (SpringBoot + Gradle + RabbitMQ + PostgreSQL)

Small project demonstrating a simple way to build and run a SpringBoot+Gradle+RabbitMq+PostgreSQL service with Docker Compose and Docker Swarm. This Project is composed of two simple Springboot Applications. One of them - called Producer - posts an object Item in the Rabbitmq queue each 5 seconds. The other one - called Consumer - consumes from the queue, saves the Item object in a PostgreSQL DataBase, then it sleeps for 30 seconds.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Docker installed (Required)
* Gradle (required)
* Familiarity with unix commands (Recommended)

Installation of the Prerequisites is outside the scope of this tutorial

## Project Structure
```
.
├── docker-compose.yml            # Docker Compose configuration
├── tutorial_docker_consumer      # Consumer folder
|   ├── src                       # Consumer SpringBoot Application sources
|   ├── Dockerfile                # Dockerfile that builds the applications jar as an docker image
|   ├── build.gradle              # Gradle build with docker plugin that points to the applications jar
├── tutorial_docker_producer      # Producer folder
|   ├── src                       # Producer SpringBoot Application sources
|   ├── Dockerfile                # Dockerfile that builds the applications jar as an docker image
|   ├── build.gradle              # Gradle build with docker plugin that points to the applications jar
```


### Build the images

In the terminal, execute the command below in the folders "./tutorial_docker_consumer" and "./tutorial_docker_producer":
```
gradle build docker
```

Verify that the images "rabbithole/tutorial_docker_consumer" and "rabbithole/tutorial_docker_producer" were created
```
docker image ls
```

### Run

Go to the base folder and execute:
```
docker-compose up
```
And that's it! It will start a container for the consumer, for the producer, for a postgres database and for a rabbitmq server.

Wait for the containers to start.  Verify in the terminal that the consumer is consuming the producer mensages. The message processing time of the consumer is too high. Mensages in the queue are piling up.

Press CTRL+C to stop


### Run in scale

For that, we need something extra. Here I will show how to use Docker Swarm for that, but, as of writing this document, almost everyone uses Kubernetes.


Initialize docker in swarm mode
```
docker swarm init
```

To run your service in swarm mode, go to the base folder and execute:
```
docker stack deploy -c docker-compose.yml myswarm
```

It is almost the same as we did before. The difference is that now the service is running in the background, it can be scaled, and you could use multiple machines as processing nodes for your service. This means that the configuration "replicas: 4" in the consumer service in the docker-compose.yml will be used now. There are 4 instances of the consumer service running in parallel now.

To see what is happening with the consumer, execute the command:
```
docker service logs -f myswarm_consumer
```

Open another terminal, and execute the command below to see what is happening with the producer:
```
docker service logs -f myswarm_producer
```

## Authors

* **Roger Gouveia** - *Initial work* - [GitHubLink](https://github.com/rogergouveia)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
