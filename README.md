# Calculadora Java Web

Uma calculadora web moderna desenvolvida com Java 8, JSF e PrimeFaces, com tema Blitzer para uma interface elegante e profissional. A calculadora possui display duplo similar ao Windows, mostrando o histórico das operações e o resultado.

## Características

- Interface moderna e responsiva com tema **Blitzer**
- **Display duplo estilo Windows** (histórico + resultado)
- Operações matemáticas básicas (+, -, ×, ÷)
- Operações especiais (raiz quadrada, porcentagem)
- Tratamento de erros
- Design elegante com visual escuro/metálico
- Tema PrimeFaces Blitzer 1.0.10
- **CSS separado** para melhor organização do código

## Tecnologias Utilizadas

- **Java 8**
- **JSF 2.2** (JavaServer Faces)
- **PrimeFaces 8.0**
- **Tema Blitzer 1.0.10** para interface elegante
- **Maven** para gerenciamento de dependências
- **Jetty** como servidor embarcado para desenvolvimento
- **HTML5/CSS3** para interface moderna
- **Arquitetura de recursos JSF** para organização de assets

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
- **Display duplo**: Histórico das operações na parte superior e resultado na inferior
- **Experiência similar ao Windows Calculator**

## Como Executar

### Pré-requisitos
- Java 8 ou superior
- Maven 3.6 ou superior

### Opção 1: Execução Rápida com Jetty (Recomendado)

1. **Clone ou baixe o projeto**
   ```bash
   git clone <url-do-repositorio>
   cd calculadora-java-web
   ```

2. **Execute diretamente com Jetty**
   ```bash
   mvn jetty:run
   ```

3. **Acesse a aplicação**
   - Abra o navegador e acesse: `http://localhost:8081/calculadora`

### Opção 2: Deploy no GlassFish

#### Pré-requisitos Adicionais
- GlassFish Server 5.x ou superior

#### Passos para Execução

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

### Comandos Úteis

#### Jetty
```bash
# Executar com Jetty (porta 8081)
mvn jetty:run

# Parar o servidor (Ctrl+C no terminal)
```

#### GlassFish
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

## Tema Blitzer

A aplicação utiliza o tema **Blitzer 1.0.10** do PrimeFaces, que oferece:

- Visual escuro e elegante
- Efeitos metálicos modernos
- Interface profissional
- Melhor experiência do usuário

### Instalação do Tema

O tema já está incluído no projeto. O arquivo `blitzer-1.0.10.jar` está localizado em:
```
src/main/webapp/WEB-INF/lib/blitzer-1.0.10.jar
```

Para alterar o tema, modifique o parâmetro no `web.xml`:
```xml
<context-param>
    <param-name>primefaces.THEME</param-name>
    <param-value>blitzer</param-value>
</context-param>
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
│           │   ├── lib/
│           │   │   └── blitzer-1.0.10.jar
│           │   ├── web.xml
│           │   └── faces-config.xml
│           ├── resources/
│           │   └── css/
│           │       └── styles.css
│           └── index.xhtml
├── pom.xml
└── README.md
```

## Arquitetura

- **CalculadoraBean**: Managed Bean que contém a lógica de negócio da calculadora e gerencia o histórico das operações
- **index.xhtml**: Interface do usuário usando componentes PrimeFaces com tema Blitzer e display duplo
- **resources/css/styles.css**: Arquivo CSS separado com todos os estilos da aplicação
- **web.xml**: Configuração do servlet JSF e tema PrimeFaces
- **faces-config.xml**: Configurações adicionais do JSF
- **blitzer-1.0.10.jar**: Arquivo do tema Blitzer para interface elegante

## URLs de Acesso

- **Jetty (Desenvolvimento)**: `http://localhost:8081/calculadora`
- **GlassFish (Produção)**: `http://localhost:8080/calculadora-java-web`

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades.

## Melhorias Implementadas

### Display Duplo (Windows-like)
- **Histórico das operações**: Mostra a sequência completa da operação (ex: "5 + 3 =")
- **Resultado**: Exibe o valor atual/resultado da operação
- **Estilo diferenciado**: Histórico em fonte menor e cinza, resultado em fonte maior e negrito
- **Comportamento similar ao Windows Calculator**

### Organização de Código
- **CSS separado**: Todos os estilos movidos para `resources/css/styles.css`
- **Arquitetura JSF padrão**: Uso da estrutura `webapp/resources/` para assets
- **Melhor manutenibilidade**: Separação clara entre lógica, apresentação e estilos
## Licença

Este projeto é de uso livre para fins educacionais e de aprendizado.