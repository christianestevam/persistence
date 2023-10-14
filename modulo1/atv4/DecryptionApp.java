/*
3. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo a ser decriptado e (2) o nome do arquivo resultante da decriptação e (3) a chave de decriptação.
 */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DecryptionApp {
    public static void main(String[] args) {

        String arquivoEncriptado = args[0];
        String arquivoDecriptado = args[1];
        String chave = args[2];

        try (FileInputStream in = new FileInputStream(arquivoEncriptado);
             FileOutputStream out = new FileOutputStream(arquivoDecriptado)) {
            SecretKeySpec key = new SecretKeySpec(chave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] buffer = new byte[1024];
            int bytesLidos;
            while ((bytesLidos = in.read(buffer)) > 0) {
                out.write(cipher.update(buffer, 0, bytesLidos));
            }
            out.write(cipher.doFinal());
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao decriptar arquivo: " + e.getMessage());
        }
    }
}

