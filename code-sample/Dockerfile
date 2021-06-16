FROM  us.gcr.io/iaas-gcr-reg-prd-ad3d/intl-spain/openjre:8-jre-slim

# Arguments for Build Metadata
ARG GIT_COMMIT
ARG GIT_URL
ARG GIT_BRANCH
ARG BUILD_NUMBER
ARG BUILD_URL

LABEL maintainer="Rodrigo Martinez (rodrigomartgon@gmail.com)" \
      GIT_COMMIT="${GIT_COMMIT}" \
      GIT_URL="${GIT_URL}" \
      GIT_BRANCH="${GIT_BRANCH}" \
      BUILD_NUMBER="${BUILD_NUMBER}" \
      BUILD_URL="${BUILD_URL}"
      


# Argument for Jar file
ARG JAR_FILE

COPY /code-sample-jar/target/${JAR_FILE} /app/code-sample.jar

