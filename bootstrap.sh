#!/usr/bin/env bash
java -jar -Ddw.server.applicationConnectors[0].port=$PORT -Xmx350m -Xss512k -Dfile.encoding=UTF-8 rest.jar server config.yml
#java -jar rest.jar server config.yml