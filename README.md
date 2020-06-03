
# Подготовка приложения db-api.jar к тестированию в СУБД PostgreSql

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
1. docker-compose up 
(2. docker volume create schema.sql
3. docker-compose exec -T mysql mysql app -u app -p pass < init_db/schema.sql)
```mysql  Ver 8.0.18 for Linux on x86_64 (MySQL Community Server - GPL)
   Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.
   
   Oracle is a registered trademark of Oracle Corporation and/or its
   affiliates. Other names may be trademarks of their respective
   owners.
   
   Usage: mysql [OPTIONS] [database]
     -?, --help          Display this help and exit.
     -I, --help          Synonym for -?
     --auto-rehash       Enable automatic rehashing. One doesn't need to use
                         'rehash' to get table and field completion, but startup
                         and reconnecting may take a longer time. Disable with
                         --disable-auto-rehash.
                         (Defaults to on; use --skip-auto-rehash to disable.)
     -A, --no-auto-rehash
                         No automatic rehashing. One has to use 'rehash' to get
                         table and field completion. This gives a quicker start of
                         mysql and disables rehashing on reconnect.
     --auto-vertical-output
                         Automatically switch to vertical output mode if the
                         result is wider than the terminal width.
     -B, --batch         Don't use history file. Disable interactive behavior.
                         (Enables --silent.)
     --bind-address=name IP address to bind to.
     --binary-as-hex     Print binary data as hex
     --character-sets-dir=name
                         Directory for character set files.
     --column-type-info  Display column type information.
     -c, --comments      Preserve comments. Send comments to the server. The
                         default is --skip-comments (discard comments), enable
                         with --comments.
     -C, --compress      Use compression in server/client protocol.
     -#, --debug[=#]     This is a non-debug version. Catch this and exit.
     --debug-check       This is a non-debug version. Catch this and exit.
     -T, --debug-info    This is a non-debug version. Catch this and exit.
     -D, --database=name Database to use.
     --default-character-set=name
                         Set the default character set.
     --delimiter=name    Delimiter to be used.
     --enable-cleartext-plugin
                         Enable/disable the clear text authentication plugin.
     -e, --execute=name  Execute command and quit. (Disables --force and history
                         file.)
     -E, --vertical      Print the output of a query (rows) vertically.
     -f, --force         Continue even if we get an SQL error.
     --histignore=name   A colon-separated list of patterns to keep statements
                         from getting logged into syslog and mysql history.
     -G, --named-commands
                         Enable named commands. Named commands mean this program's
                         internal commands; see mysql> help . When enabled, the
                         named commands can be used from any line of the query,
                         otherwise only from the first line, before an enter.
                         Disable with --disable-named-commands. This option is
                         disabled by default.
     -i, --ignore-spaces Ignore space after function names.
     --init-command=name SQL Command to execute when connecting to MySQL server.
                         Will automatically be re-executed when reconnecting.
     --local-infile      Enable/disable LOAD DATA LOCAL INFILE.
     -b, --no-beep       Turn off beep on error.
     -h, --host=name     Connect to host.
     -H, --html          Produce HTML output.
     -X, --xml           Produce XML output.
     --line-numbers      Write line numbers for errors.
                         (Defaults to on; use --skip-line-numbers to disable.)
     -L, --skip-line-numbers
                         Don't write line number for errors.
     -n, --unbuffered    Flush buffer after each query.
     --column-names      Write column names in results.
                         (Defaults to on; use --skip-column-names to disable.)
     -N, --skip-column-names
                         Don't write column names in results.
     --sigint-ignore     Ignore SIGINT (CTRL-C).
     -o, --one-database  Ignore statements except those that occur while the
                         default database is the one named at the command line.
     --pager[=name]      Pager to use to display results. If you don't supply an
                         option, the default pager is taken from your ENV variable
                         PAGER. Valid pagers are less, more, cat [> filename],
                         etc. See interactive help (\h) also. This option does not
                         work in batch mode. Disable with --disable-pager. This
                         option is disabled by default.
     -p, --password[=name]
                         Password to use when connecting to server. If password is
                         not given it's asked from the tty.
     -P, --port=#        Port number to use for connection or 0 for default to, in
                         order of preference, my.cnf, $MYSQL_TCP_PORT,
                         /etc/services, built-in default (3306).
     --prompt=name       Set the mysql prompt to this value.
     --protocol=name     The protocol to use for connection (tcp, socket, pipe,
                         memory).
     -q, --quick         Don't cache result, print it row by row. This may slow
                         down the server if the output is suspended. Doesn't use
                         history file.
     -r, --raw           Write fields without conversion. Used with --batch.
     --reconnect         Reconnect if the connection is lost. Disable with
                         --disable-reconnect. This option is enabled by default.
                         (Defaults to on; use --skip-reconnect to disable.)
     -s, --silent        Be more silent. Print results with a tab as separator,
                         each row on new line.
     -S, --socket=name   The socket file to use for connection.
     --server-public-key-path=name
                         File path to the server public RSA key in PEM format.
     --get-server-public-key
                         Get server public key
     --ssl-mode=name     SSL connection mode.
     --ssl-ca=name       CA file in PEM format.
     --ssl-capath=name   CA directory.
     --ssl-cert=name     X509 cert in PEM format.
     --ssl-cipher=name   SSL cipher to use.
     --ssl-key=name      X509 key in PEM format.
     --ssl-crl=name      Certificate revocation list.
     --ssl-crlpath=name  Certificate revocation list path.
     --tls-version=name  TLS version to use, permitted values are: TLSv1, TLSv1.1,
                         TLSv1.2, TLSv1.3
     --ssl-fips-mode=name
                         SSL FIPS mode (applies only for OpenSSL); permitted
                         values are: OFF, ON, STRICT
     --tls-ciphersuites=name
                         TLS v1.3 cipher to use.
     -t, --table         Output in table format.
     --tee=name          Append everything into outfile. See interactive help (\h)
                         also. Does not work in batch mode. Disable with
                         --disable-tee. This option is disabled by default.
     -u, --user=name     User for login if not current user.
     -U, --safe-updates  Only allow UPDATE and DELETE that uses keys.
     -U, --i-am-a-dummy  Synonym for option --safe-updates, -U.
     -v, --verbose       Write more. (-v -v -v gives the table output format).
     -V, --version       Output version information and exit.
     -w, --wait          Wait and retry if connection is down.
     --connect-timeout=# Number of seconds before connection timeout.
     --max-allowed-packet=#
                         The maximum packet length to send to or receive from
                         server.
     --net-buffer-length=#
                         The buffer size for TCP/IP and socket communication.
     --select-limit=#    Automatic limit for SELECT when using --safe-updates.
     --max-join-size=#   Automatic limit for rows in a join when using
                         --safe-updates.
     --show-warnings     Show warnings after every statement.
     -j, --syslog        Log filtered interactive commands to syslog. Filtering of
                         commands depends on the patterns supplied via histignore
                         option besides the default patterns.
     --plugin-dir=name   Directory for client-side plugins.
     --default-auth=name Default authentication client-side plugin to use.
     --binary-mode       By default, ASCII '\0' is disallowed and '\r\n' is
                         translated to '\n'. This switch turns off both features,
                         and also turns off parsing of all clientcommands except
                         \C and DELIMITER, in non-interactive mode (for input
                         piped to mysql or loaded using the 'source' command).
                         This is necessary when processing output from mysqlbinlog
                         that may contain blobs.
     --connect-expired-password
                         Notify the server that this client is prepared to handle
                         expired password sandbox mode.
     --network-namespace=name
                         Network namespace to use for connection via tcp with a
                         server.
     --compression-algorithms=name
                         Use compression algorithm in server/client protocol.
                         Valid values are any combination of
                         'zstd','zlib','uncompressed'.
     --zstd-compression-level=#
                         Use this compression level in the client/server protocol,
                         in case --compression-algorithms=zstd. Valid range is
                         between 1 and 22, inclusive. Default is 3.
   
   Default options are read from the following files in the given order:
   /etc/my.cnf /etc/mysql/my.cnf ~/.my.cnf
   The following groups are read: mysql client
   The following options may be given as the first argument:
   --print-defaults        Print the program argument list and exit.
   --no-defaults           Don't read default options from any option file,
                           except for login file.
   --defaults-file=#       Only read default options from the given file #.
   --defaults-extra-file=# Read this file after the global files are read.
   --defaults-group-suffix=#
                           Also read groups with concat(group, suffix)
   --login-path=#          Read this path from the login file.
   
   Variables (--variable-name=value)
   and boolean options {FALSE|TRUE}  Value (after reading options)
   --------------------------------- ----------------------------------------
   auto-rehash                       TRUE
   auto-vertical-output              FALSE
   bind-address                      (No default value)
   binary-as-hex                     FALSE
   character-sets-dir                (No default value)
   column-type-info                  FALSE
   comments                          FALSE
   compress                          FALSE
   database                          (No default value)
   default-character-set             auto
   delimiter                         ;
   enable-cleartext-plugin           FALSE
   vertical                          FALSE
   force                             FALSE
   histignore                        (No default value)
   named-commands                    FALSE
   ignore-spaces                     FALSE
   init-command                      (No default value)
   local-infile                      FALSE
   no-beep                           FALSE
   host                              (No default value)
   html                              FALSE
   xml                               FALSE
   line-numbers                      TRUE
   unbuffered                        FALSE
   column-names                      TRUE
   sigint-ignore                     FALSE
   port                              0
   prompt                            mysql>
   quick                             FALSE
   raw                               FALSE
   reconnect                         FALSE
   socket                            (No default value)
   server-public-key-path            (No default value)
   get-server-public-key             FALSE
   ssl-ca                            (No default value)
   ssl-capath                        (No default value)
   ssl-cert                          (No default value)
   ssl-cipher                        (No default value)
   ssl-key                           (No default value)
   ssl-crl                           (No default value)
   ssl-crlpath                       (No default value)
   tls-version                       (No default value)
   tls-ciphersuites                  (No default value)
   table                             FALSE
   user                              app
   safe-updates                      FALSE
   i-am-a-dummy                      FALSE
   connect-timeout                   0
   max-allowed-packet                16777216
   net-buffer-length                 16384
   select-limit                      1000
   max-join-size                     1000000
   show-warnings                     FALSE
   plugin-dir                        (No default value)
   default-auth                      (No default value)
   binary-mode                       FALSE
   connect-expired-password          FALSE
   network-namespace                 (No default value)
   compression-algorithms            (No default value)
   zstd-compression-level            3
   
```
(4. docker-compose exec mysql mysql -u app -p app)
```Enter password:
   Welcome to the MySQL monitor.  Commands end with ; or \g.
   Your MySQL connection id is 17
   Server version: 8.0.18 MySQL Community Server - GPL
   
   Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.
   
   Oracle is a registered trademark of Oracle Corporation and/or its
   affiliates. Other names may be trademarks of their respective
   owners.
   
   Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.
   
   mysql> show databasis
```
5. mysql> show databases;
   +--------------------+
   | Database           |
   +--------------------+
   | app                |
   | information_schema |
   +--------------------+
   2 rows in set (0.00 sec)
   
6. java -jar artifacts/app-deadline.jar -P:jdbc.url=jdbc:mysql://192.168.99.100:3306/app -P:jdbc.user=app -P:jdbc.password=pass

```2020-05-29 00:44:38.445 [main] TRACE Application - {
       # application.conf @ jar:file:/C:/Users/Pepper/IdeaProjects/sql/app-deadline.jar!/application.conf: 6
       "application" : {
           # application.conf @ jar:file:/C:/Users/Pepper/IdeaProjects/sql/app-deadline.jar!/application.conf: 7
           "modules" : [
               # application.conf @ jar:file:/C:/Users/Pepper/IdeaProjects/sql/app-deadline.jar!/application.conf: 7
               "ru.netology.aqa.ApplicationKt.module"
           ]
       },
       # application.conf @ jar:file:/C:/Users/Pepper/IdeaProjects/sql/app-deadline.jar!/application.conf: 2
       "deployment" : {
           # application.conf @ jar:file:/C:/Users/Pepper/IdeaProjects/sql/app-deadline.jar!/application.conf: 3
           "port" : 9999
       },
       # Content hidden
       "security" : "***"
   }
   
   2020-05-29 00:44:38.588 [DefaultDispatcher-worker-1] INFO  Application - No ktor.deployment.watch patterns specified, automatic reload is not active
   Exception in thread "DefaultDispatcher-worker-1" java.lang.reflect.InvocationTargetException
           at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
           at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
           at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
           at java.base/java.lang.reflect.Method.invoke(Method.java:566)
           at kotlin.reflect.jvm.internal.calls.CallerImpl$Method.callMethod(CallerImpl.kt:97)
           at kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Static.call(CallerImpl.kt:106)
           at kotlin.reflect.jvm.internal.KCallableImpl.call(KCallableImpl.kt:106)
           at kotlin.reflect.jvm.internal.KCallableImpl.callDefaultMethod$kotlin_reflection(KCallableImpl.kt:152)
           at kotlin.reflect.jvm.internal.KCallableImpl.callBy(KCallableImpl.kt:110)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading.callFunctionWithInjection(ApplicationEngineEnvironmentReloading.kt:392)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading.executeModuleFunction(ApplicationEngineEnvironmentReloading.kt:340)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading.access$executeModuleFunction(ApplicationEngineEnvironmentReloading.kt:33)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading$instantiateAndConfigureApplication$1$$special$$inlined$forEach$lambda$1.invoke(ApplicationEngineEnvironmentReloadin
   g.kt:287)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading$instantiateAndConfigureApplication$1$$special$$inlined$forEach$lambda$1.invoke(ApplicationEngineEnvironmentReloadin
   g.kt:33)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading.avoidingDoubleStartupFor(ApplicationEngineEnvironmentReloading.kt:320)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading.access$avoidingDoubleStartupFor(ApplicationEngineEnvironmentReloading.kt:33)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading$instantiateAndConfigureApplication$1.invoke(ApplicationEngineEnvironmentReloading.kt:286)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading$instantiateAndConfigureApplication$1.invoke(ApplicationEngineEnvironmentReloading.kt:33)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading.avoidingDoubleStartup(ApplicationEngineEnvironmentReloading.kt:302)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading.instantiateAndConfigureApplication(ApplicationEngineEnvironmentReloading.kt:284)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading.createApplication(ApplicationEngineEnvironmentReloading.kt:137)
           at io.ktor.server.engine.ApplicationEngineEnvironmentReloading.start(ApplicationEngineEnvironmentReloading.kt:257)
           at io.ktor.server.cio.CIOApplicationEngine$serverJob$1$1.invokeSuspend(CIOApplicationEngine.kt:52)
           at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
           at kotlinx.coroutines.DispatchedTask.run(Dispatched.kt:241)
           at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:594)
           at kotlinx.coroutines.scheduling.CoroutineScheduler.access$runSafely(CoroutineScheduler.kt:60)
           at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:740)
   Caused by: java.sql.SQLException: Table 'app.users' doesn't exist Query: INSERT INTO users(id, login, password, status) VALUES (?, ?, ?, ?); Parameters: [4c8dde41-22e7-4018-848a-995ca8a6
   67f4, vasya, $2a$10$doFOwH0Y0hEIByhGi9fVuuwXv1XcV6siBETJ1SDvFa93IaCzRGwh., active]
           at org.apache.commons.dbutils.AbstractQueryRunner.rethrow(AbstractQueryRunner.java:527)
           at org.apache.commons.dbutils.QueryRunner.update(QueryRunner.java:531)
           at org.apache.commons.dbutils.QueryRunner.update(QueryRunner.java:497)
           at ru.netology.aqa.service.UserService$register$2.invokeSuspend(UserService.kt:31)
           ... 5 more
```
7. mysql> show tables;
   +-------------------+
   | Tables_in_app     |
   +-------------------+
   | auth_codes        |
   | card_transactions |
   | cards             |
   | users             |
   +-------------------+
   4 rows in set (0.00 sec)

