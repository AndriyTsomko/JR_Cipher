import java.util.ArrayList;

public class FileProcessor {
    FileService fileService = new FileService();
    CipherService cipherService = new CipherService();

    public void processFile(String mode, String path, String key) {
        ArrayList<Character> arrayList = fileService.readFile(path);
        if (mode.equalsIgnoreCase(Constants.ENCRYPT_MODE)) {
            arrayList.add('A');
            cipherService.encrypt(arrayList, key);
            fileService.writeFileEncrypt(path);
        }

        if (mode.equalsIgnoreCase(Constants.DECRYPT_MODE)) {
            cipherService.decrypt(arrayList, key);
            fileService.writeFileDecrypt(path);
        }


    }

    public void processFile(String mode, String path) {
        ArrayList<Character> arrayList = fileService.readFile(path);
        if (mode.equalsIgnoreCase(Constants.BRUTE_FORCE)) {
            BruteForceDecryptor bruteForce = new BruteForceDecryptor();
            String key = bruteForce.findKeyByDecryptionFlag(arrayList);
            cipherService.decrypt(arrayList, key);
            fileService.writeFileDecrypt(path);
        }

    }

}
