# Calculadora Java Web

Uma calculadora web moderna desenvolvida com Java 8, JSF e PrimeFaces.

## Características

- Interface moderna e responsiva
- Operações matemáticas básicas (+, -, ×, ÷)
- Operações especiais (raiz quadrada, porcentagem)
- Tratamento de erros
- Design elegante com gradientes e animações

## Tecnologias Utilizadas

- **Java 8**
- **JSF 2.2** (JavaServer Faces)
- **PrimeFaces 8.0**
- **Maven** para gerenciamento de dependências
- **HTML5/CSS3** para interface moderna

## Funcionalidades

### Operações Básicas
- Adição (+)
- Subtração (-)
- Multiplicação (×)
- Divisão (÷)

### Operações Especiais
- Raiz quadrada (√)
- Porcentagem (%)
- Limpar display (C)
- Apagar último dígito (⌫)

### Recursos Adicionais
- Suporte a números decimais
- Tratamento de divisão por zero
- Validação de entrada
- Mensagens de erro amigáveis
- Interface responsiva

## Como Executar

### Pré-requisitos
- Java 8 ou superior
- Maven 3.6 ou superior
- GlassFish Server 5.x ou superior

### Passos para Execução

1. **Clone ou baixe o projeto**
   ```bash
   git clone <url-do-repositorio>
   cd calculadora-java-web
   ```

2. **Compile o projeto**
   ```bash
   mvn clean compile
   ```

3. **Gere o arquivo WAR**
   ```bash
   mvn clean package
   ```

4. **Deploy no GlassFish**
   - Inicie o GlassFish Server: `asadmin start-domain`
   - Faça o deploy: `asadmin deploy target/calculadora-java-web.war`
   - Ou copie o arquivo `target/calculadora-java-web.war` para a pasta `autodeploy` do GlassFish

5. **Acesse a aplicação**
   - Abra o navegador e acesse: `http://localhost:8080/calculadora-java-web`

### Comandos GlassFish Úteis

```bash
# Iniciar o servidor
asadmin start-domain

# Fazer deploy da aplicação
asadmin deploy target/calculadora-java-web.war

# Parar o servidor
asadmin stop-domain

# Undeploy da aplicação
asadmin undeploy calculadora-java-web
```

## Estrutura do Projeto

```
calculadora-java-web/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/calculadora/bean/
│       │       └── CalculadoraBean.java
│       └── webapp/
│           ├── WEB-INF/
│           │   ├── web.xml
│           │   └── faces-config.xml
│           └── index.xhtml
├── pom.xml
└── README.md
```

## Arquitetura

- **CalculadoraBean**: Managed Bean que contém a lógica de negócio da calculadora
- **index.xhtml**: Interface do usuário usando componentes PrimeFaces
- **web.xml**: Configuração do servlet JSF
- **faces-config.xml**: Configurações adicionais do JSF

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades.

## Licença

Este projeto é de uso livre para fins educacionais e de aprendizado.