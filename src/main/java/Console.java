import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
Scanner scanner = new Scanner(System.in);

                    // NEED TO CHANGE BOTH METHODS TO ENTER INPUT ON ANOTHER LINE
    int getNumber(String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }

    String getString(String message){
        while(true){
            System.out.println(message);
            try {
                return scanner.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("\"" + scanner.next() + "\" isn't a word!");
            }
        }
    }
}
