import java.util.Scanner;

public class Pedido {
    String item;
    float valorTotal;
    String status = "Pendente";
    Cliente cliente;


    public void setInformacoes(Cliente cliente) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("""
                    Você quer qual doce?
                   [1]brigadeiro
                   [2]beijinho
                   [3]doce de uva
                   [4]brigadeiro de leito ninho
                    """);
        int opcao = entrada.nextInt();

        System.out.println("Quantas unidades você irá querer?");
        float quantidadeDoces = entrada.nextFloat();

        switch (opcao) {
            case 1:
                this.item = "brigadeiro";
                valorTotal = (float) (1.0 * quantidadeDoces);
                break;
            case 2:
                this.item = "beijinho";
                valorTotal = (float) (1.5 * quantidadeDoces);
                break;
            case 3:
                this.item = "doce de uva";
                valorTotal = (float) (3.0 * quantidadeDoces);
                break;
            case 4:
                this.item = "brigadeiro de leite ninho";
                valorTotal = (float) (2.0 * quantidadeDoces);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        System.out.println("Digite quantas unidades você irá querer:");
        float unidadeDoce = entrada.nextFloat();

        this.cliente = cliente;
        cliente.adicionarPedido(this);
    }
}
