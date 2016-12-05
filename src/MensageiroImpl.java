
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class MensageiroImpl extends UnicastRemoteObject
        implements MensageiroRegistro {

    //CONSTRUTOR

    public MensageiroImpl() throws RemoteException {
        super();
    }

    //IMPLEMENTADOS
    @Override
    public boolean inserir(String[] item, String usuario, String senha) throws RemoteException {
        if (!verificarUsuario(usuario, senha)) {
            return false;
        }
        //Verifica se a data está no formato correto
        if (!Pattern.matches("(\\d{2})/(\\d{2})/(\\d{4})", item[7])) {
            return false;
        }
        //Configurações de data
        String[] dataArr = item[7].split("/");
        Date data = new Date((Integer.parseInt(dataArr[2]) - 1900), (Integer.parseInt(dataArr[1]) - 1), Integer.parseInt(dataArr[0]));
        //Pessoa Jurídica
        PessoaJur pj = new PessoaJur();
        pj.setCnpj(item[0]);
        pj.setRazaoSocial(item[1]);
        pj.setNomeFantasia(item[2]);
        pj.setTelefoneDd(item[3]);
        pj.setInscricaoMunicipal(item[4]);
        pj.setInscricaoEstadual(item[5]);
        pj.setEmail(item[6]);
        pj.setDataConstituicao(data);
        pj.setAtividades(item[8]);
        pj.setGeneroAtividade(item[9]);
        pj.setEspecieAtividade(item[10]);
        //Endereço
        Endereco en = new Endereco();
        en.setCep(item[11]);
        en.setNumero(item[12]);
        en.setComplemento(item[13]);
        en.setLogradouro(item[14]);
        en.setBairro(item[15]);
        en.setCidade(item[16]);
        en.setEstado(item[17]);
        en.setPais(item[18]);
        pj.setEndereco(en);
        //Representante
        Representante re = new Representante();
        re.setCpf(item[19]);
        re.setNome(item[20]);
        re.setTelefone(item[21]);
        pj.setRepresentante(re);

        DAO dao = new PessoaJurDAO();
        return dao.inserir(pj);
    }

    @Override
    public boolean alterar(String[] item, String usuario, String senha) throws RemoteException {
        if (!verificarUsuario(usuario, senha)) {
            return false;
        }
        //Verifica se a data está no formato correto
        if (!Pattern.matches("(\\d{2})/(\\d{2})/(\\d{4})", item[7])) {
            return false;
        }
        //Configurações de data
        String[] dataArr = item[7].split("/");
        Date data = new Date((Integer.parseInt(dataArr[2]) - 1900), (Integer.parseInt(dataArr[1]) - 1), Integer.parseInt(dataArr[0]));

        //Pessoa Jurídica
        PessoaJur pj = new PessoaJur();
        pj.setCnpj(item[0]);
        pj.setRazaoSocial(item[1]);
        pj.setNomeFantasia(item[2]);
        pj.setTelefoneDd(item[3]);
        pj.setInscricaoMunicipal(item[4]);
        pj.setInscricaoEstadual(item[5]);
        pj.setEmail(item[6]);
        pj.setDataConstituicao(data);
        pj.setAtividades(item[8]);
        pj.setGeneroAtividade(item[9]);
        pj.setEspecieAtividade(item[10]);
        //Endereço
        Endereco en = new Endereco();
        en.setCep(item[11]);
        en.setNumero(item[12]);
        en.setComplemento(item[13]);
        en.setLogradouro(item[14]);
        en.setBairro(item[15]);
        en.setCidade(item[16]);
        en.setEstado(item[17]);
        en.setPais(item[18]);
        pj.setEndereco(en);
        //Representante
        Representante re = new Representante();
        re.setCpf(item[19]);
        re.setNome(item[20]);
        re.setTelefone(item[21]);
        pj.setRepresentante(re);

        DAO dao = new PessoaJurDAO();
        return dao.alterar(pj);
    }

    @Override
    public boolean excluir(String[] item, String usuario, String senha) throws RemoteException {
        if (!verificarUsuario(usuario, senha)) {
            return false;
        }
        //Verifica se a data está no formato correto
        if (!Pattern.matches("(\\d{2})/(\\d{2})/(\\d{4})", item[7])) {
            return false;
        }
        //Configurações de data
        String[] dataArr = item[7].split("/");
        Date data = new Date((Integer.parseInt(dataArr[2]) - 1900), (Integer.parseInt(dataArr[1]) - 1), Integer.parseInt(dataArr[0]));

        //Pessoa Jurídica
        PessoaJur pj = new PessoaJur();
        pj.setCnpj(item[0]);
        pj.setRazaoSocial(item[1]);
        pj.setNomeFantasia(item[2]);
        pj.setTelefoneDd(item[3]);
        pj.setInscricaoMunicipal(item[4]);
        pj.setInscricaoEstadual(item[5]);
        pj.setEmail(item[6]);
        pj.setDataConstituicao(data);
        pj.setAtividades(item[8]);
        pj.setGeneroAtividade(item[9]);
        pj.setEspecieAtividade(item[10]);
        //Endereço
        Endereco en = new Endereco();
        en.setCep(item[11]);
        en.setNumero(item[12]);
        en.setComplemento(item[13]);
        en.setLogradouro(item[14]);
        en.setBairro(item[15]);
        en.setCidade(item[16]);
        en.setEstado(item[17]);
        en.setPais(item[18]);
        pj.setEndereco(en);
        //Representante
        Representante re = new Representante();
        re.setCpf(item[19]);
        re.setNome(item[20]);
        re.setTelefone(item[21]);
        pj.setRepresentante(re);

        DAO dao = new PessoaJurDAO();
        return dao.excluir(pj);
    }

    @Override
    public String[] procurar(String id, String usuario, String senha) throws RemoteException {
        if (!verificarUsuario(usuario, senha)) {
            return null;
        }

        PessoaJur pj;
        Endereco en;
        Representante re;
        String[] res = new String[22];

        pj = new PessoaJur();
        pj.setCnpj(id);
        PessoaJurDAO dao = new PessoaJurDAO();
        pj = dao.procurar(pj);
        //Retorna null, caso não tenha encontrado
        if (pj == null) {
            return null;
        }
        //Configurações de data
        Date data = pj.getDataConstituicao();
        String dataStr = data.getDate() + "/" + (data.getMonth() + 1) + "/" + (data.getYear() + 1900);
        //Pessoa Jurídica
        res[0] = pj.getCnpj();
        res[1] = pj.getRazaoSocial();
        res[2] = pj.getNomeFantasia();
        res[3] = pj.getTelefoneDd();
        res[4] = pj.getInscricaoMunicipal();
        res[5] = pj.getInscricaoEstadual();
        res[6] = pj.getEmail();
        res[7] = dataStr;
        res[8] = pj.getAtividades();
        res[9] = pj.getGeneroAtividade();
        res[10] = pj.getEspecieAtividade();
        //Endereço
        en = pj.getEndereco();
        res[11] = en.getCep();
        res[12] = en.getNumero();
        res[13] = en.getComplemento();
        res[14] = en.getLogradouro();
        res[15] = en.getBairro();
        res[16] = en.getCidade();
        res[17] = en.getEstado();
        res[18] = en.getPais();
        //Representante
        re = pj.getRepresentante();
        res[19] = re.getCpf();
        res[20] = re.getNome();
        res[21] = re.getTelefone();
        return res;
    }

    @Override
    public Object[][] listar(String usuario, String senha) throws RemoteException {
        //if(!verificarUsuario(usuario,senha))
        //    return null;

        PessoaJur pj;
        Endereco en;
        Representante re;
        List<PessoaJur> li;
        PessoaJurDAO dao = new PessoaJurDAO();
        li = dao.listar();
        //Retorna null, caso houve problema ou estiver vazia
        if (li == null) {
            return null;
        }
        if (li.isEmpty()) {
            return null;
        }
        //Criação da matriz
        Object[][] liRes = new String[li.size()][22];
        for (int i = 0; i < li.size(); i++) {
            pj = li.get(i);
            //Configurações de data
            Date data = pj.getDataConstituicao();
            String dataStr = data.getDate() + "/" + (data.getMonth() + 1) + "/" + (data.getYear() + 1900);
            //Pessoa Jurídica
            
            liRes[i][0] = pj.getCnpj();
            liRes[i][1] = pj.getRazaoSocial();
            liRes[i][2] = pj.getNomeFantasia();
            liRes[i][3] = pj.getTelefoneDd();
            liRes[i][4] = pj.getInscricaoMunicipal();
            liRes[i][5] = pj.getInscricaoEstadual();
            liRes[i][6] = pj.getEmail();
            liRes[i][7] = dataStr;
            liRes[i][8] = pj.getAtividades();
            liRes[i][9] = pj.getGeneroAtividade();
            liRes[i][10] = pj.getEspecieAtividade();
            //Endereço
            en = pj.getEndereco();
            liRes[i][11] = en.getCep();
            liRes[i][12] = en.getNumero();
            liRes[i][13] = en.getComplemento();
            liRes[i][14] = en.getLogradouro();
            liRes[i][15] = en.getBairro();
            liRes[i][16] = en.getCidade();
            liRes[i][17] = en.getEstado();
            liRes[i][18] = en.getPais();
            //Representante
            re = pj.getRepresentante();
            liRes[i][19] = re.getCpf();
            liRes[i][20] = re.getNome();
            liRes[i][21] = re.getTelefone();
        }
        return liRes;
    }

    @Override
    public String[] procurarLimitado(String id) throws RemoteException {
        PessoaJur pj;
        Endereco en;
        Representante re;
        String[] res = new String[11];

        pj = new PessoaJur();
        pj.setCnpj(id);
        PessoaJurDAO dao = new PessoaJurDAO();
        pj = dao.procurar(pj);
        //Retorna null, caso não tenha encontrado
        if (pj == null) {
            return null;
        }
        //Pessoa Jurídica
        res[0] = pj.getAtividades();
        res[1] = pj.getGeneroAtividade();
        res[2] = pj.getEspecieAtividade();
        //Endereço
        en = pj.getEndereco();
        res[3] = en.getCep();
        res[4] = en.getNumero();
        res[5] = en.getComplemento();
        res[6] = en.getLogradouro();
        res[7] = en.getBairro();
        res[8] = en.getCidade();
        res[9] = en.getEstado();
        res[10] = en.getPais();
        return res;
    }

    //METODOS
    /**
     * Verifica se usuário administrador está logado
     *
     * @return true, caso esteja<br/>false, caso contrário
     */
    private boolean verificarUsuario(String usuario, String senha) {
        try {
            //MensageiroVerifica
            LocateRegistry.getRegistry("127.0.0.1");
            //LocateRegistry.getRegistry("192.168.0.103");
            MensageiroVerifica menV = (MensageiroVerifica) Naming.lookup("rmi://localhost:14002/MensageiroVerifica");
            //MensageiroVerifica
            LocateRegistry.getRegistry("127.0.0.1");
            //LocateRegistry.getRegistry("192.168.0.103");
            MensageiroAcesso menA = (MensageiroAcesso) Naming.lookup("rmi://localhost:14001/MensageiroAcesso");

            menA.entrar(usuario, senha);
            return menV.isUsuarioLogado();
        } catch (Exception ex) {
            System.out.println("Erro na verificação: " + ex.getMessage());
            return false;
        }
    }
}
