# Project Spring Boot
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/lucasbassetto/project-xbrain/blob/main/LICENSE) 

# Sobre o projeto

Este projeto é uma aplicação back-end construída para o teste da empresa **Xbrain**.

A aplicação possui os seguintes objetivos: 
- Criar projeto Spring Boot Java
- Implementar modelo de domínio
- Estruturar camadas lógicas: resource, service, repository
- Configurar banco de dados (H2)
- Povoar o banco de dados
- CRUD - Create, Retrieve, Update, Delete
- Tratamento de exceções

Requisitos Funcionais:
- Criar uma nova venda

- Total de vendas do vendedor e média de vendas diária, conforme o período informado por parâmetro

Para este projeto, eu crei uma classe "TestConfig" - onde foram instanciados 2 vendedores ("Lucas Bassetto" e "Joao das neves") e algumas vendas para "povoar" a aplicação. Dito isto, segue abaixo os prints da ferramenta Postman para criação de um novo vendedor, uma nova venda e o total de vendas do vendedor e média de vendas diária, conforme o período informado por parâmetro


## Criando vendedor
![Criando vendedor](https://github.com/lucasbassetto/assets/blob/main/Xbrain/criacao-vendedor.png?raw=true)

<br/>

## Retornando vendedores
![Retornando vendedores](https://github.com/lucasbassetto/assets/blob/main/Xbrain/get-vendedores.png?raw=true)

<br/>

## Criando venda
![Criando venda](https://github.com/lucasbassetto/assets/blob/main/Xbrain/criando-venda.png?raw=true)

<br/>

## Retornando vendas
![Retornando vendas](https://github.com/lucasbassetto/assets/blob/main/Xbrain/get-vendas.png?raw=true)

- Repare que a nova venda foi retornada com sucesso.

<br/>

## Retornando vendas conforme parâmetro
![Retornando vendas conforme parâmetro](https://github.com/lucasbassetto/assets/blob/main/Xbrain/get-vendas-parametro.png?raw=true)

- Repare neste print que a data passada como parâmetro foi 12-02-2023 e 19-02-2023 (7 dias);

- Por conta da "povoação" feita por mim anteriormente, o vendedor "Lucas Bassetto" possui 14 vendas no total, sendo 2 vendas médias por dia. 

- O vendedor "Joao das Neves" possui 7 vendas no total, sendo 1 venda média por dia.

- O vendedor "Jesse Pinkman" possui apenas 1 venda, que foi feita anteriormente com o método POST conforme o print "Criando venda".

<br/>

## Adicionando mais vendas
![Adicionando mais vendas](https://github.com/lucasbassetto/assets/blob/main/Xbrain/add-venda-id-3_1.png?raw=true)

- Adicionando uma venda para o vendedor "Jesse Pinkman".

## Adicionando mais vendas 
![Adicionando mais vendas ](https://github.com/lucasbassetto/assets/blob/main/Xbrain/add-venda-id-3_2.png?raw=true)

- Adicionando uma venda para o vendedor "Jesse Pinkman".

- Repare que nos 2 prints acima eu adicionei mais 2 vendas ao vendedor "Jesse Pinkman".

<br/>

## Retornando as vendas atualizadas
![Retornando as vendas atualizadas](https://github.com/lucasbassetto/assets/blob/main/Xbrain/get-vendas-atualizado.png?raw=true)

- Repare que as novas vendas de id "23" e "24" foram retornadas com sucesso após a inclusão das mesmas.

<br/>

## Retornando as vendas com parâmetros atualizadas
![Retornando as vendas com parâmetros atualizadas](https://github.com/lucasbassetto/assets/blob/main/Xbrain/get-vendas-parametro-atualizado.png?raw=true)

- Repare no print que as vendas conforme período informado foram atualizadas. O vendedor "Jesse Pinkman" agora possui 3 vendas no total, haja vista que foram adicionadas mais 2 vendas para o mesmo.

## Teste 1
![Teste 1](https://github.com/lucasbassetto/assets/blob/main/Xbrain/TesteSale1.png?raw=true)

## Teste 2
![Teste 2](https://github.com/lucasbassetto/assets/blob/main/Xbrain/TesteSeller1.png?raw=true)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven


## Implantação em produção
- Banco de dados: H2

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/lucasbassetto/project-xbrain

# executar o projeto
./mvnw spring-boot:run
```

# Autor

Lucas Feliciano Bassetto

https://www.linkedin.com/in/lucasbassetto
