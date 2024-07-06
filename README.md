


# EG Web Server
EG Web Server is a clustered, contained application.  It utilises Spring Boot, Docker and Kubernetes.  It is upgraded as a blue-green deployment.


## Prerequisites
* Java 17
* Maven 3.8
* Docker 27
* Minikube 1.30
* Kubectl 1.27 
* Helm 3.12
* HTTPie 3.2
* JQ 1.6
* XQ 1.2.3
* YQ 4.33


## Subprojects
* [Loader](loader/README.md): a load tester for a local host end point
* [Application](application/README.md): a stateless application with some end points
* [Container](container/README.md): the contained application
* [Kluster](kluster/README.md): the clustered application
* [Script](script/README.md): some ancillary scripts

*2024-07-01*
