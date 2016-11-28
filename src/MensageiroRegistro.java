import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MensageiroRegistro extends Remote {
    /**
     * Insere um item no banco de dados
     * @param item Item a ser inserido
     * @return true, se sucesso<br/>false, se insucesso
     * @throws java.rmi.RemoteException
     */
    public abstract boolean inserir(String[] item) throws RemoteException;
    /**
     * Altera um item no banco de dados
     * @param item Item a ser alterado
     * @return true, se sucesso<br/>false, se insucesso
     * @throws java.rmi.RemoteException
     */
    public abstract boolean alterar(String[] item) throws RemoteException;
    /**
     * Exclui um item no banco de dados
     * @param item Item a ser excluído
     * @return true, se sucesso<br/>false, se insucesso
     * @throws java.rmi.RemoteException
     */
    public abstract boolean excluir(String[] item) throws RemoteException;
    /**
     * Procura um item no banco de dados
     * @param id Identificador do item a ser procurado
     * @return vetor com os valores da busca
     * @throws java.rmi.RemoteException
     */
    public abstract String[] procurar(String id) throws RemoteException;
    /**
     * Lista todos os itens do banco de dados
     * @return matriz com a relação de resultados
     * @throws java.rmi.RemoteException
     */
    public abstract Object[][] listar() throws RemoteException;
    /**
     * Procura um item no banco de dados (com informações limitadas)
     * @param id Identificador do item a ser procurado
     * @return vetor com os valores da busca
     * @throws java.rmi.RemoteException
     */
    public abstract String[] procurarLimitado(String id) throws RemoteException;
}