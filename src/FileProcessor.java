import java.util.ArrayList;

public class FileProcessor {

    public void processFile(String mode, String path, int key) {
        FileService fileService = new FileService();
        CipherService cipher = new CipherService();
        ArrayList<Character> arrayList = fileService.readFile(path);

        String encryptedMode = "ENCRYPT";
        String decryptedMode = "DECRYPT";

        if (mode.equalsIgnoreCase(encryptedMode)) {
            cipher.encrypt(arrayList, key);
            fileService.writeFileEncrypt(path);
        }

        if (mode.equalsIgnoreCase(decryptedMode)) {
            if (key >= 0) {
                cipher.decrypt(arrayList, key);
                fileService.writeFileDecrypt(path);
            } else {
                cipher.decrypt(arrayList, key);
                fileService.writeFileDecrypt(path);
            }
        }

    }

}
