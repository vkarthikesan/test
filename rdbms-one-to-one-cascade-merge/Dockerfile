#
# Dockerfile to build SET Fusion Spring Applications
#
# Usage:
#
#       docker build . 
#
FROM set-nexus.digitalharbor.us:18444/set-fusion/dh-java-1.8
VOLUME /tmp
ADD target/rdbms-one-to-one-cascade-merge-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch /rdbms-one-to-one-cascade-merge-0.0.1-SNAPSHOT.jar'
ENV JAVA_OPTS=""
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /rdbms-one-to-one-cascade-merge-0.0.1-SNAPSHOT.jar" ]

