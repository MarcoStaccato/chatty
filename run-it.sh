#!/bin/bash

docker pull selenoid/chrome:66.0

cd docker
docker-compose up -d
sleep 30

cd ..
mvn test
