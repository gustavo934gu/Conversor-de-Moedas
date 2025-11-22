import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FiltrarMoeda valormoeda = new FiltrarMoeda();
        ConversorMoedas conversor = new ConversorMoedas();
        String moeda = "";
        int escolha = 0;
        double valorConvertido = 0;
        double dinheiroDisponivel = 0;
        while(escolha != 7) {
            System.out.println("""
                    **************************************************************************************************
                    seja Bem-vindo ao Conversor de Moeda:
                    
                    1) Dólar => Peso argentino
                    2) Peso argentino => Dólar
                    3) Dólar => Real brasileiro
                    4) Real brasileiro => Dólar
                    5) Dólar => Peso colombiano
                    6) Peso colombiano => Dólar
                    7) Sair
       
                    **************************************************************************************************
                    """
            );
            System.out.println("Escolha uma opção valida:");
            escolha = sc.nextInt();
            if (escolha == 7){
                System.out.println("Volte sempre!");
                break;
            }
            System.out.println("Digite o valor que deseja converter");
            dinheiroDisponivel = sc.nextDouble();
            switch (escolha){
                case 1:
                    valorConvertido = conversor.conversorMoeda(valormoeda.buscaMoeda("ARS"),dinheiroDisponivel);
                    moeda = "Peso argentino";
                    break;
                case 2:
                    valorConvertido = conversor.conversorParaDolar(valormoeda.buscaMoeda("ARS"),dinheiroDisponivel);
                    moeda = "Dólar";
                    break;
                case 3:
                    valorConvertido = conversor.conversorMoeda(valormoeda.buscaMoeda("BRL"),dinheiroDisponivel);
                    moeda = "Real brasileiro";
                    break;
                case 4:
                    valorConvertido = conversor.conversorParaDolar(valormoeda.buscaMoeda("BRL"),dinheiroDisponivel);
                    moeda = "Dólar";
                    break;
                case 5:
                    valorConvertido = conversor.conversorMoeda(valormoeda.buscaMoeda("COP"),dinheiroDisponivel);
                    moeda = "Peso colombiano";
                    break;
                case 6:
                    valorConvertido = conversor.conversorParaDolar(valormoeda.buscaMoeda("COP"),dinheiroDisponivel);
                    moeda = "Dólar";
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }
            System.out.println("O valor de "+dinheiroDisponivel+" convertido para "+moeda+" é igual a "+ valorConvertido);
        }
    }
}
