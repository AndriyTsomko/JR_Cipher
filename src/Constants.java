import java.util.ArrayList;
import java.util.Arrays;

public final class Constants {
    private Constants() {

    }
    public static final ArrayList<Character> ALPHABET_EN_LOWERCASE = new ArrayList<>(Arrays.asList(
            'a','b','c','d','e','f','g','h','i','j','k',
            'l','m','n','o','p','q','r','s','t','u','v',
            'w','x','y','z'
    ));

    public static final ArrayList<Character> ALPHABET_EN_UPPERCASE = new ArrayList<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    ));

    public static final ArrayList<Character> ALPHABET_CHARS = new ArrayList<>(Arrays.asList(
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '
    ));
}
