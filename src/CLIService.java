import java.util.Scanner;

public class CLIService {
    Scanner console = new Scanner(System.in);

    public String enterThePath(){
        System.out.println("Please enter the path: ");
        return console.nextLine();
    }

    public int enterTheKey(){
        System.out.println("Please enter the key: ");
        return console.nextInt();
    }

    public String enterTheMode(){
        console.nextLine();

        System.out.println("[E]ncrypted or [D]ecrypted text: ");
        return console.nextLine();
    }

}
