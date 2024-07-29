# Use latest ubuntu as base
FROM ubuntu:latest

# Install some basic tools, then remove "available packages" folder
RUN apt-get update -y \
    && apt-get install -y \
    file \
    curl \
    git \
    unzip \
    zip \
    wget \
    && rm -rf /var/lib/apt/lists/*

# Upgrade all packages
RUN apt-get update -y \
    && apt-get upgrade -y \
    && rm -rf /var/lib/apt/lists/*

# Set up environment variables
ENV JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"

# Install OpenJDK
RUN apt-get update -y \
    && apt-get install -y openjdk-17-jdk \
    && rm -rf /var/lib/apt/lists/*

# Install Maven
RUN apt-get update -y \
    && apt-get install -y maven \
    && rm -rf /var/lib/apt/lists/*

EXPOSE 8080