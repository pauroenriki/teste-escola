# teste-escola
O Código da API está na branch master.

Banco de dados: MySql.

Nome do banco de dados para a API: dbescola.

Usuário do Banco de dados: root.

Senha em branco.



GET: 

http://localhost:8080/teste-escola/api/v1/aluno -> Retorna todos os alunos.

http://localhost:8080/teste-escola/api/v1/aluno/ativos -> Retorna todos os alunos ativos.

http://localhost:8080/teste-escola/api/v1/aluno/{id} -> Retorna aluno por ID.

POST:

http://localhost:8080/teste-escola/api/v1/aluno -> Inclui um novo aluno (enviar json Aluno).

PUT:

http://localhost:8080/teste-escola/api/v1/aluno -> Altera os dados de um aluno (enviar json Aluno).

DELETE:
http://localhost:8080/teste-escola/api/v1/aluno/{id} -> Efetua delete lógico de um aluno pelo id informado.



TURMA:

GET:

http://localhost:8080/teste-escola/api/v1/turma -> Retorna todas as turmas.

http://localhost:8080/teste-escola/api/v1/turma/ativos -> Retorna todas as turmas ativas.

http://localhost:8080/teste-escola/api/v1/turma/{id} -> Retorna turma por ID.

http://localhost:8080/teste-escola/api/v1/turma/aluno/{id} -> Retorna as turmas a que o aluno indicado pelo Id pertence.

POST:

http://localhost:8080/teste-escola/api/v1/turma -> Inclui uma nova turma (enviar json Turma).

PUT:

http://localhost:8080/teste-escola/api/v1/turma -> Altera uma turma (enviar json Turma).

http://localhost:8080/teste-escola/api/v1/turma/incluir-aluno/{id} -> Inclui um aluno em uma turma (enviar json Aluno e id do Aluno na url).

http://localhost:8080/teste-escola/api/v1/turma/remover-aluno/{id} -> Remove um aluno de uma turma (enviar json Aluno e id do Aluno na url).

DELETE:

http://localhost:8080/teste-escola/api/v1/turma/{id} -> Efetua delete lógico de uma turma (enviar json da turma).




