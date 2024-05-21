package GUICliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ClienteView extends JFrame {
    JTextField txtNome, txtCpf, txtEndereco;
    JLabel lblNome, lblCpf, lblEndereco;
    JButton btnCadastrar, btnLimpar;
    JPanel pnlRodape, pnlForm;


    //construtor
    public ClienteView() {
        this.incializar();

    }

    // metodo de inicializar layout
    protected void incializar() {
        this.setTitle("Cliente");
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(this.getRodape(), BorderLayout.PAGE_END);
        this.getContentPane().add(this.getForm(), BorderLayout.CENTER);
        pack();
        this.eventos();
    }


    // painel do formulário

    private JPanel getForm(){
        if (this.pnlForm == null){
            this.pnlForm = new JPanel(new GridLayout(3, 2));
        }

        this.lblNome = new JLabel("Nome");
        this.lblCpf = new JLabel("CPF");
        this.lblEndereco = new JLabel("Endereço ");

        this.txtNome = new JTextField();
        this.txtCpf = new JTextField();
        this.txtEndereco = new JTextField();


        this.pnlForm.add(lblNome);
        this.pnlForm.add(txtNome);
        this.pnlForm.add(lblCpf);
        this.pnlForm.add(txtCpf);
        this.pnlForm.add(lblEndereco);
        this.pnlForm.add(txtEndereco);
        return this.pnlForm;
    }

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


        this.pnlRodape.setBackground(Color.red);
        return this.pnlRodape;
    }

    // métodos para eventos dos botões
    private void eventos(){
        this.btnLimpar.addActionListener(this::btnLimparCLick);
        this.btnCadastrar.addActionListener(this::setBtnCadastar);
    }


    private void btnLimparCLick(ActionEvent evento){
        this.txtNome.setText("");
        this.txtCpf.setText("");
        this.txtEndereco.setText("");
    }

    private void setBtnCadastar(ActionEvent evento){
        ClienteModel cliente = new ClienteModel(
                this.txtNome.getText(),
                this.txtCpf.getText(),
                this.txtEndereco.getText()
        );
        GUICliente.ClienteCtrl.adicionarCliente(cliente);
        JOptionPane.showMessageDialog(this, "Cliente registrado com sucesso!");
        System.out.println(cliente);
    }
}


