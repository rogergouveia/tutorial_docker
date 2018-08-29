# Docker Tutorial

Small tutorial showing some concepts about docker and demonstrating a simple way to build and run a SpringBoot+Gradle+RabbitMq+PostgreSQL service

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Docker installed (Required)
* Gradle (required)
* IDE (Recommended)
* Familiarity with unix commands (Recommended)


Installation of the Prerequisites is outside the scope of this tutorial


## Briefing


## Project Structure

This Project is composed of two simple Springboot Applications. One of them - called Producer - posts an object Item in the Rabbitmq queue each 5 seconds. The other one - called Consumer - consumes from the queue, saves the Item object in a DataBase, then it sleeps for 30 seconds.


In the terminal, go to the folder tutorial_docker_consumer and execute the command:
```
gradle build docker
```
Execute the same command in the folder tutorial_docker_producer


Verify that the images "rabbithole/tutorial_docker_consumer" and "rabbithole/tutorial_docker_producer" were created
```
docker image ls
```

Go to the base project folder and execute 
```
docker-compose up
```

CTRL+C

```
docker swarm init
```
```
docker stack deploy -c docker-compose.yml myswarm
```
```
docker service logs -f myswarm_producer
```
CTRL+ALT+T
```
docker service logs -f myswarm_consumer
```
 

## Authors

* **Roger Gouveia** - *Initial work* - [GitHubLink](https://github.com/rogergouveia)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
