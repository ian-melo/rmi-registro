import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Mensageiro de registro<br/><br/>
 * O parâmetro item deve seguir a seguinte ordem
 * Cnpj
 * RazaoSocial
 * NomeFantasia
 * TelefoneDd
 * InscricaoMunicipal
 * InscricaoEstadual
 * Email
 * DataConstituicao (formato dd/mm/aaaa)
 * Atividades
 * setGeneroAtividade
 * EspecieAtividade
 * Cep
 * Numero
 * Complemento
 * Logradouro
 * Bairro
 * Cidade
 * Estado
 * Pais
 * Cpf
 * Nome
 * Telefone
 * @author I.
 */
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