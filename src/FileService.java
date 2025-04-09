import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public void writeFile(String fileName){

        File createNewFile = new File(String.valueOf(fileName));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(createNewFile))) {

            for (Character character : arrayList) {
                bufferedWriter.write(character.toString());
            }
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public void writeFileEncrypt(String fileName) {

        try {
            Path file = Files.createFile(Paths.get(fileName + "[ENCRYPTED]"));
            writeFile(String.valueOf(file));
        } catch (Exception e){
            System.out.println("Error writing file " + e.getMessage());
        }
    }

    public void writeFileDecrypt(String fileName) {
        try {
            Path file = Files.createFile(Paths.get(fileName + "[DECRYPTED]"));
            writeFile(String.valueOf(file));
        } catch (Exception e){
            System.out.println("Error writing file " + e.getMessage());
        }
    }

}
