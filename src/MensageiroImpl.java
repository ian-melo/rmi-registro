import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MensageiroImpl extends UnicastRemoteObject
implements MensageiroRegistro {
    //CONSTRUTOR
    public MensageiroImpl() throws RemoteException {
        super();
    }
    
    //IMPLEMENTADOS
    @Override
    public boolean inserir(String[] item) throws RemoteException {
            return false;
    }
    @Override
    public boolean alterar(String[] item) throws RemoteException {
            return false;
    }
    @Override
    public boolean excluir(String[] item) throws RemoteException {
            return false;
    }
    @Override
    public String[] procurar(String item) throws RemoteException {
            return null;
    }
    @Override
    public Object[][] listar() throws RemoteException {
            return null;
    }
    @Override
    public String[] procurarLimitado(String id) throws RemoteException {
        return null;
    }
    
    //METODOS
    /**
     * Verifica se usuário administrador está logado
     * @return true, caso esteja<br/>false, caso contrário
     */
    private boolean verificarUsuario() {
            return false;
    }
}