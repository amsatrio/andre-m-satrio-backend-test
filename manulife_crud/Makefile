.SILENT: build
.SILENT: build_skip_test
.SILENT: start
.SILENT: run
.SILENT: tes
.SILENT: clean
.SILENT: ngrok


build:
	./mvnw package -f pom.xml

build_skip_test:
	./mvnw package -f pom.xml -Dmaven.test.skip=true

start: build_skip_test
	java -Xms96m -Xmx256m -XX:+UseG1GC -XX:+UseStringDeduplication -jar ./target/manulife_crud-0.0.1-SNAPSHOT.jar



tes:
	./mvnw test -f pom.xml

clean:
	rm -rf ./target
	rm -rf ./logs
	rm -rf ./mobile_logs
	rm -rf ./db
	rm -rf ./tmp
	rm -rf /home/mos/.cache/sharedfolder/manulife_crud

remove_logs:
	rm -rf ./logs

initialize: clean
	mkdir -p /home/mos/.cache/sharedfolder/manulife_crud


ngrok:
	ngrok http --domain=correct-mink-loved.ngrok-free.app https://localhost:8085

run: remove_logs
	mvn spring-boot:run -X

docker:
	docker image rm manulife_crud-app --force
	docker compose up