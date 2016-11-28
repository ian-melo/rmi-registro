public interface MensageiroRegistro {

    public abstract boolean inserir(String[] item);

    public abstract boolean alterar(String[] item);

    public abstract boolean excluir(String[] item);

    public abstract String[] procurar(String item);

    public abstract Object[] listar();
}
