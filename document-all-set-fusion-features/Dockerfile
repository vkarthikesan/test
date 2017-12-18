#
# Dockerfile to build SET Fusion Spring Applications
#
# Usage:
#
#       docker build . 
#
FROM set-nexus.digitalharbor.us:18444/set-fusion/dh-java-1.8
VOLUME /tmp
ADD document-all-set-fusion-features-1.0-RELEASE.jar /
RUN sh -c 'touch /document-all-set-fusion-features-1.0-RELEASE.jar'
ENV JAVA_OPTS=""
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /document-all-set-fusion-features-1.0-RELEASE.jar" ]

