import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public void run() {
        CLI cli = new CLI();
        String path = cli.enterThePath();
        int key = cli.enterTheKey();
        String mode = cli.enterTheMode();
        cli.processFile(path, key, mode);
    }
}
