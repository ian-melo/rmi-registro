

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexão com banco de dados
 * @author SCS214
 */
public class BancoDados {
    /**
     * Conexão do banco
     */
    private Connection conexao = null;
    /**
     * Nome do driver MySQL do JDBC
     */
    private final String driver = "com.mysql.jdbc.Driver";
    /**
     * Caminho do BD da livraria
     */
    private String caminho = "jdbc:mysql://localhost:3306/cadastroPJ";
    /**
     * Usuário do banco de dados
     */
    private String usuario = "root";
    /**
     * Senha do banco de dados
     */
    private String senha = "root";
    
    /*CONSTRUTORES*/
    /**
     * Cria uma conexão, com valores definidos
     * @param banco Nome do banco de dados
     * @param usuario Usuário do banco de dados
     * @param senha Senha do banco de dados
     */
    public BancoDados(String banco, String usuario, String senha) {
        //Define valores para conexão
        this.caminho = "jdbc:mysql://localhost:3306/" + banco;
        this.usuario = usuario;
        this.senha = senha;
    }
    /**
     * Cria uma conexão, com valores padrão
     */
    public BancoDados() {
        
    }
    
    /**
     * Abre a conexão com o banco de dados e retorna-a
     * @return Conexão do banco de dados
     * @throws ConexaoException Caso encontre algum erro em conectar com o banco
     */
    public Connection abrirConexao() throws ConexaoException {
        try {
            //Ligação com o driver
            Class.forName(driver);
            //Caminho do banco
            conexao = DriverManager.getConnection(caminho, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            //Joga exceção caso não tenha conseguido se conectar
            throw new ConexaoException("Não foi possível conectar ao banco de dados." + ex.getMessage());
        }
        //Retorna a conexão, caso tenha sido sucesso
        return conexao;
    }
    /**
     * Fecha a conexão com o banco de dados
     * @throws ConexaoException Caso encontre algum erro em fechar o banco
     */
    public void fecharConexao() throws ConexaoException {
        try {
            conexao.close();
        } catch(SQLException ex) {
            //Joga uma exceção, caso não tenha conseguido fechar
            throw new ConexaoException("Não foi possível fechar o banco de dados.");
        }
    }
}