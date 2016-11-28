public interface MensageiroVerifica {
    /**
     * Verifica se o usuário administrador está logado
     * @return true, se estiver logado<br/>false, caso contrário
     */
    public abstract boolean isUsuarioLogado();
}