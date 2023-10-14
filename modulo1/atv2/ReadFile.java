/*

1. Escreva uma aplicação Java para ler um arquivo texto ou binário qualquer e gravá-lo em outro arquivo (arquivo destino).

Os nomes dos arquivos (origem e destino) devem ser definidos via argumentos de linha de comando (Dica: usar o String args[] do método main).
A leitura e gravação devem ser realizadas byte a byte.
Ao final, deve-se exibir o tempo total da cópia em milisegundos, caso a cópia tenha sido bem sucedida. Dica: pode-se usar o método System.currentTimeMillis().
Em caso de qualquer erro, enviar uma mensagem pela saída padrão de erro (System.err).
 */

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        if (args.length != 2) { 
            System.err.println("Usage: java ReadFile <source> <destination>");  
            System.exit(1);
        }

        try (InputStream in = new FileInputStream(args[0]);
             OutputStream out = new FileOutputStream(args[1])) {

            long startTime = System.currentTimeMillis();

            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Copied in " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
