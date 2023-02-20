### You need to follow the steps to run the project

1. ``mvn clean verify``
    * you can check the jacoco report unit test inside the file /target/site
2. we can run the project calling this cmd  `` mvn spring-boot:run ``
   or
   ``mvn package spring-boot:repackage`` and then
   ``java --jar ./target/harry-kart-1.0-SNAPSHOT.jar``