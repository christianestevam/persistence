/*
1. Crie uma aplicação em Java que recebe via linha de comando: (1) o nome de um arquivo CSV; 
(2) o delimitador usado para separar os campos do arquivo; (3) uma lista de nomes das colunas do arquivo CSV que serão processados.
 Considere que o arquivo CSV (1) deva ter um cabeçalho com os nomes das colunas em sua primeira linha e que não tenha internamente colunas com Strings contendo o mesmo caractere usado como delimitador (2). 
 A aplicação deve exibir a soma e a média das colunas selecionadas em (3), caso tenham dados numéricos. Se não tiverem dados numéricos, somente exibir que aquela coluna não é numérica. Não usar bibliotecas externas para resolver esta questão (usar Java puro). 
 Sugere-se navegar apenas uma única vez em cada linha do arquivo CSV. Fazer a aplicação de modo que ela possa processar arquivos CSV extremamente grandes, mesmo que não caibam na memória RAM. Dica: usar o método split da classe String para separar os valores das colunas em cada linha do arquivo CSV.
 */
