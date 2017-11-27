#
# Dockerfile to build SET Fusion Spring Applications
#
# Usage:
#
#       docker build . 
#
FROM set-nexus.digitalharbor.us:18444/set-fusion/dh-java-1.8
VOLUME /tmp
ADD 3ccc9572-65b1-468f-925f-39cccd04e3bd-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch /3ccc9572-65b1-468f-925f-39cccd04e3bd-0.0.1-SNAPSHOT.jar'
ENV JAVA_OPTS=""
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /3ccc9572-65b1-468f-925f-39cccd04e3bd-0.0.1-SNAPSHOT.jar" ]

