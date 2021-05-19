import java.util.Scanner;

public class Fibo implements Command {
    private static int fibo(int rang) {
        if (rang < 0)
            throw new IllegalArgumentException();
        if (rang == 0)
            return 0;
        if (rang == 1)
            return 1;
        return fibo(rang - 1) + fibo(rang - 2);
    }

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scan) {
        System.out.println("Donner Rang");
        String input = scan.nextLine();
        System.out.println(fibo(Integer.parseInt(input)));
        return false;
    }
}
