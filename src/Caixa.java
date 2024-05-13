public class Caixa extends Funcionario{
    int PedidosAtendidos;


    public int getPedidosAtendidos() {
        return PedidosAtendidos;
    }

    public void setPedidosAtendidos(int pedidosAtendidos) {
        PedidosAtendidos = pedidosAtendidos;
    }

    public void setInformacoes() {
        super.setInformacoes();

        System.out.println("Quantidade de pedidos atendidos:");
        while (!entrada.hasNextInt()) {
            System.out.println("Tipo errado! Insira um valor inteiro!");
            entrada.next();
        }
        this.setPedidosAtendidos(entrada.nextInt());
    }
}
