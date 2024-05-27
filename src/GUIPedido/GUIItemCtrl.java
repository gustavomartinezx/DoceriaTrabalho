package GUIPedido;

import java.util.ArrayList;

public class GUIItemCtrl {
    private static ArrayList<PedidoModel> itensLista = new ArrayList<>();

    public static void adicionarItem(PedidoModel item) {
        itensLista.add(item);
    }

    public static ArrayList<PedidoModel> getItens() {
        return itensLista;
    }
}
