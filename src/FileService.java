import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileService {
    ArrayList<Character> arrayList = new ArrayList<>();

    //Метод буде зчитувати char з файлу й зберігати їх в ArrayList
    public ArrayList<Character> readFile(String fileName) {
        //Шлях до файлу
        File file = new File(Path.of(fileName).toFile().getAbsolutePath());
        //В читанні файлу будемо використовувати BufferedReader і FileReader
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
}
