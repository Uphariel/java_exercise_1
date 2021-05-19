import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Launcher {
    public static void main(String[] args){
        System.out.println("Bonjour a tous et bienvenue");
        Scanner scan = new Scanner(System.in);

        List<Command> commands = new ArrayList<Command>();
        commands.add(new Quit());
        commands.add(new Fibo());
        commands.add(new Freq());

        String input;
        boolean stop = false;
        while (! stop) {
            input = scan.nextLine();
            for (Command command : commands) {
                if (command.name().equals(input))
                    if(command.run(scan)) {
                        stop = true;
                        break;
                    }
            }
        }
    }

}
