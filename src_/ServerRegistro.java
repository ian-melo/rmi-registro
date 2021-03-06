
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerRegistro {
    /**
     * Principal método de execução do servidor de registro
     * @param args Argumentos
     */
    public static void main(String[] args) {
        try {
            MensageiroRegistro menReg = new MensageiroImpl();
            //Registro de MensageiroRegistro
            LocateRegistry.createRegistry(14003);
            Naming.rebind("rmi://localhost:14003/MensageiroRegistro", menReg);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            System.exit(1);
        }
        System.out.println("Servidor de registro ativo...");
    }
}