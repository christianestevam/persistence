/*
1. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo compactado a ser criado e (2) uma pasta. Compactar todos os arquivos e subpastas em um arquivo compactado com extensão zip.
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

public class ZipApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java ZipApp <arquivo zip> <pasta>");
            return;
        }

        String arquivoZip = args[0];
        String pasta = args[1];

        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(arquivoZip))) {
            File pastaRaiz = new File(pasta);
            adicionarArquivos(zip, pastaRaiz, pastaRaiz);
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo zip: " + e.getMessage());
        }
    }

    private static void adicionarArquivos(ZipOutputStream zip, File pastaRaiz, File arquivo) throws IOException {
        if (arquivo.isDirectory()) {
            File[] arquivos = arquivo.listFiles();
            for (File subarquivo : arquivos) {
                adicionarArquivos(zip, pastaRaiz, subarquivo);
            }
        } else {
            String nomeArquivo = arquivo.getAbsolutePath().substring(pastaRaiz.getAbsolutePath().length() + 1);
            zip.putNextEntry(new java.util.zip.ZipEntry(nomeArquivo));
            try (FileInputStream in = new FileInputStream(arquivo)) {
                byte[] buffer = new byte[1024];
                int bytesLidos;
                while ((bytesLidos = in.read(buffer)) > 0) {
                    zip.write(buffer, 0, bytesLidos);
                }
            }
        }
    }
}
