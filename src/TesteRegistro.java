
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class TesteRegistro {

    public static void main(String[] args) {
        if (!Pattern.matches("(\\d{1,2})/(\\d{1,2})/(\\d{4})", "1/1/2019")) {
            System.out.println("Inválido");
        } else {
            System.out.println("Válido");
        }
        
        /*try {
            //MensageiroVerifica
            //LocateRegistry.getRegistry("127.0.0.1");
            //MensageiroVerifica menV = (MensageiroVerifica) Naming.lookup("rmi://localhost:14002/MensageiroVerifica");
            //MensageiroVerifica
            //LocateRegistry.getRegistry("127.0.0.1");
            //MensageiroAcesso menA = (MensageiroAcesso) Naming.lookup("rmi://localhost:14001/MensageiroAcesso");
            
            if(menA.entrar("admin", "123")) {
                System.out.println("Login efetuado com sucesso!!!");
            } else {
                System.out.println("Problema no login");
                return;
            }
            
            //if(menV.isUsuarioLogado()) {
            //    System.out.println("Sucesso na verificação!!!");
            //} else {
            //    System.out.println("Problema na verificação");
            //    return;
            //}
            //System.out.println(menV.isUsuarioLogado());
            
            //testeBuscarLim(); //OK
            //testeBuscar();//OK
            //testeInserir();//OK
            //testeLista();//OK
            //testeAlterar();//OK
            //testeExcluir();//OK
            //System.exit(0);
        } catch (RemoteException ex) {
            Logger.getLogger(TesteRegistro.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        } catch (Exception ex) {
            Logger.getLogger(TesteRegistro.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }*/
    }
    
    public static void testeBuscarLim() throws RemoteException {
        MensageiroImpl mensa = new MensageiroImpl();
        String[] res;
        if((res = mensa.procurarLimitado("34.041.258/0001-58")) != null)
            System.out.println(res[0] + "\n" + res[1] + "\n" + res[2] + "\n" +
                    res[3] + "\n" + res[4] + "\n" + res[5] + "\n" + res[6] + "\n" +
                    res[7] + "\n" + res[8] + "\n" + res[9] + "\n" + res[10]);
        else
            System.out.println("Não deu.");
    }
    /*
    public static void testeBuscar() throws RemoteException {
        MensageiroImpl mensa = new MensageiroImpl();
        String[] res;
        if((res = mensa.procurar("34.041.258/0001-58")) != null)
            System.out.println(res[0] + "\n" + res[1] + "\n" + res[2] + "\n" +
                    res[3] + "\n" + res[4] + "\n" + res[5] + "\n" + res[6] + "\n" +
                    res[7] + "\n" + res[8] + "\n" + res[9] + "\n" + res[10] +
                    res[18] + "\n" + res[19] + "\n" + res[20] + "\n" + res[21]);
        else
            System.out.println("Não deu.");
    }

    public static void testeLista() throws RemoteException {
        MensageiroImpl mR = new MensageiroImpl();
        Object[][] retorno = mR.listar();
        if(retorno != null) {
            System.out.println(retorno.length);
            for(int i = 0; i < retorno.length; i++) {
                Object[] res = retorno[i];
                System.out.println("-------PessoaJur-------");
                System.out.println(res[0] + "\n" + res[1] + "\n" + res[2] + "\n" +
                        res[3] + "\n" + res[4] + "\n" + res[5] + "\n" + res[6] + "\n" +
                        res[7] + "\n" + res[8] + "\n" + res[9] + "\n" + res[10] + "\n" +
                        res[18] + "\n" + res[19] + "\n" + res[20] + "\n" + res[21]);
            }
        } else {
            System.out.println("Sem resultados ou problema.");
        }
    }
*/
    public static void testeInserir() throws RemoteException {
        //CNPJ validos: 68.355.404/0001-31; 51.728.712/0001-62
        //CPF: 514.928.977-95; 431.316.038-87
        
        MensageiroImpl mR = new MensageiroImpl();
        String[] param = new String[22];
        
        param[0] = "12.098.567/0981-62";
        param[1] = "razaoSocial";
        param[2] = "NomeF";
        param[3] = "(11)9999-9999";
        param[4] = "munucipal";
        param[5] = "estadual";
        param[6] = "email@gmail.com";
        param[7] = "12/01/2016";
        param[8] = "Atividades";
        param[9] = "generoAtivi";
        param[10] = "especialAtividade";
        param[11] = "13545-010";
        param[12] = "20";
        param[13] = "complemento";
        param[14] = "logrado";
        param[15] = "bairro";
        param[16] = "cidade";
        param[17] = "sp";
        param[18] = "brasil";
        param[19] = "433.316.038-87";
        param[20] = "nome rep";
        param[21] = "(11)99999-8888";
        System.out.println(mR.inserir(param, "adm", "123"));
    }
    /*
    
    public static void testeAlterar() throws RemoteException {
        //CNPJ validos: 68.355.404/0001-31; 51.728.712/0001-62
        //CPF: 514.928.977-95; 431.316.038-87
        
        MensageiroImpl mR = new MensageiroImpl();
        String[] param = new String[22];
        
        param[0] = "51.728.712/0001-62";
        param[1] = "RMPS LTDA.";
        param[2] = "Ritmo & Cia.";
        param[3] = "(11)9999-9999";
        param[4] = "3900";
        param[5] = "48QWS";
        param[6] = "email@gmail.com";
        param[7] = "21/01/2015";
        param[8] = "Atividades";
        param[9] = "generoAtivi";
        param[10] = "especialAtividade";
        param[11] = "14545-010";
        param[12] = "20";
        param[13] = "complemento";
        param[14] = "logrado";
        param[15] = "bairro";
        param[16] = "cidade";
        param[17] = "sp";
        param[18] = "brasil";
        param[19] = "431.316.038-87";
        param[20] = "nome rep";
        param[21] = "(11)99999-8888";
        System.out.println(mR.alterar(param));
    }
    
    public static void testeExcluir() throws RemoteException {
        //CNPJ validos: 68.355.404/0001-31; 51.728.712/0001-62
        //CPF: 514.928.977-95; 431.316.038-87
        
        MensageiroImpl mR = new MensageiroImpl();
        String[] param = new String[22];
        
        param[0] = "12.098.567/0981-62";
        param[1] = "razaoSocial";
        param[2] = "NomeF";
        param[3] = "(11)9999-9999";
        param[4] = "munucipal";
        param[5] = "estadual";
        param[6] = "email@gmail.com";
        param[7] = "12/01/2016";
        param[8] = "Atividades";
        param[9] = "generoAtivi";
        param[10] = "especialAtividade";
        param[11] = "13545-010";
        param[12] = "20";
        param[13] = "complemento";
        param[14] = "logrado";
        param[15] = "bairro";
        param[16] = "cidade";
        param[17] = "sp";
        param[18] = "brasil";
        param[19] = "433.316.038-87";
        param[20] = "nome rep";
        param[21] = "(11)99999-8888";
        System.out.println(mR.excluir(param));
    }*/
}