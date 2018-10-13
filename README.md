# Agendamento de Transferência
Projeto que contempla a criação de transferências bancárias aplicando diferentes taxas de acordo com o valor e data de agendamento escolhidos.

Desenvolvido em Java 8.

#### Para iniciar a aplicação:
mvn spring-boot:run


#### Para executar os testes:
mvn test

#### URLs disponíveis:
http://localhost:8080/transferenciasRealizadas -> Lista todas as transferências realizadas.
http://localhost:8080/novaTransferencia -> Cadastra uma nova transferência

### Frameworks utilizados
Spring Boot Web: utilizado para criação do projeto web.
Spring MVC: utilizado para mapeamentos e lógicas do projeto web.
Spring Data JPA: utilizado para persitência de dados.
H2 Database: utilizado como banco de dados em memória.
Thymeleaf: engine para páginas HTML.
Maven: para gerenciamento de dependências e build.
jUnit: para execução de testes automatizados.
Bootstrap: utilizado para estilização das páginas HTML.

### Patterns
Utilização do padrão Strategy para contemplar as diferentes estratégias de cálculo de taxas aplicadas às transferências bancárias.