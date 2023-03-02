run:
	./gradlew build
	java -jar ./app/build/libs/app-0.1.0.jar

dryrun:
	./gradlew shadowJar
	java -jar ./app/build/libs/app-0.1.0.jar

test:
	./gradlew test