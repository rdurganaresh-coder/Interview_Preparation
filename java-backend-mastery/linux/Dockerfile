FROM ubuntu:24.04

RUN apt-get update && apt-get install -y --no-install-recommends \
    bash \
    coreutils \
    grep \
    gawk \
    sed \
    findutils \
    procps \
    iproute2 \
    curl \
    netcat-openbsd \
    jq \
    vim \
    cron \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /workspace
COPY scripts/ /workspace/scripts/
COPY sample-logs/ /workspace/sample-logs/
RUN chmod +x /workspace/scripts/*.sh

CMD ["sleep", "infinity"]
