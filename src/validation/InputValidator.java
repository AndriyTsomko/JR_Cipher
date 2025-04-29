package validation;

import constants.Constants;
import exceptions.InvalidKeyFormatException;
import exceptions.InvalidModeException;
import exceptions.WrongFilePathException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final List<String> VALID_MODES = new ArrayList<>(Arrays.asList(Constants.ENCRYPT_MODE, Constants.DECRYPT_MODE, Constants.BRUTE_FORCE));

    public void checkPath(String path) throws WrongFilePathException {
        if (path == null) {
            throw new WrongFilePathException("Path is null");
        }

        if (path.isBlank()) {
            throw new WrongFilePathException("Path is blank");
        }

        Path filePath = Paths.get(path);
        if (!Files.exists(filePath)) {
            throw new WrongFilePathException("Wrong path: " + path);
        }

    }

    public void checkMode(String mode) throws InvalidModeException {
        if (mode == null) {
            throw new InvalidModeException("Mode is null");
        }

        if (mode.isBlank()){
            throw new InvalidModeException("Mode is blank");
        }

        mode = mode.toUpperCase();
        if (!VALID_MODES.contains(mode)) {
            throw new InvalidModeException("Invalid mode: " + mode);
        }
    }

    public void checkKey(String key) throws InvalidKeyFormatException {
        if (key == null) {
            throw new InvalidKeyFormatException("Key is null");
        }

        if (key.isBlank()){
            throw new InvalidKeyFormatException("Key is blank");
        }

        for (int i = 0; i < key.length(); i++) {
            boolean bol = key.charAt(0) == '-' && key.length() == 1;
            if (!Character.isDigit(key.charAt(i)) && bol) {
                throw new InvalidKeyFormatException("Invalid key: " + key);
            }
        }

    }

}
