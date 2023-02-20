# Docker cmd
#if [ -d "./target/" ]
#then
#	rm -r target/
#fi
#
#docker build -t harry-kart-image .
#docker create -it --name harry-kart harry-kart-image bash
#docker cp harry-kart:/target ./target
#docker rm -f harry-kart
#Then we can build the jar using the command lines exist in how_to_run.md

FROM maven:3.8.2-adoptopenjdk-15

COPY . .

RUN mvn clean package