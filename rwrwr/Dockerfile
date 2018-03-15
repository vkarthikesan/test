#
# Dockerfile to build SET Fusion Spring Applications
#
# Usage:
#
#       docker build . 
#
FROM set-nexus.digitalharbor.us:18444/set-fusion/dh-java-1.8
VOLUME /tmp
ADD target/rwrwr-1.1-RELEASE.jar /
RUN sh -c 'touch /rwrwr-1.1-RELEASE.jar'
ENV JAVA_OPTS=""
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /rwrwr-1.1-RELEASE.jar" ]

