import GUICliente.ClienteView;
import GUIPedido.PedidoCtrl;
import GUIPedido.PedidoView;
import GUIGerente.GerenteView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //GerenteView gerenteView = new GerenteView();
                //gerenteView.setVisible(true);
                //ClienteView clienteView = new ClienteView();
                //clienteView.setVisible(true);
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
