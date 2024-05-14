import java.util.Scanner;

public class Cliente {
    String Nome;
    String CPF;
    String Endereco;
    Pedido pedido;

    public void setInformacoes() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do cliente:");
        this.Nome = entrada.nextLine();
        System.out.println("Digite o CPF do cliente:");
        this.CPF = entrada.nextLine();
        System.out.println("Digite o endereço do cliente:");
        this.Endereco = entrada.nextLine();
    }

    public void adicionarPedido(Pedido novoPedido) {
        this.pedido = novoPedido;
    }
}
