/*
4. Crie uma aplicação em Java que recebe via linha de comando o nome de um arquivo para geração/armazenamento dos hashes  md5, sha1 e sha256 do arquivo especificado. A aplicação deve mostrar o tempo de execução de cada uma dessas operações
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCalculator {
    public static void main(String[] args) {

        String arquivo = args[0];

        try (FileInputStream in = new FileInputStream(arquivo)) {
            long inicio = System.currentTimeMillis();
            byte[] md5 = gerarHash(in, "MD5");
            long fim = System.currentTimeMillis();
            System.out.println("MD5: " + bytesToHex(md5));
            System.out.println("Tempo: " + (fim - inicio) + "ms");

            inicio = System.currentTimeMillis();
            byte[] sha1 = gerarHash(in, "SHA-1");
            fim = System.currentTimeMillis();
            System.out.println("SHA-1: " + bytesToHex(sha1));
            System.out.println("Tempo: " + (fim - inicio) + "ms");

            inicio = System.currentTimeMillis();
            byte[] sha256 = gerarHash(in, "SHA-256");
            fim = System.currentTimeMillis();
            System.out.println("SHA-256: " + bytesToHex(sha256));
            System.out.println("Tempo: " + (fim - inicio) + "ms");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro ao gerar hash: " + e.getMessage());
        }
    }

    private static byte[] gerarHash(FileInputStream in, String algoritmo) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algoritmo);
        byte[] buffer = new byte[1024];
        int bytesLidos;
        while ((bytesLidos = in.read(buffer)) > 0) {
            md.update(buffer, 0, bytesLidos);
        }
        return md.digest();
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
