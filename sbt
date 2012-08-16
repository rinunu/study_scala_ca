#!/bin/sh
test -f ~/.sbtconfig && . ~/.sbtconfig

SBT_OPTS="$SBT_OPTS -Dfile.encoding=utf-8"

exec java -Xmx512M ${SBT_OPTS} -jar sbt-launch.jar "$@"
