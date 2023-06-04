# API RESTful

Este é um projeto de exemplo que implementa uma API REST para gerenciamento de produtos. O objetivo deste projeto é demonstrar conceitos acadêmicos relacionados ao desenvolvimento de APIs RESTful, seguindo as melhores práticas e convenções.

## Conceitos Demonstrados

O projeto demonstra os seguintes conceitos acadêmicos:

1. **Arquitetura RESTful**: A API segue os princípios da arquitetura REST (Representational State Transfer), incluindo a utilização de verbos HTTP (GET, POST, PUT, DELETE) para operações em recursos, uso adequado de códigos de status HTTP e emprego de URIs semânticas para representar os recursos.

2. **Mapeamento de Requisições**: As requisições HTTP são mapeadas para métodos Java utilizando as anotações `@GetMapping`, `@PostMapping`, `@PutMapping` e `@DeleteMapping`. Isso permite que cada endpoint da API seja associado a uma operação específica.

3. **Documentação com Swagger**: A API utiliza a biblioteca Swagger para gerar automaticamente a documentação da API. A anotação `@ApiOperation` é usada para descrever cada endpoint, especificando seu propósito e detalhes sobre os parâmetros e respostas.

4. **Tratamento de Erros**: O código inclui o tratamento adequado de erros, retornando respostas HTTP apropriadas (como `NOT_FOUND`) quando um recurso não é encontrado ou ocorre um erro durante uma operação.

5. **Persistência de Dados**: O código utiliza um repositório chamado `RepositoryPhonesVersion` para realizar operações de leitura e gravação em um banco de dados. Isso demonstra o conceito de persistência de dados em uma API RESTful.

6. **HATEOAS (Hypertext as the Engine of Application State)**: O projeto utiliza a biblioteca Spring HATEOAS para adicionar links aos recursos retornados pela API. Os links fornecem navegação e descoberta de recursos relacionados, permitindo que os clientes da API obtenham informações adicionais ou executem operações relacionadas.

7. **Cross-Origin Resource Sharing (CORS)**: A anotação `@CrossOrigin` é usada para permitir solicitações de origens diferentes, permitindo que a API seja acessada por clientes em diferentes domínios.

## Executando o Projeto

Para executar o projeto, siga as etapas abaixo:

1. Certifique-se de ter o ambiente de desenvolvimento Java e o Maven instalados em sua máquina.

2. Faça o download do código-fonte do projeto ou clone o repositório Git.

3. Importe o projeto em sua IDE de preferência.

4. Certifique-se de ter uma instância do banco de dados configurada corretamente. Verifique as configurações de conexão com o banco de dados no arquivo `application.properties` ou `application.yml`.

5. Execute o aplicativo por meio do comando de compilação e execução fornecido pela sua IDE ou usando o Maven na linha de comando: `mvn spring-boot:run`.

6. A API estará disponível em `http://localhost:8080/api`. Você pode acessar a documentação da API em `http://localhost:8080/api/swagger-ui.html`.

## Contribuição

Este projeto é apenas um exemplo acadêmico e não está aberto para contribuições externas. Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE). Sinta-se à vontade para usá-lo como referência ou como base para seus próprios projetos.

