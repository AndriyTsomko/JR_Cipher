import java.util.ArrayList;

public class FileProcessor {
    String encryptedMode = "ENCRYPT";
    String decryptedMode = "DECRYPT";
    String bruteForceMode = "BRUTEFORCE";

    FileService fileService = new FileService();
    CipherService cipherService = new CipherService();


    public void processFile(String mode, String path, int key) {
        ArrayList<Character> arrayList = fileService.readFile(path);
        if (mode.equalsIgnoreCase(encryptedMode)) {
            arrayList.add('A');
            cipherService.encrypt(arrayList, key);
            fileService.writeFileEncrypt(path);
        }

        if (mode.equalsIgnoreCase(decryptedMode)) {
            cipherService.decrypt(arrayList, key);
            fileService.writeFileDecrypt(path);
        }


    }

    public void processFile(String mode, String path) {
        ArrayList<Character> arrayList = fileService.readFile(path);
        if (mode.equalsIgnoreCase(bruteForceMode)) {
            BruteForceDecryptor bruteForceDecryptor = new BruteForceDecryptor();
            int k = bruteForceDecryptor.findKeyByDecryptionFlag(arrayList);
            cipherService.decrypt(arrayList, k);
            fileService.writeFileDecrypt(path);
        }

    }

}
