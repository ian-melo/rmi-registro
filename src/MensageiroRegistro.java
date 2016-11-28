public interface MensageiroRegistro {
    /**
     * Insere um item no banco de dados
     * @param item Item a ser inserido
     * @return true, se sucesso<br/>false, se insucesso
     */
    public abstract boolean inserir(String[] item);
    /**
     * Altera um item no banco de dados
     * @param item Item a ser alterado
     * @return true, se sucesso<br/>false, se insucesso
     */
    public abstract boolean alterar(String[] item);
    /**
     * Exclui um item no banco de dados
     * @param item Item a ser excluído
     * @return true, se sucesso<br/>false, se insucesso
     */
    public abstract boolean excluir(String[] item);
    /**
     * Procura um item no banco de dados
     * @param id Identificador do item a ser procurado
     * @return vetor com os valores da busca
     */
    public abstract String[] procurar(String id);
    /**
     * Lista todos os itens do banco de dados
     * @return matriz com a relação de resultados
     */
    public abstract Object[][] listar();
    /**
     * Procura um item no banco de dados (com informações limitadas)
     * @param id Identificador do item a ser procurado
     * @return vetor com os valores da busca
     */
    public abstract String[] procurarLimitado(String id);
}