### Projeto matéria de Padrões de Projeto
## Participantes:
# João Pedro Meira Messias
# Gabriel Rossa
# Gustavo Guedes
# Milena Schrickte


## Instruções para uso dos bancos de dados

Embora seja possível criar o banco de dados e a tabela diretamente na fábrica, geralmente é uma prática separar as 
responsabilidades. A fábrica de banco de dados é geralmente responsável apenas pela criação da instância do banco de 
dados, enquanto a criação do esquema do banco de dados (como tabelas) é geralmente feita em outro lugar, como scripts 
de inicialização ou manualmente usando ferramentas de administração de banco de dados.
No caso indicamos que para o database MySql seja feito direto no Workbench ou no terminal sql e para o MongoDb seja
usado o MongoDB Compass.

# MySQL
Dentro do MySQL Workbench
1. Criar database com nome university 
"CREATE DATABASE university;"

2. Criar usuário para o diretor e conceder todas as permissões a ele 
"CREATE USER IF NOT EXISTS 'principal'@'localhost' IDENTIFIED BY 'principal';
GRANT ALL PRIVILEGES ON university.* TO 'principal'@'localhost';
FLUSH PRIVILEGES;"
3. entrar no banco de dados university
"USE university"

4. criar tabela com os atributos a serem armazendos
"CREATE TABLE IF NOT EXISTS student (
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   course_type VARCHAR(20) NOT NULL,
   grades VARCHAR(255),
   concepts VARCHAR(255)
);"

# MongoDB
Dentro do MongoDB

1. Criar database com nome "university"

2. Criar collection com nome "students"