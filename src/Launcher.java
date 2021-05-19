import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

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
                case ("freq") -> {
                    System.out.println("Donner le chemin du fichier a analyser");
                    input = scan.nextLine();
                    freqLauncher(input);
                }
                default -> System.out.println("Unknown command");
            }
            input = scan.nextLine();
        }
    }

    private static void freqLauncher(String input) {
        try {
            Hashtable<String ,Integer> rep = freq(input);
            Map.Entry<String, Integer> first = null;
            Map.Entry<String, Integer> second = null;
            Map.Entry<String, Integer> third = null;
            for (Map.Entry<String, Integer> entry : rep.entrySet())
            {
                if (first == null || entry.getValue().compareTo(first.getValue()) >= 0)
                {
                    third = second;
                    second = first;
                    first = entry;
                }
            }
            System.out.println(first.getKey() + " " + second.getKey() + " " + third.getKey());
        } catch (IOException e) {
            System.out.println("Unreadable file: " + e.getClass() + e.getMessage());
        }
    }

    private static Hashtable<String, Integer> freq(String path) throws IOException {
        String input = java.nio.file.Files.readString(Path.of(path));
        List<String> list = Arrays.asList(input.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split(" "));
        Set<String> distinct = new HashSet<>(list);
        Hashtable<String, Integer> dict = new Hashtable<String, Integer>();
        for (String s: distinct) {
            dict.put(s, Collections.frequency(list, s));
        }
        return dict;
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
