FROM openjdk:17-slim as builder

WORKDIR /app

RUN apt-get update && \
    apt-get install -y curl unzip && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# payaraのダウンロード
RUN mkdir payara && cd payara && \ 
    curl -O https://repo1.maven.org/maven2/fish/payara/distributions/payara/5.2022.5/payara-5.2022.5.zip && \
    unzip payara-5.2022.5.zip 

COPY ./docker/payara/local.domain.xml /app/payara/payara5/glassfish/domains/domain1/config

COPY . .
RUN ./gradlew clean build --warning-mode all && \
    cp /app/build/libs/mini.war /app/payara/payara5/glassfish/domains/domain1/autodeploy && \
    mv /app/payara/payara5/glassfish/domains/domain1/config/local.domain.xml /app/payara/payara5/glassfish/domains/domain1/config/domain.xml


FROM openjdk:17-slim
EXPOSE 4848 8080
WORKDIR /payara5
COPY --from=builder /app/payara/payara5 .


# TODO: パスワード周りを修正しておく
# パスワードファイルの準備
RUN echo "AS_ADMIN_PASSWORD=" > /tmp/pwd.txt && \
    echo "AS_ADMIN_NEWPASSWORD=admin" >> /tmp/pwd.txt && \
    ./glassfish/bin/asadmin --user admin --passwordfile /tmp/pwd.txt change-admin-password

# TODO: パスワード周りを修正しておく
# 起動して enable-secure-admin を実行してから止める
RUN echo "AS_ADMIN_PASSWORD=admin" > /tmp/pwd2.txt && \
    ./glassfish/bin/asadmin start-domain && \
    ./glassfish/bin/asadmin --user admin --passwordfile /tmp/pwd2.txt enable-secure-admin && \
    ./glassfish/bin/asadmin stop-domain && \
    rm /tmp/pwd.txt /tmp/pwd2.txt

CMD ["/payara5/glassfish/bin/asadmin", "start-domain", "--verbose", "domain1"]  