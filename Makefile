######################################
##    Commands to develop App       ##
######################################

.PHONY: start
start:
	./servers/payara5/glassfish/bin/asadmin start-domain domain1

.PHONY: build
build:
	./gradlew clean build --warning-mode all

.PHONY: restart
restart:
	cp ./build/libs/mini.war ./servers/payara5/glassfish/domains/domain1/autodeploy
	./servers/payara5/glassfish/bin/asadmin restart-domain

.PHONY: stop
stop:
	./servers/payara5/glassfish/bin/asadmin stop-domain

.PHONY: stdout
stdout:
	tail -f ./servers/payara5/glassfish/domains/domain1/logs/server.log


######################################
##    Commands to set up only       ##
######################################

.PHONY: download-payara
download-payara:
	cd servers && curl -O https://repo1.maven.org/maven2/fish/payara/distributions/payara/5.2022.5/payara-5.2022.5.zip
	cd servers && unzip payara-5.2022.5.zip


.PHONY: setup-domain
setup-domain:
	cp docker/payara/local.domain.xml ./servers/payara5/glassfish/domains/domain1/config/domain.xml
