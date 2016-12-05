import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MensageiroAcesso extends Remote {
    /**
     * Entra na conta administrador
     * @param login Login da conta
     * @param senha Senha da conta
     * @return true, caso sucesso<br/>false, caso contrário
     * @throws java.rmi.RemoteException
     */
    public abstract boolean entrar(String login, String senha) throws RemoteException;
    /**
     * Sai da conta administrador
     * @return true, caso sucesso<br/>false, caso contrário
     * @throws java.rmi.RemoteException
     */
    public abstract boolean sair() throws RemoteException;
}