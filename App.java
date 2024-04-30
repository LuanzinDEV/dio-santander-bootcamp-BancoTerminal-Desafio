import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public static void exibeMensagemBoasVindas(int numeroConta, String agencia, String nomeCliente, float saldo){
        DecimalFormat df = new DecimalFormat("#.##"); 
        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo de " + df.format(saldo) + " já está disponível para saque.");
    }

    public static void opcaoEscolha(){
        System.out.println("1-Ver Saldo");
        System.out.println("2-Sacar");
        System.out.println("3-Depositar");
        System.out.println("0-Sair");        
    }

    public static void verSaldo(float saldo){
        DecimalFormat df = new DecimalFormat("#.##"); 
        System.out.println("Seu saldo é de: " + df.format(saldo));
    }

    public static float sacar(float saldo, float valorSacado){
        saldo = saldo - valorSacado;
        return saldo;
    }

    public static float depositar(float saldo, float valorDepositado){
        saldo = saldo + valorDepositado;
        return saldo;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        int numeroConta;
        String agencia;
        String nomeCliente;
        float saldo;
        int escolhaAcao;

        System.out.println("Seja bem vindo, cadastre sua conta em nosso banco");

        System.out.println("Digite o número da conta");
        numeroConta = scan.nextInt();

        System.out.println("Digite o número da agência");
        agencia = scan.next();

        scan.nextLine(); 

        System.out.println("Digite o seu nome");
        nomeCliente = scan.nextLine();

        System.out.println("Digite o seu saldo atual");
        saldo = scan.nextFloat();

        exibeMensagemBoasVindas(numeroConta, agencia, nomeCliente, saldo);

        do{
            opcaoEscolha();
            escolhaAcao = scan.nextInt();
            float valorSaque;
            float valorDeposito;

            switch (escolhaAcao) {
                case 1:
                    verSaldo(saldo);    
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja sacar");
                    valorSaque = scan.nextFloat();
                    saldo = sacar(saldo, valorSaque);
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja depositar");
                    valorDeposito = scan.nextFloat();
                    saldo = depositar(saldo, valorDeposito);
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar nosso sistema. Até mais!");
                    break;
                default:
                    throw new AssertionError();
            }

        }while(escolhaAcao != 0);
    }
}
