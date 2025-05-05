.PHONY: build
build:
	./gradlew clean build --warning-mode all

.PHONY: start
start:
	./../../../devtools/payara5/glassfish/bin/asadmin start-domain domain1

.PHONY: stop
stop:
	cd ../../../devtools/payara5/glassfish/bin/asadmin stop-domain