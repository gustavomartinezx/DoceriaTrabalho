import GUICliente.ClienteView;
import GUIPedido.PedidoCtrl;
import GUIPedido.PedidoView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PedidoView pedidoView = new PedidoView();
                pedidoView.setVisible(true);
            }
        });
    }

    protected static void inicializar() {
        JFrame jFrame = new JFrame("Começando com GUI");
        jFrame.setVisible(true);
    }
}