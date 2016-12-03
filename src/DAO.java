public interface DAO<T> {
    /**
     * Insere um item no banco de dados
     * @param item Item a ser inserido
     * @return true, se inserido com sucesso<br/>false, caso contrário
     */
    public abstract boolean inserir(T item);
    /**
     * Altera um item no banco de dados
     * @param item Item a ser alterado
     * @return true, se alterado com sucesso<br/>false, caso contrário
     */
    public abstract boolean alterar(T item);
    /**
     * Exclui um item no banco de dados
     * @param item Item a ser excluído
     * @return true, se excluído com sucesso<br/>false, caso contrário
     */
    public abstract boolean excluir(T item);
    /**
     * Busca por um item no banco de dados
     * @param item Item a ser buscado, somente com o identificador
     * @return Item, com todos os respectivos valores do resultado de busca
     */
    public abstract T procurar(T item);
    /**
     * Lista todos os itens de um tipo presentes no banco de dados
     * @return Lista com todos os itens correspondentes
     */
    public abstract java.util.List<T> listar();
}