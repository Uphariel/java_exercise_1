import java.util.Scanner;

public class Launcher {
    public static void main(String[] args){
        System.out.println("Bonjour a tous et bienvenue");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        if(input.equals("quit")) {
        }
        else {
            System.out.println("Unknown command");
        }
    }
}
