#!/bin/bash

start_web_pod() {
  WEB_JVM_ARGUS=""

  DEFAULT_JVM_ARGUMENTS="-XX:+UseG1GC -XX:+HeapDumpOnOutOfMemoryError -XX:NewRatio=1 "

  WEB_JVM_ARGUS="${WEB_JVM_ARGUS} ${JAVA_OPTS} ${DEFAULT_JVM_ARGUMENTS}"

  echo "JVM arguments  : ${WEB_JVM_ARGUS}"
  exec java $WEB_JVM_ARGUS   -Dspring.profiles.active=$APP_MODE -Dlog4j2.formatMsgNoLookups=true -jar app.jar
}

# shellcheck disable=SC2039
if [[ "${APP_MODE}" == "dev_docker" ]]; then
    sleep_duration=5
    start_web_pod
else
    app_type=$1
    ## Now, based on the app type, call the specific functions
    if [[ "${app_type}" == "web" ]]; then
        echo "$(date) Starting web app"
        start_web_pod
    fi
fi