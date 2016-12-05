import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Mensageiro de registro
 * <br/><br/>
 * O parâmetro item deve seguir a seguinte ordem:<br/>
 * [0] - CNPJ<br/>
 * [1] - Razão Social<br/>
 * [2] - Nome Fantasia<br/>
 * [3] - Telefone (DDD)<br/>
 * [4] - Inscrição Municipal<br/>
 * [5] - Inscrição Estadual<br/>
 * [6] - E-mail<br/>
 * [7] - Data de Constituição (formato dd/mm/aaaa)<br/>
 * [8] - Atividades Exercidas<br/>
 * [9] - Gênero da Atividade<br/>
 * [10] - Espécie de Atividade<br/>
 * [11] - CEP<br/>
 * [12] - Número<br/>
 * [13] - Complemento<br/>
 * [14] - Logradouro<br/>
 * [15] - Bairro<br/>
 * [16] - Cidade<br/>
 * [17] - Estado<br/>
 * [18] - País<br/>
 * [19] - CPF do representante<br/>
 * [20] - Nome do representante<br/>
 * [21] - Telefone do representante<br/>
 * <br/><br/>
 * Para retorno de busca (exceto a limitada), a regra é a mesma. Assim como para listagem, através da<br/>
 * ordem lista[<i>num_de_itens</i>][<i>params</i>]. Verifique se há retorno <i>null</i><br/>
 * antes de realizar qualquer operação (para qualquer retorno não booleano). O <i>id</i> corresponde ao CNPJ<br/>
 * da pessoa jurídica.
 * <br/><br/>
 * Para busca limitada, o retorno é tem a seguinte ordem:<br/>
 * [0] - Atividades Exercidas<br/>
 * [1] - Gênero da Atividade<br/>
 * [2] - Espécie de Atividade<br/>
 * [3] - CEP<br/>
 * [4] - Número<br/>
 * [5] - Complemento<br/>
 * [6] - Logradouro<br/>
 * [7] - Bairro<br/>
 * [8] - Cidade<br/>
 * [9] - Estado<br/>
 * [10] - País<br/>
 * @author I.
 */
public interface MensageiroRegistro extends Remote {
    /**
     * Insere um item no banco de dados
     * @param item Item a ser inserido
     * @param usuario Conta de usuário administrador
     * @param senha Senha de usuário administrador
     * @return true, se sucesso<br/>false, se insucesso
     * @throws java.rmi.RemoteException
     */
    public abstract boolean inserir(String[] item, String usuario, String senha) throws RemoteException;
    /**
     * Altera um item no banco de dados
     * @param item Item a ser alterado
     * @param usuario Conta de usuário administrador
     * @param senha Senha de usuário administrador
     * @return true, se sucesso<br/>false, se insucesso
     * @throws java.rmi.RemoteException
     */
    public abstract boolean alterar(String[] item, String usuario, String senha) throws RemoteException;
    /**
     * Exclui um item no banco de dados
     * @param item Item a ser excluído
     * @param usuario Conta de usuário administrador
     * @param senha Senha de usuário administrador
     * @return true, se sucesso<br/>false, se insucesso
     * @throws java.rmi.RemoteException
     */
    public abstract boolean excluir(String[] item, String usuario, String senha) throws RemoteException;
    /**
     * Procura um item no banco de dados
     * @param id Identificador do item a ser procurado
     * @param usuario Conta de usuário administrador
     * @param senha Senha de usuário administrador
     * @return vetor com os valores da busca
     * @throws java.rmi.RemoteException
     */
    public abstract String[] procurar(String id, String usuario, String senha) throws RemoteException;
    /**
     * Lista todos os itens do banco de dados
     * @return matriz com a relação de resultados
     * @param usuario Conta de usuário administrador
     * @param senha Senha de usuário administrador
     * @throws java.rmi.RemoteException
     */
    public abstract Object[][] listar(String usuario, String senha) throws RemoteException;
    /**
     * Procura um item no banco de dados (com informações limitadas)
     * @param id Identificador do item a ser procurado
     * @return vetor com os valores da busca
     * @throws java.rmi.RemoteException
     */
    public abstract String[] procurarLimitado(String id) throws RemoteException;
}