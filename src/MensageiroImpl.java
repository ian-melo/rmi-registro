import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class MensageiroImpl extends UnicastRemoteObject
implements MensageiroRegistro {
    //CONSTRUTOR
    public MensageiroImpl() throws RemoteException {
        super();
    }
    
    //IMPLEMENTADOS
    @Override
    public boolean inserir(String[] item) throws RemoteException {
        if(!verificarUsuario())
            return false;
        //Pessoa Jurídica
        PessoaJur pj = new PessoaJur();
        pj.setCnpj("");
        pj.setRazaoSocial("");
        pj.setNomeFantasia("");
        pj.setTelefoneDd("");
        pj.setInscricaoMunicipal("");
        pj.setInscricaoEstadual("");
        pj.setEmail("");
        pj.setDataConstituicao(new java.util.Date());
        pj.setAtividades("");
        pj.setGeneroAtividade("");
        pj.setEspecieAtividade("");
        //Endereço
        Endereco en = new Endereco();
        en.setCep("");
        en.setNumero("");
        en.setComplemento("");
        en.setLogradouro("");
        en.setBairro("");
        en.setCidade("");
        en.setEstado("");
        en.setPais("");
        pj.setEndereco(en);
        //Representante
        Representante re = new Representante();
        re.setCpf("");
        re.setNome("");
        re.setTelefone("");
        pj.setRepresentante(re);
        
        DAO dao = new PessoaJurDAO();
        return dao.inserir(item);
    }
    @Override
    public boolean alterar(String[] item) throws RemoteException {
        if(!verificarUsuario())
            return false;
        //!
        DAO dao = new PessoaJurDAO();
        return dao.alterar(item);
    }
    @Override
    public boolean excluir(String[] item) throws RemoteException {
        if(!verificarUsuario())
            return false;
        //!
        DAO dao = new PessoaJurDAO();
        return dao.excluir(item);
    }
    @Override
    public String[] procurar(String id) throws RemoteException {
        if(!verificarUsuario())
            return null;
        //!
        String[] res = new String[25];
        DAO dao = new PessoaJurDAO();
        res[1] = dao.procurar(id).toString();
        return res;
    }
    @Override
    public Object[][] listar() throws RemoteException {
        if(!verificarUsuario())
            return null;
        //!
        String[][] res = new String[25][20];
        DAO dao = new PessoaJurDAO();
        res[0][1] = dao.listar().toString();
        return res;
    }
    @Override
    public String[] procurarLimitado(String id) throws RemoteException {
        //!
        String[] res = new String[25];
        DAO dao = new PessoaJurDAO();
        res[1] = dao.procurar(id).toString();
        return res;
    }
    
    //METODOS
    /**
     * Verifica se usuário administrador está logado
     * @return true, caso esteja<br/>false, caso contrário
     */
    private boolean verificarUsuario() {
        try {
            //MensageiroVerifica
            LocateRegistry.getRegistry("127.0.0.1");
            MensageiroVerifica menV = (MensageiroVerifica) Naming.lookup("rmi://localhost:14002/MensageiroVerifica");
            return menV.isUsuarioLogado();
        } catch (Exception ex) {
            System.out.println("Erro na verificação: " + ex.getMessage());
            return false;
        }
    }
}