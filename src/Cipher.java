import java.util.ArrayList;
import java.util.Collections;

public class Cipher {

    public void crypt(ArrayList<Character> cipherText, int key) {
        for (int i = 0; i < cipherText.size(); i++) {

            char temp = cipherText.get(i);
            int index;
            int resultIndex;

            ArrayList<Character> currentAlphabet = getAlphabetForChar(temp);

            if (currentAlphabet != null && currentAlphabet.contains(temp)) {

                index = currentAlphabet.indexOf(temp);

                if (key >= 0) {
                    resultIndex = (index + key) % currentAlphabet.size();
                } else {
                    if (index - key < 0) {
                        resultIndex = (currentAlphabet.size() + index - key) % currentAlphabet.size();
                    } else {
                        resultIndex = (index - key) % currentAlphabet.size();
                    }
                }

                char resultChar = currentAlphabet.get(resultIndex);
                cipherText.set(i, resultChar);
            }

        }
    }


    public void decrypt(ArrayList<Character> cipherText, int key) {
        for (int i = 0; i < cipherText.size(); i++) {
            char temp = cipherText.get(i);
            int index;
            int resultIndex;

            ArrayList<Character> currentAlphabet = getAlphabetForChar(temp);

            if (currentAlphabet != null && currentAlphabet.contains(temp)) {
                index = currentAlphabet.indexOf(temp);

                if (index - key < 0) {
                    resultIndex = (currentAlphabet.size() + index - key) % currentAlphabet.size();
                } else {
                    resultIndex = (index - key) % currentAlphabet.size();
                }

                char resultChar = currentAlphabet.get(resultIndex);
                cipherText.set(i, resultChar);
            }

        }
    }


    public ArrayList<Character> getAlphabetForChar(char c) {
        if (Constants.ALPHABET_EN_UPPERCASE.contains(c)) {
            return Constants.ALPHABET_EN_UPPERCASE;
        } else if (Constants.ALPHABET_EN_LOWERCASE.contains(c)) {
            return Constants.ALPHABET_EN_LOWERCASE;
        } else if (Constants.ALPHABET_CHARS.contains(c)) {
            return Constants.ALPHABET_CHARS;
        } else {
            return null;
        }
    }
}
