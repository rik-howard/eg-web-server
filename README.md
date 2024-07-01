


# EG Web Server
EG Web Server is a clustered, contained application.  It utilises Spring Boot, Docker and Kubernetes.  It is upgraded as a blue-green deployment.


## Prerequisites
* Java 17
* Maven 3.8
* Docker 27
* HTTPie 3.2
* JQ 1.6


## Subprojects
* [Loader](loader/README.md): a load tester for a local host end point
* [Application](application/README.md): a stateless application supporting some end points
* [Container](container/README.md): the contained application

*2024-07-01*
