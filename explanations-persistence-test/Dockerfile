#
# Dockerfile to build SET Fusion Spring Applications
#
# Usage:
#
#       docker build . 
#
FROM set-nexus.digitalharbor.us:18444/set-fusion/dh-java-1.8
VOLUME /tmp
ADD explanations-persistence-test-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch /explanations-persistence-test-0.0.1-SNAPSHOT.jar'
ENV JAVA_OPTS=""
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /explanations-persistence-test-0.0.1-SNAPSHOT.jar" ]

