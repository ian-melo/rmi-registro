public class PessoaJurDAO implements DAO {
    //IMPLEMENTADOS
    /**
     * 
     * @param item
     * @return 
     */
    @Override
    public boolean inserir(Object item) {
            return false;
    }
    /**
     * 
     * @param item
     * @return 
     */
    @Override
    public boolean alterar(Object item) {
            return false;
    }
    /**
     * 
     * @param item
     * @return 
     */
    @Override
    public boolean excluir(Object item) {
            return false;
    }
    /**
     * 
     * @param item
     * @return 
     */
    @Override
    public Object procurar(Object item) {
            return null;
    }
    /**
     * 
     * @return 
     */
    @Override
    public Object[] listar() {
            return null;
    }
    
    //VALIDADORES
    /**
     * 
     * @param cpf
     * @return 
     */
    private boolean validarCpf(String cpf) {
            return false;
    }
    /**
     * 
     * @param cnpj
     * @return 
     */
    private boolean validarCnpj(String cnpj) {
            return false;
    }
    /**
     * 
     * @param cep
     * @return 
     */
    private boolean validarCep(String cep) {
            return false;
    }
}