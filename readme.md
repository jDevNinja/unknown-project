Запуск БД в Docker:`docker run --name JavaSqlPostgresDatabase -p 5442:5432 -e POSTGRES_PASSWORD=pass -e POSTGRES_USER=user -d postgres:15`

Каждый запуск схема будет создаваться повторно из-за параметра `spring.jpa.hibernate.ddl-auto` 