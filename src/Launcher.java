import java.util.Scanner;

public class Launcher {
    public static void main(String[] args){
        System.out.println("Bonjour a tous et bienvenue");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (! input.equals("quit")) {
            switch (input) {
                case ("fibo") -> {
                    System.out.println("Donner Rang");
                    input = scan.nextLine();
                    System.out.println(fibo(Integer.parseInt(input)));
                }
                default -> {
                    System.out.println("Unknown command");
                }
            }
            input = scan.nextLine();
        }
    }

    private static int fibo(int rang) {
        if (rang < 0)
            throw new IllegalArgumentException();
        if (rang == 0)
            return 0;
        if (rang == 1)
            return 1;
        return fibo(rang - 1) + fibo(rang - 2);
    }
}
