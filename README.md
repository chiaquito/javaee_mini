After clone this repository execute these commands to start this application

1. Put Payara server in servers directory
```
make download-payara
```
2. Configure the environment by replacing domain.xml in Payara server
```
make setup-domain
```
3.  Generate autodeploy directory by starting server
```
make start
```
4. Build 
```
make build
```
5. Deploy 
```
make restart
```
6. Access the App
```
http://localhost:8080/mini/api/simple
```
7. Finish App
```
make stop
```