import java.util.ArrayList;
import java.util.Scanner;

public class CLIService {
    Scanner console = new Scanner(System.in);

    public String enterThePath(){
        System.out.println("Please enter the path: ");
        String path = console.nextLine();
        return path;
    }

    public int enterTheKey(){
        System.out.println("Please enter the key: ");
        int key = console.nextInt();
        return key;
    }

    public String enterTheMode(){
        console.nextLine();

        System.out.println("[E]ncrypted or [D]ecrypted text: ");
        String mode = console.nextLine();
        return mode;
    }

    public void processFile(String path, int key, String mode){
        FileService fileService = new FileService();
        CipherService cipher = new CipherService();
        ArrayList<Character> arrayList = fileService.readFile(path);

        if (mode.equalsIgnoreCase("E")) {
            cipher.encrypt(arrayList, key);
            fileService.writeFileEncrypt(path);
        }

        if (mode.equalsIgnoreCase("D")) {
            if (key >= 0) {
                cipher.decrypt(arrayList, key);
                fileService.writeFileDecrypt(path);
            } else {
                cipher.decrypt(arrayList, key * -1);
                fileService.writeFileDecrypt(path);
            }
        }
    }
}
