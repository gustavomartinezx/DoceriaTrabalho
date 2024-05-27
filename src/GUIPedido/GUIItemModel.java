package GUIPedido;

import javax.swing.*;

public class GUIItemModel {
    int quantidade;
    String item;
    JComboBox<String> arrayDocinhos;
    JLabel lbDocinhos, lblValor, lblUnidades;
    float valorTotal;

    public GUIItemModel(int quantidade, String item, float valorTotal) {
        this.quantidade = quantidade;
        this.item = item;
        this.valorTotal = valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
