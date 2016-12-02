import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PessoaJurDAO implements DAO<PessoaJur> {
    //IMPLEMENTADOS
    @Override
    public boolean inserir(PessoaJur item) {
        //Valida os dados ao inserir
        if( !(validarCep(item.getEndereco().getCep()) && validarCpf(item.getRepresentante().getCpf())
            && validarCnpj(item.getCnpj())) )
            return false;
        //Para, se o item já existir
        if(procurar(item) != null)
            return false;
        //Processo normal
        //Persist.
        BancoDados bd = new BancoDados();
        PreparedStatement ps;
        ResultSet rs;
        String sql;
        //Negócio
        Endereco en;
        Representante re;
        int codRe = 0;
        //Obtém item
        re = item.getRepresentante();
        en = item.getEndereco();
        //Realiza inserção
        try {
            //Representante - Busca
            //Define String
            sql = "SELECT * FROM Representante WHERE Cpf=? AND XDEAD=FALSE";
            //Abre banco e prepara gatilho
            ps = bd.abrirConexao().prepareStatement(sql);
            //Atribui os dados
            ps.setString(1, re.getCpf());
            //Executa e puxa a busca
            rs = ps.executeQuery();
            //Se não houver representante, insere
            if(!rs.next()){
                bd.fecharConexao();
                //Representante - Inserção
                //Define String
                sql = "INSERT INTO Representante VALUES(NULL,?,?,?,FALSE)";
                //Abre banco e prepara gatilho
                ps = bd.abrirConexao().prepareStatement(sql);
                //Prepara valores
                ps.setString(1, re.getCpf());
                ps.setString(2, re.getNome());
                ps.setString(3, re.getTelefone());
                //Executa inserção
                ps.executeUpdate();
                //Fecha conexão
                bd.fecharConexao();
                
                //Representante - código
                //Define String
                sql = "SELECT * FROM Representante WHERE Cpf=? AND XDEAD=FALSE";
                //Abre banco e prepara gatilho
                ps = bd.abrirConexao().prepareStatement(sql);
                //Prepara valores
                ps.setString(1, re.getCpf());
                //Executa inserção
                rs = ps.executeQuery();
                //Busca código
                if(rs.next()) {
                    codRe = rs.getInt("CodRepresentante");
                }
            //Se houver, busca o código
            } else {
                codRe = rs.getInt("CodRepresentante");
            }
            //Fecha conexão
            bd.fecharConexao();
            //Pessoa Jurídica - Inserção
            //Define String
            sql = "INSERT INTO PessoaJur VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,FALSE)";
            //Abre banco e prepara gatilho
            ps = bd.abrirConexao().prepareStatement(sql);
            //Seta valores
            ps.setInt(1,codRe);
            ps.setString(2,item.getCnpj());
            ps.setString(3,item.getRazaoSocial());
            ps.setString(4,item.getNomeFantasia());
            ps.setString(5,item.getTelefoneDd());
            ps.setString(6,item.getInscricaoMunicipal());
            ps.setString(7,item.getInscricaoEstadual());
            ps.setString(8,item.getEmail());
            ps.setDate(9,new java.sql.Date(item.getDataConstituicao().getTime()));
            ps.setString(10,item.getAtividades());
            ps.setString(11,item.getGeneroAtividade());
            ps.setString(12,item.getEspecieAtividade());
            //Endereço
            ps.setString(13,en.getCep());
            ps.setString(14,en.getNumero());
            ps.setString(15,en.getComplemento());
            ps.setString(16,en.getLogradouro());
            ps.setString(17,en.getBairro());
            ps.setString(18,en.getCidade());
            ps.setString(19,en.getEstado());
            ps.setString(20,en.getPais());
            //Executa e puxa a busca
            ps.executeUpdate();
            //Fecha conexão
            bd.fecharConexao();
        } catch(SQLException ex) {
            return false;
        } catch(ConexaoException ex) {
            return false;
        }
        return true;
    }
    @Override
    public boolean alterar(PessoaJur item) {
        //Valida os dados ao alterar
        if( !(validarCep(item.getEndereco().getCep()) && validarCpf(item.getRepresentante().getCpf())
            && validarCnpj(item.getCnpj())) )
            return false;
        //Para, se o item não existir
        if(procurar(item) == null)
            return false;
        //Processo normal
        //Persist.
        BancoDados bd = new BancoDados();
        PreparedStatement ps;
        String sql;
        //Negócio
        Endereco en;
        Representante re;
        //Obtém item
        re = item.getRepresentante();
        en = item.getEndereco();
        //Realiza alteração
        try {
            //Define String
            sql = "UPDATE PessoaJur SET RazaoSocial='"+item.getRazaoSocial()+"', NomeFantasia='"+item.getNomeFantasia()+"',"
                + " TelefoneDd='"+item.getTelefoneDd()+"', InscriMunicipal='"+item.getInscricaoMunicipal()+"',"
                + " InscriEstadual='"+item.getInscricaoEstadual()+"', Email='"+item.getEmail()+"',"
                + " DataConstituicao='"+item.getDataConstituicao()+"', Atividades='"+item.getAtividades()+"', GeneroAtividade='"+item.getGeneroAtividade()+"',"
                + " EspecieAtividade='"+item.getEspecieAtividade()+"', Cep='"+en.getCep()+"',"
                + " Numero='"+en.getNumero()+"', Complemento='"+en.getComplemento()+"', Logradouro='"+en.getLogradouro()+"', Bairro='"+en.getBairro()+"', Cidade='"+en.getCidade()+"',"
                + " Estado='"+en.getEstado()+"', Pais='"+en.getPais()+"'"
                + " WHERE Cnpj='"+item.getCnpj()+"' AND XDEAD=FALSE";
            //Abre banco e prepara gatilho
            ps = bd.abrirConexao().prepareStatement(sql);
            //Executa atualização
            ps.executeUpdate();
            //Fecha conexão
            bd.fecharConexao();
            
            //Define String - Representante
            sql = "UPDATE Representante SET Nome='"+re.getNome()+"', Telefone='"+re.getTelefone()+"'"
                + " WHERE Cpf='"+re.getCpf()+"' AND XDEAD=FALSE";
            //Abre banco e prepara gatilho
            ps = bd.abrirConexao().prepareStatement(sql);
            //Executa atualização
            ps.executeUpdate();
            //Fecha conexão
            bd.fecharConexao();
        } catch(SQLException ex) {
            return false;
        } catch(ConexaoException ex) {
            return false;
        }
        return true;
    }
    @Override
    public boolean excluir(PessoaJur item) {
        //Valida os dados ao excluir
        if( !(validarCnpj(item.getCnpj())) )
            return false;
        //Para, se o item não existir
        if(procurar(item) == null)
            return false;
        //Processo normal
        //Persist.
        BancoDados bd = new BancoDados();
        PreparedStatement ps;
        String sql;
        //Negócio
        PessoaJur pj;
        //Obtém item
        pj = item;
        //Realiza exclusão
        try {
            //Define String
            sql = "UPDATE PessoaJur SET XDEAD=TRUE WHERE Cnpj= '" + pj.getCnpj() + "'";
            //Abre banco e prepara gatilho
            ps = bd.abrirConexao().prepareStatement(sql);
            //Executa exclusão
            ps.executeUpdate();
            //Fecha conexão
            bd.fecharConexao();
        } catch(SQLException ex) {
            return false;
        } catch(ConexaoException ex) {
            return false;
        }
        return true;
    }
    @Override
    public PessoaJur procurar(PessoaJur item) {
        //Valida os dados ao procurar
        if( !(validarCnpj(item.getCnpj())) )
            return null;
        //Processo normal
        //Persist.
        BancoDados bd = new BancoDados();
        PreparedStatement ps;
        ResultSet rs;
        String sql;
        //Negócio
        PessoaJur pj;
        Representante re;
        Endereco en;
        int codRe;
        //Obtém item
        pj = item;
        //Realiza busca
        try {
            //Define String
            sql = "SELECT * FROM PessoaJur WHERE Cnpj=? AND XDEAD=FALSE";
            //Abre banco e prepara gatilho
            ps = bd.abrirConexao().prepareStatement(sql);
            //Atribui os dados
            ps.setString(1, pj.getCnpj());
            //Executa e puxa a busca
            rs = ps.executeQuery();
            //Verifica se houve resultados e atribui valores ao objeto
            if(rs.next()){
                //Pessoa jurídica
                pj.setCnpj(rs.getString("Cnpj"));
                pj.setRazaoSocial(rs.getString("RazaoSocial"));
                pj.setNomeFantasia(rs.getString("NomeFantasia"));
                pj.setTelefoneDd(rs.getString("TelefoneDd"));
                pj.setInscricaoMunicipal(rs.getString("InscriMunicipal"));
                pj.setInscricaoEstadual(rs.getString("InscriEstadual"));
                pj.setEmail(rs.getString("Email"));
                pj.setDataConstituicao(new java.util.Date(rs.getDate("DataConstituicao").getTime()));
                pj.setAtividades(rs.getString("Atividades"));
                pj.setGeneroAtividade(rs.getString("GeneroAtividade"));
                pj.setEspecieAtividade(rs.getString("EspecieAtividade"));
                //Endereço
                en = new Endereco();
                en.setCep(rs.getString("Cep"));
                en.setNumero(rs.getString("Numero"));
                en.setComplemento(rs.getString("Complemento"));
                en.setLogradouro(rs.getString("Logradouro"));
                en.setBairro(rs.getString("Bairro"));
                en.setCidade(rs.getString("Cidade"));
                en.setEstado(rs.getString("Estado"));
                en.setPais(rs.getString("Pais"));
                pj.setEndereco(en);
                
                //Representante
                codRe = rs.getInt("CodRepresentante");
                //Define String
                sql = "SELECT * FROM Representante WHERE CodRepresentante=? AND XDEAD=FALSE";
                //Fecha, abre banco e prepara gatilho
                bd.fecharConexao();
                ps = bd.abrirConexao().prepareStatement(sql);
                //Atribui os dados
                ps.setInt(1, codRe);
                //Executa e puxa a busca
                rs = ps.executeQuery();
                //Verifica se houve resultados e atribui valores ao objeto
                re = new Representante();
                if(rs.next()){
                    re.setCpf(rs.getString("Cpf"));
                    re.setNome(rs.getString("Nome"));
                    re.setTelefone(rs.getString("Telefone"));
                }
                pj.setRepresentante(re);
            } else {
                pj = null;
            }
            //Prossegue procedimento
            bd.fecharConexao();
        } catch(SQLException ex) {
            return null;
        } catch(ConexaoException ex) {
            return null;
        }
        return pj;
    }
    @Override
    public java.util.List<PessoaJur> listar() {
        //Persist.
        BancoDados bd = new BancoDados();
        PreparedStatement ps;
        ResultSet rs;
        String sql;
        //Negócio
        List<PessoaJur> li = new ArrayList<>();
        PessoaJur pj;
        Representante re;
        Endereco en;
        int codRe;
        //Realiza busca
        try {
            //Define String
            sql = "SELECT * FROM PessoaJur WHERE XDEAD=FALSE";
            //Abre banco e prepara gatilho
            ps = bd.abrirConexao().prepareStatement(sql);
            //Executa e puxa a busca
            rs = ps.executeQuery();
            //Verifica se houve resultados e atribui valores ao objeto
            while(rs.next()){
                //Pessoa jurídica
                pj = new PessoaJur();
                pj.setCnpj(rs.getString("Cnpj"));
                pj.setRazaoSocial(rs.getString("RazaoSocial"));
                pj.setNomeFantasia(rs.getString("NomeFantasia"));
                pj.setTelefoneDd(rs.getString("TelefoneDd"));
                pj.setInscricaoMunicipal(rs.getString("InscriMunicipal"));
                pj.setInscricaoEstadual(rs.getString("InscriEstadual"));
                pj.setEmail(rs.getString("Email"));
                pj.setDataConstituicao(new java.util.Date(rs.getDate("DataConstituicao").getTime()));
                pj.setAtividades(rs.getString("Atividades"));
                pj.setGeneroAtividade(rs.getString("GeneroAtividade"));
                pj.setEspecieAtividade(rs.getString("EspecieAtividade"));
                //Endereço
                en = new Endereco();
                en.setCep(rs.getString("Cep"));
                en.setNumero(rs.getString("Numero"));
                en.setComplemento(rs.getString("Complemento"));
                en.setLogradouro(rs.getString("Logradouro"));
                en.setBairro(rs.getString("Bairro"));
                en.setCidade(rs.getString("Cidade"));
                en.setEstado(rs.getString("Estado"));
                en.setPais(rs.getString("Pais"));
                pj.setEndereco(en);
                
                //Representante
                codRe = rs.getInt("CodRepresentante");
                //Define String
                sql = "SELECT * FROM Representante WHERE CodRepresentante=? AND XDEAD=FALSE";
                //Fecha, abre banco e prepara gatilho
                bd.fecharConexao();
                ps = bd.abrirConexao().prepareStatement(sql);
                //Atribui os dados
                ps.setInt(1, codRe);
                //Executa e puxa a busca
                rs = ps.executeQuery();
                //Verifica se houve resultados e atribui valores ao objeto
                re = new Representante();
                if(rs.next()){
                    re.setCpf(rs.getString("Cpf"));
                    re.setNome(rs.getString("Nome"));
                    re.setTelefone(rs.getString("Telefone"));
                }
                pj.setRepresentante(re);
                li.add(pj);
            }
            //Prossegue procedimento
            bd.fecharConexao();
        } catch(SQLException ex) {
            return null;
        } catch(ConexaoException ex) {
            return null;
        }
        return li;
    }
    
    //VALIDADORES
    /**
     * Valida o CPF
     * @param cpf CPF a ser validado
     * @return true, caso válido<br/>false, caso contrário
     */
    private boolean validarCpf(String cpf) {
        if(cpf == null)
            cpf = "";
        return Pattern.matches("(\\d{3}).(\\d{3}).(\\d{3})-([0-9X]{2})", cpf);
    }
    /**
     * Valida o CNPJ
     * @param cnpj CNPJ a ser validado
     * @return true, caso válido<br/>false, caso contrário
     */
    private boolean validarCnpj(String cnpj) {
        if(cnpj == null)
            cnpj = "";
        return Pattern.matches("(\\d{2}).(\\d{3}).(\\d{3})/(\\d{4})-(\\d{2})", cnpj);
    }
    /**
     * Valida o CEP
     * @param cep CEP a ser validado
     * @return true, caso válido<br/>false, caso contrário
     */
    private boolean validarCep(String cep) {
        if(cep == null)
            cep = "";
        return Pattern.matches("(\\d{5})-(\\d{3})", cep);
    }
}