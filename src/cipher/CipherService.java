package cipher;

import constants.Constants;

import java.util.ArrayList;
import java.util.Map;

public class CipherService {

    private static final Map<String, ArrayList<Character>> alphabetMap = Map.of(
            "alphabet_en_lowercase", Constants.ALPHABET_EN_LOWERCASE,
            "alphabet_en_uppercase", Constants.ALPHABET_EN_UPPERCASE,
            "alphabet_ua_lowercase", Constants.ALPHABET_UA_LOWERCASE,
            "alphabet_ua_uppercase", Constants.ALPHABET_UA_UPPERCASE,
            "alphabet_chars", Constants.ALPHABET_CHARS
    );

    public void encrypt(ArrayList<Character> cipherText, String key) {
        for (int i = 0; i < cipherText.size(); i++) {

            char currentChar = cipherText.get(i);
            int index;
            int resultIndex;

            ArrayList<Character> currentAlphabet = getAlphabetForChar(currentChar);

            if (currentAlphabet != null && currentAlphabet.contains(currentChar)) {

                index = currentAlphabet.indexOf(currentChar);
                resultIndex = (index + Integer.parseInt(key)) % currentAlphabet.size();

                while (resultIndex < 0) {
                    resultIndex += currentAlphabet.size();
                }

                char resultChar = currentAlphabet.get(resultIndex);
                cipherText.set(i, resultChar);
            }

        }
    }


    public void decrypt(ArrayList<Character> cipherText, String key) {
        for (int i = 0; i < cipherText.size(); i++) {

            char currentChar = cipherText.get(i);
            int index;
            int resultIndex;

            ArrayList<Character> currentAlphabet = getAlphabetForChar(currentChar);

            if (currentAlphabet != null && currentAlphabet.contains(currentChar)) {

                index = currentAlphabet.indexOf(currentChar);
                resultIndex = (index - Integer.parseInt(key)) % currentAlphabet.size();

                while (resultIndex < 0) {
                    resultIndex += currentAlphabet.size();
                }

                char resultChar = currentAlphabet.get(resultIndex);
                cipherText.set(i, resultChar);
            }

        }
    }

    public ArrayList<Character> getAlphabetForChar(char c) {

        for (Map.Entry<String, ArrayList<Character>> entry : alphabetMap.entrySet()) {
            if (entry.getValue().contains(c)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
