# Admin Spring Demo
Projeto de exemplo base feito com Spring Boot + Spring Security + Angularjs

## Configuração inicial
Crie o arquvo `application.properties` dentro da pasta `src/main/resources/` a partir do arquivo de exemplo `application.example.properties`. O arquivo contém a seguinte estrutura:

```properties
# Configurações do JDBC
spring.datasource.url=jdbc:mysql://localhost/<nome-do-banco-de-dados>
spring.datasource.username=<usuario-do-banco-de-dados>
spring.datasource.password=<senha-do-banco-de-dados>
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

# Configurações de JPA
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configurações de Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect

```
Onde:

`spring.datasource.url`: Armazena o nome do banco de dados.

`spring.datasource.username`: Armazena o nome de usuário do banco de dados.

`spring.datasource.password`: Armazena o senha de usuário do banco de dados.

`spring.datasource.driver-class-name`: Armazena o caminho (path) da classe 
Driver JDBC para conexão com o banco de dados.

`spring.jpa.show-sql`: Indica se o programa deve (true) ou não (false) exibir os sql's executados pela JPA.

`spring.jpa.properties.hibernate.format_sql`: Indica se o programa deve (true) ou não (false) formatar os sql's exibidos que foram executados pela JPA.

`spring.jpa.hibernate.ddl-auto`: Indica se o Hibernate deve atualizar a estrutura (DDL) das tabelas assim que identificar alguma alteração nos atributos de seus respectivos modelos (Entity).

`spring.jpa.database-platform`: Indica o path da classe de dialeto do Hibernate.

## Inicialização
Para iniciar o servidor do projeto basta executar como aplicaçõa `Sprint Boot`, pela IDE Eclipse ou STS ou executar o comando `mvn run:spring-boot` pelo terminal dentro da pasta raíz do projeto. Após o servidor da aplicação ter inicializado a interface do admin pode ser acessada no endereço: http://localhost:8080/admin.html
