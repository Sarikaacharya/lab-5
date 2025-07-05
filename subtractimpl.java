import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class subtractimpl extends UnicastRemoteObject implements subtract {
    protected subtractimpl() throws RemoteException {
        super();
    }

    public double subtract(double a, double b) throws RemoteException {
        return a - b;
    }
}