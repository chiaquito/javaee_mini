.PHONY: build
build:
	./gradlew clean build --warning-mode all

.PHONY: start
start:
	./servers/payara5/glassfish/bin/asadmin start-domain domain1

.PHONY: redeploy
redeploy:
	cp ./build/libs/mini.war ./servers/payara5/glassfish/domains/domain1/applications/mini 
	cd ./servers/payara5/glassfish/domains/domain1/applications/mini && jar xf ./mini.war

.PHONY: restart
restart:
	./servers/payara5/glassfish/bin/asadmin restart-domain

.PHONY: stop
stop:
	./servers/payara5/glassfish/bin/asadmin stop-domain

.PHONY: stdout
stdout:
	tail -f ./servers/payara5/glassfish/domains/domain1/logs/server.log

