FROM openjdk:17-slim AS builder

WORKDIR /app

RUN apt-get update && \
    apt-get install -y curl unzip && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# payaraのダウンロード
RUN mkdir payara && cd payara && \ 
    curl -O https://repo1.maven.org/maven2/fish/payara/distributions/payara/5.2022.5/payara-5.2022.5.zip && \
    unzip payara-5.2022.5.zip 

COPY ./docker/payara/local.domain.xml /app/payara/payara5/glassfish/domains/domain1/config/domain.xml


# パスワードファイルの準備
RUN /app/payara/payara5/glassfish/bin/asadmin start-domain domain1 && \
    echo "AS_ADMIN_PASSWORD=" > /tmp/pwd.txt && \
    echo "AS_ADMIN_NEWPASSWORD=admin" >> /tmp/pwd.txt && \
    /app/payara/payara5/glassfish/bin/asadmin --user admin --passwordfile /tmp/pwd.txt change-admin-password && \
    echo "AS_ADMIN_PASSWORD=admin" > /tmp/pwd2.txt && \
    /app/payara/payara5/glassfish/bin/asadmin --user admin --passwordfile /tmp/pwd2.txt enable-secure-admin && \
    /app/payara/payara5/glassfish/bin/asadmin restart-domain && \
    /app/payara/payara5/glassfish/bin/asadmin stop-domain && \
    rm /tmp/pwd.txt /tmp/pwd2.txt 


COPY . .

RUN ./gradlew clean build --warning-mode all && \
    cp /app/build/libs/mini.war /app/payara/payara5/glassfish/domains/domain1/autodeploy


FROM openjdk:17-slim
EXPOSE 4848 8080
WORKDIR /payara5
COPY --from=builder /app/payara/payara5 .


CMD ["/payara5/glassfish/bin/asadmin", "start-domain", "--verbose", "domain1"]  