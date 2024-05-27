package GUIPedido;

import GUICliente.ClienteModel;
import GUICliente.ClienteCtrl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class PedidoView extends JFrame {
    JComboBox<String> arrayClientes; // Lista de clientes
    JLabel lblDocinhos, lblCliente; // Labels
    JPanel pnlRodape, pnlForm; // Paineis
    JButton btnCadastrar, btnAddDocinho; // Botões

    List<PedidoModel> listaDocinhos = new ArrayList<>(); // Lista de docinhos

    public PedidoView() {
        inicializar();
    }

    private void inicializar() {
        this.setTitle("Pedido");
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(this.getForm(), BorderLayout.CENTER);
        this.getContentPane().add(this.getRodape(), BorderLayout.PAGE_END);
        this.setResizable(false);
        this.setSize(400, 400);
        pack();
        this.eventos();
    }

    private JPanel getForm() {
        if (this.pnlForm == null) {
            this.pnlForm = new JPanel(new GridLayout(2, 2)); // Layout ajustado
        }

        this.lblDocinhos = new JLabel("Docinhos:");
        this.lblCliente = new JLabel("Cliente:");

        this.arrayClientes = new JComboBox<>();

        ArrayList<ClienteModel> clientes = ClienteCtrl.getClientes();
        for (ClienteModel cliente : clientes) {
            this.arrayClientes.addItem(cliente.getNome());
        }


        // Adiciona o botão "+"
        this.btnAddDocinho = new JButton("+");
        this.btnAddDocinho.addActionListener(e -> abrirItemView());

        this.pnlForm.add(lblDocinhos);
        this.pnlForm.add(btnAddDocinho); // Adiciona o botão "+" ao formulário
        this.pnlForm.add(lblCliente);
        this.pnlForm.add(arrayClientes);

        return this.pnlForm;
    }

    // Método para abrir o painel GUIItemView
    private void abrirItemView() {
        GUIItemView itemView = new GUIItemView(PedidoView.this);
        itemView.setVisible(true);
    }

    // Rodapé da página
    private JPanel getRodape() {
        if (this.pnlRodape == null) {
            this.pnlRodape = new JPanel();
        }

        // Criação dos botões
        this.btnCadastrar = new JButton("Cadastrar");

        this.btnCadastrar.setMnemonic(KeyEvent.VK_ENTER);

        // Adição dos botões no rodapé
        this.pnlRodape.add(btnCadastrar);

        this.pnlRodape.setBackground(Color.blue);
        return this.pnlRodape;
    }

    // Métodos para eventos dos botões
    private void eventos() {
        this.btnCadastrar.addActionListener(this::btnCadastrar);
    }


    private void btnCadastrar(ActionEvent evento) {
        String nomeCliente = (String) this.arrayClientes.getSelectedItem();
        ClienteModel clienteSelecionado = null;

        for (ClienteModel cliente : ClienteCtrl.getClientes()) {
            if (cliente.getNome().equals(nomeCliente)) {
                clienteSelecionado = cliente;
                break;
            }
        }

        // Calcula o preço total dos docinhos adicionados
        float precoTotal = 0;
        for (PedidoModel pedido : listaDocinhos) {
            precoTotal += pedido.getValorTotal();
        }

        PedidoModel pedido = new PedidoModel("Pedido", precoTotal, clienteSelecionado, 1); // Quantidade não utilizada
        System.out.println(pedido);
        System.out.println(listaDocinhos);
        pedido.addListaDocinhos(listaDocinhos);

        JOptionPane.showMessageDialog(this, "Pedido registrado. O total deu: " + precoTotal);
    }

    // Método para adicionar docinho à lista
    public void adicionarDocinho(PedidoModel docinho) {
        listaDocinhos.add(docinho);
    }
}
