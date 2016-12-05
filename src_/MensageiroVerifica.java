import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MensageiroVerifica extends Remote {
    /**
     * Verifica se o usuário administrador está logado
     * @return true, se estiver logado<br/>false, caso contrário
     * @throws java.rmi.RemoteException
     */
    public abstract boolean isUsuarioLogado() throws RemoteException;
}