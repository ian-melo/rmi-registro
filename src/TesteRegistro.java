
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteRegistro {

    public static void main(String[] args) {
        try {

            testeInserir();//necessario estar logado ou desabilitar estar logado
            testeLista();

        } catch (RemoteException ex) {
            Logger.getLogger(TesteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TesteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void testeLista() throws RemoteException {
        MensageiroImpl mR = new MensageiroImpl();

        Object[][] retorno = new Object[25][20];
        retorno = mR.listar();

    }

    public static void testeInserir() throws RemoteException {
        //CNPJ validos: 68.355.404/0001-31; 51.728.712/0001-62
        //CPF: 514.928.977-95; 431.316.038-87

        MensageiroImpl mR = new MensageiroImpl();
        String[] retorno = new String[25];

        retorno[1] = "51.728.712/0001-62";
        retorno[2] = "razaoSocial";
        retorno[3] = "NomeF";
        retorno[4] = "9999-9999";
        retorno[5] = "munucipal";
        retorno[6] = "estadual";
        retorno[7] = "email@gmail.com";
        retorno[8] = "12/01/2016";
        retorno[9] = "Atividades";
        retorno[10] = "generoAtivi";
        retorno[11] = "especialAtividade";
        retorno[12] = "14545-010";
        retorno[13] = "20";
        retorno[14] = "complemento";
        retorno[15] = "logrado";
        retorno[16] = "baisso";
        retorno[17] = "cidade";
        retorno[18] = "es";
        retorno[19] = "bra";
        retorno[20] = "431.316.038-87";
        retorno[21] = "nome rep";
        retorno[22] = "9999-8888";

        /*
         retorno[0] = "51.728.712/0001-62";
         retorno[1] = "razaoSocial";
         retorno[2] = "NomeF";
         retorno[3] = "9999-9999";
         retorno[4] = "munucipal";
         retorno[5] = "estadual";
         retorno[6] = "email@gmail.com";
         retorno[7] = "12/01/2016";
         retorno[8] = "Atividades";
         retorno[9] = "generoAtivi";
         retorno[10] = "especialAtividade";
         retorno[11] = "14545-010";
         retorno[12] = "20";
         retorno[13] = "complemento";
         retorno[14] = "logrado";
         retorno[15] = "baisso";
         retorno[16] = "cidade";
         retorno[17] = "es";
         retorno[18] = "bra";
         retorno[19] = "431.316.038-87";
         retorno[20] = "nome rep";
         retorno[21] = "9999-8888";

         */
        System.out.println(mR.inserir(retorno));

    }
}
