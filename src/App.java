import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while(true) {
            String command = cin.nextLine();
            if(command.equalsIgnoreCase("exit")) System.exit(0);
            System.out.println(Command.execute(command));
        }
    }
}
