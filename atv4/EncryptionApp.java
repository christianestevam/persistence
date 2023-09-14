/*
2. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo a ser encriptado, (2) o nome do arquivo encriptado a ser criado e (3) a chave de encriptação.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionApp {
    public static void main(String[] args) {

        String arquivo = args[0];
        String arquivoEncriptado = args[1];
        String chave = args[2];

        try (FileInputStream in = new FileInputStream(arquivo);
             FileOutputStream out = new FileOutputStream(arquivoEncriptado)) {
            SecretKeySpec key = new SecretKeySpec(chave.getBytes(), "AES");  // 
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream cout = new CipherOutputStream(out, cipher);
            byte[] buffer = new byte[1024];
            int bytesLidos;
            while ((bytesLidos = in.read(buffer)) > 0) {
                cout.write(buffer, 0, bytesLidos);
            }
            cout.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao encriptar arquivo: " + e.getMessage());
        }
    }
}
