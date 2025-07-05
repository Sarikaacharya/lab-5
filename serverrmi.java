import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class serverrmi {
    public static void main(String[] args) {
        try {
            subtractimpl service = new subtractimpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("subtractservice", service);
            System.out.println("rmi server is ready...");
        } catch (Exception e) {
            System.out.println("rmi server error: " + e.getMessage());
        }
    }
}
