import java.util.ArrayList;
import java.util.Collections;

public class Cipher {

    //Метод буде шифрувати текст, отримуючи на вхід ліст з символами й ключ(для зсуву)
    public void crypt(ArrayList<Character> cipherText, int key) {
        //Проходимося по кожному символу в лісті
        //Символи одразу будемо перезаписувати в ліст
        for (int i = 0; i < cipherText.size(); i++) {
            //Створюємо тимчасову змінну для зберігання одного символу
            char temp = cipherText.get(i);
            //Індекс елемента в алфавіті
            int index;
            //Отримуємо індекс елемента в алфавіті, який вже зашифрований
            int resultIndex = 0;
            //отримуємо поточний алфавіт
            ArrayList<Character> currentAlphabet = getAlphabetForChar(temp);
            //Перевіряємо чи алфавіт не null й, чи містить він наш символ
            if (currentAlphabet != null && currentAlphabet.contains(temp)) {
                //Отримуємо індекс елемента
                index = currentAlphabet.indexOf(temp);
                //використовуємо модуль, щоб коли index + key був більший за size алфавіту не викидувало помилку
                if (key >= 0) {
                    resultIndex = (index + key) % currentAlphabet.size();
                } else {
                    if (index - key < 0) {
                        resultIndex = (currentAlphabet.size() + index - key) % currentAlphabet.size();
                    } else {
                        resultIndex = (index - key) % currentAlphabet.size();
                    }
                }
                //Замінюємо символ в списку на зашифрований
                char resultChar = currentAlphabet.get(resultIndex);
                cipherText.set(i, resultChar);
            }

        }
    }

    //Метод розшифровує текст
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

    //Метод буде отримувати поточний алфавіт, в якому знаходиться символ
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
