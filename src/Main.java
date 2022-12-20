import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha = 0;
        Cliente helena = new Cliente();
        Conta contaDaHelena = new Conta();

        contaDaHelena.numConta = "1212";
        contaDaHelena.agencia ="1";
        contaDaHelena.saldo = 468;

        helena.nome = "Helena";
        helena.cpf = "111";
        helena.senha = "galinhaPintadinha";
        helena.conta = contaDaHelena;


        boolean islogado = false;
        while (!islogado){
            System.out.println("Vamos logar!");
            System.out.println("Digite o CPF:");
            String cpf = scanner.nextLine();
            System.out.println("Digite a senha: ");
            String senha = scanner.nextLine();
            if(helena.cpf.equals(cpf) && helena.senha.equals(senha)){
                islogado = true;
            }else{
                System.out.println("Informações inválidas!");
            }
        }

        while (islogado){
            System.out.println();
            System.out.println("Escolha uma das opções:");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Consultar saldo");
            System.out.println("0 - Deslogar");
            escolha = scanner.nextInt();
            if(escolha == 0){
                islogado = false;
                System.out.println("Deslogou do banco!");
            }else if (escolha == 1){
                System.out.println("Digite o valor do saque: ");
                double retirada = scanner.nextDouble();
                if(helena.conta.saldo >= retirada){
                    helena.conta.saldo -= retirada;
                    System.out.println("Saque feito!");
                    System.out.println("Saldo da conta: "+helena.conta.saldo);
                }else {
                    System.out.println("Saldo indisponível!");
                }
            }else if(escolha == 2){
                System.out.println("Digite o valor a depositar: ");
                double deposito = scanner.nextDouble();
                if(deposito <= 0){
                    System.out.println("Valor inválido!");
                }else {
                    helena.conta.saldo += deposito;
                    System.out.println("Depósito feito");
                    System.out.println("Saldo da conta: "+helena.conta.saldo);
                }
            }else if(escolha == 3){
                System.out.println("Saldo da conta: "+helena.conta.saldo);
            }else{
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Encerrou tudo!");
    }
}