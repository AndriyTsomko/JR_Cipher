public class Runner {

    public void run(String[] args) {
        String mode = args[0];
        String path = args[1];
        int key = Integer.parseInt(args[2]);

        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processFile(mode, path, key);
    }
}
