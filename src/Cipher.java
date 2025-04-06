import java.util.ArrayList;

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
                resultIndex = (index + key) % currentAlphabet.size();
                //Замінюємо символ в списку на зашифрований
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
