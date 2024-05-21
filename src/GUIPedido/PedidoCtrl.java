package GUIPedido;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PedidoCtrl {
    private static ArrayList<PedidoModel> pedidosLista = new ArrayList<PedidoModel>();

    public static void adicionarPedido(PedidoModel pedidos) {
        pedidosLista.add(pedidos);
    }

    public static ArrayList<PedidoModel> getPedidos() {
        return pedidosLista;
    }
}