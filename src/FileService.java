import java.io.*;
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

    public void writeFile(String fileName, ArrayList<Character> arrayList) {
        //Отримуємо path файла
        Path path = Path.of(fileName);
        //Отримуємо папку в якій знаходився текстовий файл
        File file = new File(path.toFile().getAbsolutePath() + "[ENCRYPTED]");
        //Отримуємо назву нового файлу(Поки працює тільки, коли шифруємо файл)
        File createNewFile = new File(String.valueOf(file));
        //Для запису використовую bufferedWriter і FileWriter, в який передаємо шлях до файлу
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(createNewFile))) {
            //Пробігаємося по лісту за допомогою foreach і записуємо символи
            for (Character character : arrayList) {
                bufferedWriter.write(character.toString());
            }
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

}
