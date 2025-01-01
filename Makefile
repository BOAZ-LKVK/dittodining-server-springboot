APP?=dittodining-mysql
DEFAULT_PASSWORD?=password
DB_NAME?=dittodining

all: run-mysql

run-mysql:
	@echo '[client]\npassword=$(DEFAULT_PASSWORD)' > /tmp/mysqlconfig.cnf
	@docker run --rm -d \
			--name $(APP) \
			-e MYSQL_ROOT_HOST=% \
			-e MYSQL_ROOT_PASSWORD=$(DEFAULT_PASSWORD) \
			-e MYSQL_DATABASE=$(DB_NAME) \
			-v /tmp/mysqlconfig.cnf:/mysql/config.cnf \
			-p 3306:3306 \
			mysql:8.4.3 \
				--character-set-server=utf8mb4
				--explicit_defaults_for_timestamp=true

.PHONY: run-mysql