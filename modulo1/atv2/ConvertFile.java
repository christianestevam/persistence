import java.io.*;

public class ConvertFile {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java ConvertFile <source> <destination>");
            System.exit(1);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "ISO-8859-1"));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8"))) {

            long startTime = System.currentTimeMillis();

            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Converted in " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
