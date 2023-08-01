import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsultaCep consultaCep = new ConsultaCep();
        boolean isRunning = true;
        int entrada;
        String cep;
        String menu = """
                ~~~~~~ MENU ~~~~~~

                1- buscar CEP
                2- sair

                ~~~~~~~~~~~~~~~~~~
                """;
        Scanner leitor = new Scanner(System.in);

        while (isRunning){
            System.out.println(menu);
            entrada = leitor.nextInt();

            switch (entrada){
                case 1:
                    System.out.println("Digite o CEP (apenas números): ");
                   cep = leitor.next();
                   try {
                       Endereco novoEndereco = consultaCep.buscaEndereco(cep);
                       System.out.println(novoEndereco);
                       GeradorDeArquivo gerador = new GeradorDeArquivo();
                       gerador.salvaJson(novoEndereco);
                   } catch (RuntimeException | IOException e) {
                       System.out.println(e.getMessage());
                       System.out.println("Finalizando a aplicação");
                       isRunning = false;
                   }
                   break;
                case 2:
                    System.out.println("Finalizando a aplicação...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }


    }
}
