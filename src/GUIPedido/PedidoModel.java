package GUIPedido;

import GUICliente.ClienteModel;

public class    PedidoModel {
    private String item;
    int quantidade;
    private float valorTotal;
    private ClienteModel cliente;

    public PedidoModel(String item, float valorTotal, ClienteModel cliente, int quantidade) {
        this.item = item;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.quantidade = quantidade;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "PedidoModel{" +
                "item='" + item + '\'' +
                ", valorTotal=" + valorTotal +
                ", cliente=" + cliente +
                ", quantidade=" + quantidade +
                '}';
    }
}
