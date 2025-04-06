import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public void test() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter the path: ");
        String path = console.nextLine();

        System.out.println("Please enter the key: ");
        int key = console.nextInt();
        console.nextLine();

        System.out.println("[E]ncrypted or [D]ecrypted text: ");
        String mode = console.nextLine();

        FileService fileControl = new FileService();
        Cipher cipher = new Cipher();
        ArrayList<Character> arrayList = fileControl.readFile(path);

        if (mode.equalsIgnoreCase("E")) {
            cipher.crypt(arrayList, key);
            fileControl.writeFileEncrypt(path);
        }

        if (mode.equalsIgnoreCase("D")) {
            if (key >= 0) {
                cipher.decrypt(arrayList, key);
                fileControl.writeFileDecrypt(path);
            } else {
                cipher.decrypt(arrayList, key * -1);
                fileControl.writeFileDecrypt(path);
            }
        }
    }
}
