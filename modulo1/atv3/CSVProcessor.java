/*
1. Crie uma aplicação em Java que recebe via linha de comando: (1) o nome de um arquivo CSV; 
(2) o delimitador usado para separar os campos do arquivo; (3) uma lista de nomes das colunas do arquivo CSV que serão processados.
 Considere que o arquivo CSV (1) deva ter um cabeçalho com os nomes das colunas em sua primeira linha e que não tenha internamente colunas com Strings contendo o mesmo caractere usado como delimitador (2). 
 A aplicação deve exibir a soma e a média das colunas selecionadas em (3), caso tenham dados numéricos. Se não tiverem dados numéricos, somente exibir que aquela coluna não é numérica. Não usar bibliotecas externas para resolver esta questão (usar Java puro). 
 Sugere-se navegar apenas uma única vez em cada linha do arquivo CSV. Fazer a aplicação de modo que ela possa processar arquivos CSV extremamente grandes, mesmo que não caibam na memória RAM. Dica: usar o método split da classe String para separar os valores das colunas em cada linha do arquivo CSV.
 */

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;

    public class CSVProcessor {
        public static void main(String[] args) {
            if (args.length < 3) {
                System.out.println("Uso: java CSVProcessor <arquivo CSV> <delimitador> <colunas>");
                return;
            }

            String arquivoCSV = args[0];
            String delimitador = args[1];
            String[] colunasSelecionadas = args[2].split(",");

            try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
                String linha = reader.readLine();
                String[] cabecalho = linha.split(delimitador);
                int[] indicesColunas = new int[colunasSelecionadas.length];

                for (int i = 0; i < colunasSelecionadas.length; i++) {
                    for (int j = 0; j < cabecalho.length; j++) {
                        if (colunasSelecionadas[i].equals(cabecalho[j])) {
                            indicesColunas[i] = j;
                            break;
                        }
                    }
                }

                double[] somaColunas = new double[colunasSelecionadas.length];
                int[] contadorColunas = new int[colunasSelecionadas.length];

                while ((linha = reader.readLine()) != null) {
                    String[] valores = linha.split(delimitador);
                    for (int i = 0; i < colunasSelecionadas.length; i++) {
                        int indice = indicesColunas[i];
                        try {
                            double valor = Double.parseDouble(valores[indice]);
                            somaColunas[i] += valor;
                            contadorColunas[i]++;
                        } catch (NumberFormatException e) {
                            // Ignorar valores não numéricos
                        }
                    }
                }

                for (int i = 0; i < colunasSelecionadas.length; i++) {
                    if (contadorColunas[i] > 0) {
                        double media = somaColunas[i] / contadorColunas[i];
                        System.out.println("Coluna " + colunasSelecionadas[i] + ": Soma=" + somaColunas[i] + ", Média=" + media);
                    } else {
                        System.out.println("Coluna " + colunasSelecionadas[i] + " não é numérica.");
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
            }
        }
    }
