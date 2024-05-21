package GUIPedido;

import GUICliente.ClienteModel;
import GUICliente.ClienteCtrl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PedidoView extends JFrame {
    String docinho;
    String Cliente;
    float preco;
    JComboBox<String> arrayDocinhos, arrayClientes; //A lista de itens selecionados
    JLabel lblDocinhos, lblUnidades, lblCliente; // campo do nome
    JTextField txtUnidades; // campo de texto
    JPanel pnlRodape, pnlForm; // paineis
    JButton btnCadastrar, btnLimpar;// botões

    String[] docinhos = {"Brigadeiro", "Bem casado", "Brigadeiro de Leite Ninho", "Beijinho"};

    public PedidoView() {
        inicializar();
    }

    private void inicializar() {
        this.setTitle("Pedido");
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(this.getForm(), BorderLayout.CENTER);
        this.getContentPane().add(this.getRodape(), BorderLayout.PAGE_END);
        pack();
        this.eventos();
    }


    private JPanel getForm(){
        if(this.pnlForm == null){
            this.pnlForm = new JPanel(new GridLayout(3, 2));

        }

        this.lblUnidades = new JLabel("Unidades:");
        this.lblDocinhos = new JLabel("Docinhos:");
        this.lblCliente = new JLabel("Cliente:");


        this.txtUnidades = new JTextField();
        arrayDocinhos = new JComboBox<>(docinhos);
        this.arrayClientes = new JComboBox<>();

        ArrayList<ClienteModel> clientes = ClienteCtrl.getClientes();
        for(ClienteModel cliente : clientes){
            this.arrayClientes.addItem(cliente.getNome());
        }


        this.pnlForm.add(lblDocinhos);
        this.pnlForm.add(arrayDocinhos);
        this.pnlForm.add(lblUnidades);
        this.pnlForm.add(txtUnidades);
        this.pnlForm.add(lblCliente);
        this.pnlForm.add(arrayClientes);

        return this.pnlForm;
    }





    //rodapé


    //rodapé da página
    private JPanel getRodape(){
        if (this.pnlRodape == null){
            this.pnlRodape = new JPanel();
        }

        // criação dos botões
        this.btnLimpar = new JButton("Limpar");
        this.btnCadastrar = new JButton("Cadastrar");


        // atalho dos botões
        this.btnLimpar.setMnemonic(KeyEvent.VK_L);
        this.btnCadastrar.setMnemonic(KeyEvent.VK_ENTER);


        //adição dos botões no rodapé
        this.pnlRodape.add(btnLimpar);
        this.pnlRodape.add(btnCadastrar);


        this.pnlRodape.setBackground(Color.blue);
        return this.pnlRodape;
    }



    // métodos para eventos dos botões
    private void eventos(){
        this.btnLimpar.addActionListener(this::btnLimpar);
        this.btnCadastrar.addActionListener(this::btnCadastrar);
    }


    private void btnLimpar(ActionEvent evento){
        this.txtUnidades.setText("");
    }

    private void btnCadastrar(ActionEvent evento){

        String nomeCliente = (String) this.arrayClientes.getSelectedItem();
        ClienteModel clienteSelecionado = null;

        for(ClienteModel cliente : ClienteCtrl.getClientes()){
            if(cliente.getNome().equals(nomeCliente)){
                clienteSelecionado = cliente;
                break;
            }
        }
        preco = 2 * Integer.parseInt(txtUnidades.getText());

        PedidoModel pedido = new PedidoModel((String) this.arrayDocinhos.getSelectedItem(),
                preco,
                clienteSelecionado,
                Integer.parseInt(txtUnidades.getText()));

        PedidoCtrl.adicionarPedido(pedido);
        System.out.println(pedido);
        JOptionPane.showMessageDialog(this, "Pedido registrado. O total deu: "+ preco);
    }

}