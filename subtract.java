import java.rmi.*;

public interface subtract extends Remote {
    double subtract(double a, double b) throws RemoteException;
}
