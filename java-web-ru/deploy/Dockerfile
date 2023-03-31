FROM gradle:8.0.1-jdk17

WORKDIR /java-web-ru/deploy/

COPY / .

RUN gradle installDist

CMD .build/install/deploy/bin/deploy
