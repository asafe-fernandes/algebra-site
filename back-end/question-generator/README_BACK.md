## Como Rodar o Projeto Spring com Maven e Java 17

### Pré-requisitos

Certifique-se de que os seguintes programas estão instalados em sua máquina:

1. **Java Development Kit (JDK) 17**
   - Faça o download do JDK 17 em: [Oracle JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou [OpenJDK](https://jdk.java.net/17/).
   - Após a instalação, verifique se está configurado corretamente:
     ```bash
     java -version
     ```
     O comando deve retornar algo como:
     ```bash
     java version "17.x.x"
     ```

2. **Maven**
   - Baixe o Maven em: [Apache Maven](https://maven.apache.org/download.cgi).
   - Após a instalação, verifique a configuração:
     ```bash
     mvn -version
     ```
     O comando deve retornar a versão do Maven instalada.

### Clonar o Repositório

Clone o projeto utilizando o Git:

```bash
git clone https://github.com/asafe-fernandes/algebra-site.git
cd algebra-site/back-end/question-generator
```

### Como Rodar o Projeto

1. Execute o comando abaixo para instalar as dependências do projeto:

   ```bash
   mvn clean install
   ```

2. Após a instalação, execute o projeto com o comando:

   ```bash
   mvn spring-boot:run
   ```

3. O servidor estará disponível no endereço padrão: [http://localhost:8080](http://localhost:8080).

### Gerar um JAR Executável

Para gerar um arquivo `.jar` executável, siga os passos abaixo:

1. Crie o pacote com o Maven:

   ```bash
   mvn clean package
   ```

2. Após o build, execute o arquivo `.jar` gerado no diretório `target`:

   ```bash
   java -jar target/question-generator-x.x.x.jar
   ```


### Observações

- Certifique-se de que a porta `8080` não está em uso antes de executar o projeto.

