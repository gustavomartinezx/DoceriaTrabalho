package GUIPedido;

import GUICliente.ClienteModel;

import java.util.List;

public class PedidoModel {
    private String item;
    int quantidade;
    private List<PedidoModel> listaDocinhos;
    private float valorTotal;
    private ClienteModel cliente;

    public PedidoModel(String item, float valorTotal, ClienteModel cliente, int quantidade) {
        this.item = item;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.quantidade = quantidade;
    }

    public void addListaDocinhos(List<PedidoModel> listaDocinhos){
        this.listaDocinhos = listaDocinhos;
    }

    public String getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Item: " + item + ", Valor Total: " + valorTotal;
    }
}
