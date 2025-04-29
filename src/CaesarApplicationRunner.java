public class CaesarApplicationRunner {

    private String mode;
    private String path;
    private String key;
    private boolean isBruteForceMode;

    FileProcessor fileProcessor = new FileProcessor();
    InputValidator checker = new InputValidator();

    public void run(String[] args) {
        if (args.length == 2 || args.length == 3) {
            mode = args[0];
            checker.checkMode(mode);
            path = args[1];
            checker.checkPath(path);

            isBruteForceMode = mode.equalsIgnoreCase(Constants.BRUTE_FORCE);

            if (isBruteForceMode) {
                fileProcessor.processFile(mode, path);
            } else {
                key = args[2];
                checker.checkKey(key);
                fileProcessor.processFile(mode, path, key);
            }
        } else {
            runCLI();
        }

    }

    public void runCLI(){
        CLIService cliService = new CLIService();

        mode = cliService.readMode();
        checker.checkMode(mode);

        path = cliService.readFilePath();
        checker.checkPath(path);

        isBruteForceMode = mode.equalsIgnoreCase(Constants.BRUTE_FORCE);
        if (isBruteForceMode) {
            fileProcessor.processFile(mode, path);
        } else {
            key = cliService.readKey();
            checker.checkKey(key);
            fileProcessor.processFile(mode, path, key);
        }
    }
}
