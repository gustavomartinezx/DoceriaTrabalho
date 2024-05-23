package GUIGerente;

import GUIFuncionario.FuncionarioCtrl;
import GUIFuncionario.FuncionarioModel;
import GUIGerente.GerenteModel;
import GUIGerente.GerenteCtrl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GerenteView extends JFrame {
    JTextField txtValor;
    JComboBox<String> arrayFuncionarios;
    JLabel lblFuncionario, lblValor;
    JButton btnCadastrar, btnLimpar, btnMostrarDetalhes;
    JPanel pnlRodape, pnlForm;


    //construtor
    public GerenteView() {
        incializar();
    }

    // metodo de inicializar layout
    protected void incializar() {
        this.setTitle("Gerente");
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(this.getRodape(), BorderLayout.PAGE_END);
        this.getContentPane().add(this.getForm(), BorderLayout.CENTER);
        pack();
        this.eventos();
    }


    // painel do formulário

    private JPanel getForm() {
        if (this.pnlForm == null) {
            this.pnlForm = new JPanel(new GridLayout(3, 2));
        }

        this.lblFuncionario = new JLabel("Funcionário");
        this.lblValor = new JLabel("Valor");

        this.arrayFuncionarios = new JComboBox<>();
        this.txtValor = new JTextField();

        ArrayList<FuncionarioModel> funcionarios = FuncionarioCtrl.getFuncionarios();
        for (FuncionarioModel funcionario : funcionarios) {
            this.arrayFuncionarios.addItem(funcionario.getNome());
        }


        this.pnlForm.add(lblFuncionario);
        this.pnlForm.add(arrayFuncionarios);
        this.pnlForm.add(lblValor);
        this.pnlForm.add(txtValor);

        return this.pnlForm;
    }

    //rodapé da página
    private JPanel getRodape() {
        if (this.pnlRodape == null) {
            this.pnlRodape = new JPanel();
        }

        // criação dos botões
        this.btnLimpar = new JButton("Limpar");
        this.btnCadastrar = new JButton("Cadastrar");
        this.btnMostrarDetalhes = new JButton("Mostrar Detalhes");


        // atalho dos botões
        this.btnLimpar.setMnemonic(KeyEvent.VK_L);
        this.btnCadastrar.setMnemonic(KeyEvent.VK_ENTER);


        //adição dos botões no rodapé
        this.pnlRodape.add(btnLimpar);
        this.pnlRodape.add(btnCadastrar);
        this.pnlRodape.add(btnMostrarDetalhes);


        this.pnlRodape.setBackground(Color.green);
        return this.pnlRodape;
    }

    // métodos para eventos dos botões
    private void eventos() {
        this.btnLimpar.addActionListener(this::btnLimparCLick);
        this.btnMostrarDetalhes.addActionListener(this::btnMostrarDetalhesClick);
        this.btnCadastrar.addActionListener(this::setBtnCadastar);
    }
    private void btnLimparCLick(ActionEvent evento) {
        this.txtValor.setText("");
    }

    private void btnMostrarDetalhesClick(ActionEvent evento) {
        String nomeFuncionario = (String) this.arrayFuncionarios.getSelectedItem();
        FuncionarioModel funcionarioSelecionado = null;

        for (FuncionarioModel funcionario : FuncionarioCtrl.getFuncionarios()) {
            if (funcionario.getNome().equals(nomeFuncionario)) {
                funcionarioSelecionado = funcionario;
                break;
            }
        }
        if (funcionarioSelecionado != null) {
            String mensagem = "Nome: " + funcionarioSelecionado.getNome() +
                    "\nCPF: " + funcionarioSelecionado.getCpf() +
                    "\nCargo: " + funcionarioSelecionado.getCargo() +
                    "\nSalário: " + funcionarioSelecionado.getSalario();
            JOptionPane.showMessageDialog(this, mensagem, "Detalhes do Funcionário", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Funcionário não encontrado!");
        }
    }

    private void setBtnCadastar(ActionEvent evento) {

        String nomeFuncionario = (String) this.arrayFuncionarios.getSelectedItem();
        FuncionarioModel funcionarioSelecionado = null;

        for (FuncionarioModel funcionario : FuncionarioCtrl.getFuncionarios()) {
            if (funcionario.getNome().equals(nomeFuncionario)) {
                funcionarioSelecionado = funcionario;
                break;
            }
        }
        GerenteModel gerente = new GerenteModel(
                funcionarioSelecionado,
                Float.parseFloat(txtValor.getText())
        );
        System.out.println(gerente);
        JOptionPane.showMessageDialog(this, "Funcionário registrado com sucesso!");
    }
}