import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileService {

    ArrayList<Character> arrayList = new ArrayList<>();


    public ArrayList<Character> readFile(String fileName) {

        File file = new File(Path.of(fileName).toFile().getAbsolutePath());

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int c;
            while ((c = br.read()) != -1) {
                arrayList.add((char) c);
            }
        } catch (Exception e) {
            System.out.println("Error reading file");
        }

        return arrayList;
    }

    public void writeFile(File file){

        File createNewFile = new File(String.valueOf(file));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(createNewFile))) {

            for (Character character : arrayList) {
                bufferedWriter.write(character.toString());
            }
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public void writeFileEncrypt(String fileName) {

        Path path = Path.of(fileName);

        File file = new File(path.toFile().getAbsolutePath() + "[ENCRYPTED]");
        writeFile(file);
    }

    public void writeFileDecrypt(String fileName) {

        Path path = Path.of(fileName);

        File file = new File(path.toFile().getAbsolutePath() + "[DECRYPTED]");
        writeFile(file);
    }

}
