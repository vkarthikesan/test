#
# Dockerfile to build SET Fusion Spring Applications
#
# Usage:
#
#       docker build . 
#
FROM set-nexus.digitalharbor.us:18444/set-fusion/dh-java-1.8
VOLUME /tmp
ADD target/111-3ccc9572-65b1-468f-925f-39cccd04e-0.0.1.jar /
RUN sh -c 'touch /111-3ccc9572-65b1-468f-925f-39cccd04e-0.0.1.jar'
ENV JAVA_OPTS=""
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /111-3ccc9572-65b1-468f-925f-39cccd04e-0.0.1.jar" ]

