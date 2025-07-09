# Med Voll API

## Descrição do Projeto

A **Med Voll API** é uma aplicação RESTful desenvolvida em **Java** com o framework **Spring Boot**, projetada para o gerenciamento de pacientes em um sistema médico. Ela oferece funcionalidades completas para o ciclo de vida do paciente no sistema, desde o cadastro até a "exclusão suave" dos registros.

O projeto segue as melhores práticas de desenvolvimento, utilizando uma arquitetura modular, transações gerenciadas pelo Spring e DTOs (Data Transfer Objects) para uma comunicação eficiente e segura.

---

## Funcionalidades Principais

* **Cadastro de Pacientes (POST /pacientes):**
    * Permite cadastrar novos pacientes no sistema.
    * Implementa validação de dados de entrada (`Jakarta Validation`) para garantir a integridade das informações antes de persistir no banco de dados.

* **Listagem de Pacientes (GET /pacientes):**
    * Retorna uma lista paginada de pacientes.
    * Filtra e exibe apenas pacientes com o status `ativo = true`.
    * A lista é ordenada por nome para facilitar a visualização.

* **Atualização de Pacientes (PUT /pacientes):**
    * Permite atualizar as informações de um paciente existente.
    * O paciente é localizado pelo seu ID, e os dados fornecidos na requisição são utilizados para a atualização.

* **Exclusão "Suave" de Pacientes (DELETE /pacientes/{id}):**
    * Implementa um "soft delete", onde o paciente não é removido fisicamente do banco de dados.
    * O campo `ativo` do paciente é alterado para `false`, mantendo o histórico e garantindo a integridade referencial.

---

## Tecnologias Utilizadas

* **Java 17+** (ou a versão que você usou)
* **Spring Boot 3.x** (ou a versão que você usou)
* **Spring Data JPA**: Para persistência de dados e interação com o banco de dados.
* **MySQL**: Banco de dados relacional utilizado para armazenar os dados dos pacientes.
* **Maven**: Gerenciador de dependências do projeto.
* **Jakarta Validation**: Para validação de dados de entrada na API.
* **Insomnia**: Ferramentas recomendadas para testar as requisições da API.

---

## Estrutura do Projeto

O projeto é organizado da seguinte forma:

* `src/main/java/com/voll/med/api/controller/`: Contém a classe `PacienteController`, responsável por mapear as requisições HTTP e delegar as operações.
* `src/main/java/com/voll/med/api/repository/`: Inclui a interface `PacienteRepository`, que estende `JpaRepository` para abstrair as operações de banco de dados.
* `src/main/java/com/voll/med/api/domain/paciente/`: Onde está localizada a entidade `Paciente`, que representa a tabela de pacientes no banco de dados, e as classes DTOs (`DadosCadastroPaciente`, `DadosAtualizacaoPaciente`, etc.) para a transferência de dados.

---

## Como Rodar o Projeto

1.  **Pré-requisitos:**
    * Java Development Kit (JDK) 17 ou superior instalado.
    * Maven instalado.
    * Um servidor MySQL configurado e rodando.

2.  **Configuração do Banco de Dados:**
    * Crie um banco de dados MySQL para o projeto (ex: `medvoll_api`).
    * Configure as credenciais do banco de dados no arquivo `src/main/resources/application.properties` ou `application.yml`:

        ```properties
        # Exemplo para application.properties
        spring.datasource.url=jdbc:mysql://localhost:3306/medvoll_api?useTimezone=true&serverTimezone=UTC
        spring.datasource.username=seu_usuario_mysql
        spring.datasource.password=sua_senha_mysql
        spring.jpa.hibernate.ddl-auto=update # Ou create, create-drop, none
        spring.jpa.show-sql=true
        ```

3.  **Compilação e Execução:**
    * Clone o repositório do projeto:
        ```bash
        git clone <URL_DO_SEU_REPOSITORIO>
        cd medvoll-api
        ```
    * Compile o projeto usando Maven:
        ```bash
        mvn clean install
        ```
    * Execute a aplicação:
        ```bash
        mvn spring-boot:run
        ```
        A API estará disponível em `http://localhost:8080` (ou na porta configurada).

---

## Endpoints da API

A API expõe os seguintes endpoints:

* **`POST /pacientes`**: Cadastra um novo paciente.
    * **Corpo da Requisição (Exemplo):**
        ```json
        {
            "nome": "João Silva",
            "email": "joao.silva@example.com",
            "telefone": "11987654321",
            "cpf": "123.456.789-00",
            "endereco": {
                "logradouro": "Rua das Flores",
                "bairro": "Centro",
                "cep": "01234-567",
                "cidade": "São Paulo",
                "uf": "SP",
                "numero": "100",
                "complemento": "Apto 10"
            }
        }
        ```
    * **Resposta (Exemplo - Status 201 Created):**
        ```json
        {
            "id": 1,
            "nome": "João Silva",
            "email": "joao.silva@example.com",
            "telefone": "11987654321"
        }
        ```

* **`GET /pacientes`**: Lista pacientes ativos com paginação.
    * **Parâmetros de Query (Exemplo):** `?page=0&size=10&sort=nome,asc`
    * **Resposta (Exemplo - Status 200 OK):**
        ```json
        {
            "content": [
                {
                    "id": 1,
                    "nome": "João Silva",
                    "email": "joao.silva@example.com",
                    "cpf": "123.456.789-00"
                    // ... outros detalhes do paciente ...
                }
            ],
            "pageable": { ... },
            "last": true,
            "totalPages": 1,
            "totalElements": 1,
            "size": 10,
            "number": 0,
            "sort": { ... },
            "first": true,
            "numberOfElements": 1,
            "empty": false
        }
        ```

* **`PUT /pacientes`**: Atualiza um paciente existente.
    * **Corpo da Requisição (Exemplo):**
        ```json
        {
            "id": 1,
            "nome": "João Silva Atualizado",
            "telefone": "11998877665",
            "endereco": {
                "cidade": "Rio de Janeiro"
            }
        }
        ```
    * **Resposta (Exemplo - Status 200 OK):** (Retorna os dados atualizados do paciente)

* **`DELETE /pacientes/{id}`**: Marca um paciente como inativo (soft delete).
    * **Exemplo de URL:** `DELETE /pacientes/1`
    * **Resposta (Status 204 No Content):** Sucesso na operação sem conteúdo de retorno.

---

## Contribuições

Sinta-se à vontade para contribuir com este projeto! Se você encontrar bugs, tiver sugestões de melhoria ou quiser adicionar novas funcionalidades, por favor, abra uma issue ou envie um pull request.

---

## 👨‍💻 Autor

Feito por **Petterson Oliveira**  
Aluno do programa **Oracle Next Education - ONE** e **Tecnólogo da faculdade Celso Lisboa** 🚀  
