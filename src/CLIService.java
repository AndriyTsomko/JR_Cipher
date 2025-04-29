import java.util.Scanner;

public class CLIService {
    Scanner console = new Scanner(System.in);

    public String readFilePath() {
        System.out.println("Please enter the path: ");
        return console.nextLine();
    }

    public String readKey() {
        System.out.println("Please enter the key: ");
        return console.nextLine();
    }

    public String readMode(){
        System.out.println("Please enter the mode: ");
        System.out.println("[E]ncrypt [D]ecrypt [B]ruteForce text: ");
        return console.nextLine();
    }

}
