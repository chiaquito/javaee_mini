After clone this repository execute these commands to start this application

1. Run MySQL container
```
docker compose up -d
```
2. Put Payara server in servers directory
```
make download-payara
```
3. Configure the environment by replacing domain.xml in Payara server
```
make setup-domain
```
4.  Generate autodeploy directory by starting server
```
make start
```
5. Build 
```
make build
```
6. Deploy 
```
make restart
```
7. Access the App
```
http://localhost:8080/mini/api/simple
```
8. Finish App
```
make stop
```