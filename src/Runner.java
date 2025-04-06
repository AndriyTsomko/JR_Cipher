import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public void test() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter the path: ");
        String path = console.nextLine();
        System.out.println("Please enter the key: ");
        int key = console.nextInt();


        FileService fileControl = new FileService();
        Cipher cipher = new Cipher();
        ArrayList<Character> arrayList = fileControl.readFile(path);

        cipher.crypt(arrayList, key);
        fileControl.writeFileEncrypt(path, arrayList);


        if (key >= 0) {
            cipher.decrypt(arrayList, key);
            fileControl.writeFileDecrypt(path, arrayList);
        } else {
            cipher.decrypt(arrayList, key * -1);
            fileControl.writeFileDecrypt(path, arrayList);
        }
    }
}
