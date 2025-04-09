public class Runner {
    private final String mode;
    private final String path;
    private final int key;

    public Runner(String[] args) {
        this.mode = args[0];
        this.path = args[1];
        this.key = Integer.parseInt(args[2]);
    }

    public void run() {
        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processFile(mode, path, key);
    }
}
