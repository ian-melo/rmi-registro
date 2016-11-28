public interface DAO {
    /**
     * 
     * @param item
     * @return 
     */
    public abstract boolean inserir(Object item);
    /**
     * 
     * @param item
     * @return 
     */
    public abstract boolean alterar(Object item);
    /**
     * 
     * @param item
     * @return 
     */
    public abstract boolean excluir(Object item);
    /**
     * 
     * @param item
     * @return 
     */
    public abstract Object procurar(Object item);
    /**
     * 
     * @return 
     */
    public abstract Object[] listar();
}