# V SEC - 2025: API de Inscrições em Cursos

Este projeto consiste no desenvolvimento de uma API REST utilizando Spring Boot, voltada para o gerenciamento de alunos, cursos e inscrições em cursos.

## Tecnologias Utilizadas
* Java (versão 17 ou superior, conforme utilizado no Spring Initializr)
* Spring Boot
    * Spring Web (para APIs REST)
    * Spring Data JPA (para persistência de dados)
* Hibernate (implementação JPA)
* Maven (para gerenciamento de dependências e build)
* MySQL (como banco de dados)
* Lombok (para reduzir código boilerplate)

## Principais Funcionalidades
* Gerenciamento completo (CRUD) de Alunos.
* Gerenciamento completo (CRUD) de Cursos.
* Gerenciamento de Inscrições:
    * Inscrever um aluno em um curso.
    * Remover a inscrição de um aluno de um curso.
    * Listar todas as inscrições.

## Pré-requisitos
* JDK 17 ou superior instalado.
* Maven instalado.
* Servidor MySQL em execução.

## Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/ojorgg/sec2025.git](https://github.com/ojorgg/sec2025.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd sec2025
    ```

3.  **Configure o Banco de Dados:**
    * Certifique-se de que você tem um banco de dados MySQL chamado `eventos_if` criado ou permita que o Hibernate o crie (conforme `createDatabaseIfNotExist=true` na URL de conexão).
    * Ajuste as configurações de acesso ao banco de dados no arquivo `src/main/resources/application.properties`:
        ```properties
        spring.application.name=api-inscricoes #

        # usuário e senha de conexão com o banco de dados #
        spring.datasource.username=root #  # Altere se necessário
        spring.datasource.password=ifsp #  # Altere se necessário

        # url de conexão do banco de dados #
        spring.datasource.url=jdbc:mysql://localhost:3306/eventos_if?useSSL=false&useUnicode=yes&characterEncoding=UTF-8&useLegacyDatetimeCode=true&createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC #

        # apontamos para o JPA e Hibernate qual é o Dialeto do banco de dados #
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect #
        spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect #

        # deixamos o hibernate responsável por ler nossas entidades e criar as tabelas do nosso banco de dados automaticamente #
        spring.jpa.hibernate.ddl-auto=update #

        # configurações de log #
        spring.jpa.show-sql=true #
        spring.jpa.properties.hibernate.format_sql=true #
        spring.jpa.properties.hibernate.show_sql=true #
        spring.jpa.properties.hibernate.use_sql_comments=true #
        ```

4.  **Execute a Aplicação:**
    * Você pode usar o Maven wrapper:
        ```bash
        ./mvnw spring-boot:run
        ```
    * Ou importar o projeto na sua IDE preferida (IntelliJ IDEA, VSCode, Eclipse) e executá-lo a partir dela.

A API estará disponível em `http://localhost:8080` (porta padrão do Spring Boot).

## Endpoints da API

A seguir, uma lista dos principais endpoints disponíveis:

### Cursos
* `GET /cursos`: Retorna todos os cursos cadastrados.
* `GET /cursos/{id}`: Busca um curso específico pelo seu ID.
* `POST /cursos`: Cadastra um novo curso.
    * Corpo da requisição (JSON):
        ```json
        {
          "nome": "Curso de Spring Boot",
          "descricao": "Introdução ao desenvolvimento com Spring Boot",
          "ministrante": "Prof. Silva",
          "quantidade_maxima": 25
        }
        ```
* `PUT /cursos/{id}`: Atualiza as informações de um curso existente.
* `DELETE /cursos/{id}`: Remove um curso.

### Alunos
* `GET /alunos`: Retorna a lista completa de alunos.
* `GET /alunos/{id}`: Busca um aluno específico pelo seu ID.
* `POST /alunos`: Cadastra um novo aluno.
    * Corpo da requisição (JSON):
        ```json
        {
          "nome": "Fulano de Tal",
          "prontuario": "SP1234567"
        }
        ```
* `PUT /alunos/{id}`: Atualiza os dados de um aluno existente.
* `DELETE /alunos/{id}`: Remove um aluno.

### Inscrições
* `GET /inscricoes`: Lista todas as inscrições.
* `POST /inscricoes`: Inscreve um aluno em um curso.
    * Corpo da requisição (JSON):
        ```json
        {
          "id_aluno": 1,
          "id_curso": 2
        }
        ```
* `DELETE /inscricoes`: Remove uma inscrição (desinscreve o aluno do curso).
    * Corpo da requisição (JSON):
        ```json
        {
          "id_aluno": 1,
          "id_curso": 2
        }
        ```
## Estrutura do Projeto
O projeto segue a estrutura padrão de aplicações Spring Boot, com os principais pacotes organizados da seguinte forma:
