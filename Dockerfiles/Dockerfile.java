FROM registry.access.redhat.com/ubi8/ubi
ARG ECOSYSTEM_VERSION=maven
LABEL org.opencontainers.image.source https://github.com/fabric8-analytics/crda-images
RUN yum install -y $ECOSYSTEM_VERSION; yum clean all

RUN rpm -i https://github.com/fabric8-analytics/cli-tools/releases/download/v0.2.2/crda_0.2.2_Linux-64bit.rpm

RUN yum install jq -y

ENV AUTH_TOKEN=''
ENV CRDA_KEY=''
ENV HOST=''
ENV CONSENT_TELEMETRY='false'

COPY scripts/crda.sh /
RUN chmod +x /crda.sh
