import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class clientrmi {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            subtract service = (subtract) registry.lookup("subtractservice");

            Scanner scanner = new Scanner(System.in);
            System.out.print("enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("enter second number: ");
            double b = scanner.nextDouble();

            double result = service.subtract(a, b);
            System.out.println("result: " + result);
        } catch (Exception e) {
            System.out.println("rmi client error: " + e.getMessage());
        }
    }
}