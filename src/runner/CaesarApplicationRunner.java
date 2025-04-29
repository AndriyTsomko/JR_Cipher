package runner;

import cli.CLIService;
import constants.Constants;
import operations.FileProcessor;
import validation.InputValidator;

public class CaesarApplicationRunner {

    private String mode;
    private String path;
    private String key;
    private boolean isBruteForceMode;

    FileProcessor fileProcessor = new FileProcessor();
    InputValidator inputValidator = new InputValidator();

    public void run(String[] args) {
        if (args.length == 2 || args.length == 3) {
            mode = args[0];
            inputValidator.checkMode(mode);
            path = args[1];
            inputValidator.checkPath(path);

            isBruteForceMode = mode.equalsIgnoreCase(Constants.BRUTE_FORCE);

            if (isBruteForceMode) {
                fileProcessor.processFile(mode, path);
            } else {
                key = args[2];
                inputValidator.checkKey(key);
                fileProcessor.processFile(mode, path, key);
            }
        } else {
            runCLI();
        }

    }

    public void runCLI(){
        CLIService cliService = new CLIService();

        mode = cliService.readMode();
        inputValidator.checkMode(mode);

        path = cliService.readFilePath();
        inputValidator.checkPath(path);

        isBruteForceMode = mode.equalsIgnoreCase(Constants.BRUTE_FORCE);
        if (isBruteForceMode) {
            fileProcessor.processFile(mode, path);
        } else {
            key = cliService.readKey();
            inputValidator.checkKey(key);
            fileProcessor.processFile(mode, path, key);
        }
    }
}
