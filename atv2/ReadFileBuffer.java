 /*
 1. Escreva uma aplicação Java para ler um arquivo texto ou binário qualquer e gravá-lo em outro arquivo (arquivo destino).

Os nomes dos arquivos (origem e destino) devem ser definidos via argumentos de linha de comando (Dica: usar o String args[] do método main).
A leitura e gravação devem ser realizadas byte a byte.
Ao final, deve-se exibir o tempo total da cópia em milisegundos, caso a cópia tenha sido bem sucedida. Dica: pode-se usar o método System.currentTimeMillis().
Em caso de qualquer erro, enviar uma mensagem pela saída padrão de erro (System.err).
2. Escreva uma aplicação Java para fazer exatamente o que foi pedido na Questão 1, mas com uma única diferença:

A leitura e gravação devem ser realizadas em blocos de bytes (buffer) e não byte a byte.

Dica: usar os métodos read(byte[] b) e write(byte[] b) de FileInputStream e FileOutputStream, respectivamente. Testar a cópia com arquivos grandes. Usar blocos de 8192 bytes. Exemplo:

...
byte[] buffer = new byte[8192];
fis.read(buffer);
 */

import java.io.*;

public class ReadFileBuffer {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java ReadFile <source> <destination>");
            System.exit(1);
        }

        try (InputStream in = new FileInputStream(args[0]);
             OutputStream out = new FileOutputStream(args[1])) {

            long startTime = System.currentTimeMillis();

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Copied in " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
