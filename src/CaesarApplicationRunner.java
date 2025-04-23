public class CaesarApplicationRunner {

    private static final int ARG_MODE = 0;
    private static final int ARG_PATH = 1;
    private static final int ARG_KEY = 2;

    public void run(String[] args) {
        String mode = args[ARG_MODE];
        String path = args[ARG_PATH];
        FileProcessor fileProcessor = new FileProcessor();
        boolean isBruteForceMode = mode.equalsIgnoreCase("bruteForce");
        if (isBruteForceMode) {
            fileProcessor.processFile(mode, path);
        } else {
            int key = Integer.parseInt(args[ARG_KEY]);
            fileProcessor.processFile(mode, path, key);
        }
    }
}
