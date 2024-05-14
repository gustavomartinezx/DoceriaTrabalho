import java.util.Scanner;

public class Pedido {
    String item;
    float valorTotal;
    String status;
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
        switch (opcao) {
            case 1:
                this.item = "brigadeiro";
                break;
            case 2:
                this.item = "beijinho";
                break;
            case 3:
                this.item = "doce de uva";
                break;
            case 4:
                this.item = "brigadeiro de leite ninho";
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        System.out.println("Digite o valor total do pedido:");
        this.valorTotal = entrada.nextFloat();
        entrada.nextLine();

        System.out.println("Digite o status do pedido:");
        this.status = entrada.nextLine();

        this.cliente = cliente;
        cliente.adicionarPedido(this);
    }
}
