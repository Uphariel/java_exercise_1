import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Freq implements Command {
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

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scan) {
        System.out.println("Donner le chemin du fichier a analyser");
        String input = scan.nextLine();
        freqLauncher(input);
        return false;
    }
}
