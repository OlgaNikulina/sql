
# Подготовка приложения app-deadline.jar к тестированию в СУБД MySql

## Начало работы
1.  и docker-compose.yml. В docker-compose.yml прописать настройки запуска и переменные окружения: 
```
version: '3.7'
services:
  mysql:
    image: mysql:8.0.18
    restart: always
    ports:
      - "3306:3306"
    volumes:
      - ./init_db:/docker-entrypoint-initdb.d
    environment:
      - MYSQL_RANDOM_ROOT_PASSWORD=yes
      - MYSQL_DATABASE=app
      - MYSQL_USER=user
      - MYSQL_PASSWORD=pass
```                                                                                                                                                         
                                                                                                                                                                        
### Prerequisites
На ПК должна быть установлена JDK, IntelliJ IDEA, Docker Toolbox

### Установка и запуск
2. Запустить Docker Toolbox
3. docker-compose up 
(docker volume create schema.sql
docker-compose exec -T mysql mysql app -u app -p pass < init_db/schema.sql)
(docker-compose exec mysql mysql -u app -p app)
mysql> show databases;
   +--------------------+
   | Database           |
   +--------------------+
   | app                |
   | information_schema |
   +--------------------+
   2 rows in set (0.00 sec)
   
4. java -jar artifacts/app-deadline.jar -P:jdbc.url=jdbc:mysql://192.168.99.100:3306/app -P:jdbc.user=app -P:jdbc.password=pass

5. mysql> show tables;
   +-------------------+
   | Tables_in_app     |
   +-------------------+
   | auth_codes        |
   | card_transactions |
   | cards             |
   | users             |
   +-------------------+
   4 rows in set (0.00 sec)

6. При повторном запуске выполнить docker-compose down,  удалить /init_db, создать заново /init_db, положить туда схему, выполнить п.3, п.4. 