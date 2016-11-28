public class MensageiroImpl implements MensageiroRegistro {
    //IMPLEMENTADOS
    @Override
    public boolean inserir(String[] item) {
            return false;
    }
    @Override
    public boolean alterar(String[] item) {
            return false;
    }
    @Override
    public boolean excluir(String[] item) {
            return false;
    }
    @Override
    public String[] procurar(String item) {
            return null;
    }
    @Override
    public Object[][] listar() {
            return null;
    }
    @Override
    public String[] procurarLimitado(String id) {
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