import java.util.ArrayList;

public class BruteForceDecryptor {

    public int findKeyByDecryptionFlag(ArrayList<Character> arrayList) {
        char lastChar = arrayList.get(arrayList.size() - 1);
        char expectedLastChar = 'A';
        int key = 0;

        ArrayList<Character> alphabet = Constants.ALPHABET_EN_UPPERCASE;

        int lastCharIndex = alphabet.indexOf(lastChar);
        int resultIndex;

        for (int i = 0; i < alphabet.size(); i++) {
            resultIndex = (lastCharIndex - i) % alphabet.size();
            while (resultIndex < 0) {
                resultIndex += alphabet.size();
            }
            if (alphabet.get(resultIndex).equals(expectedLastChar)) {
                key = i;
                break;
            }
        }
        arrayList.remove(arrayList.size() - 1);

        return key;
    }
}
