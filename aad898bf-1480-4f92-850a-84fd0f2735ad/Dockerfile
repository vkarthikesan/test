#
# Dockerfile to build SET Fusion Spring Applications
#
# Usage:
#
#       docker build . 
#
FROM set-nexus.digitalharbor.us:18444/set-fusion/dh-java-1.8
VOLUME /tmp
ADD aad898bf-1480-4f92-850a-84fd0f2735ad-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch /aad898bf-1480-4f92-850a-84fd0f2735ad-0.0.1-SNAPSHOT.jar'
ENV JAVA_OPTS=""
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /aad898bf-1480-4f92-850a-84fd0f2735ad-0.0.1-SNAPSHOT.jar" ]

