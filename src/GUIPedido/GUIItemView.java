package GUIPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIItemView extends JFrame {
    JComboBox<String> arrayDocinhos; // Combobox para seleção de docinhos
    JLabel lbDocinhos, lblValor, lblUnidades; // Labels
    JTextField txtUnidades, txtValor; // Campos de texto
    JPanel pnlRodape, pnlForm; // Paineis
    JButton btnCadastrar, btnLimpar; // Botões

    // Docinhos
    String[] docinhos = {"Brigadeiro", "Bem casado", "Brigadeiro de Leite Ninho", "Beijinho"};

    // Preços correspondentes aos docinhos
    float[] precos = {1.5F, 2.0F, 1.8F, 1.6F};

    private PedidoView pedidoView;

    public GUIItemView(PedidoView pedidoView) {
        this.pedidoView = pedidoView;
        inicializar();
    }

    private void inicializar() {
        this.setTitle("Docinhos");
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        this.getContentPane().add(this.getForm(), BorderLayout.CENTER);
        this.getContentPane().add(this.getRodape(), BorderLayout.PAGE_END);
        this.setResizable(false);
        this.setSize(400, 400);
        pack();
        this.eventos();
    }

    private JPanel getForm() {
        if (this.pnlForm == null) {
            this.pnlForm = new JPanel(new GridLayout(3, 2));
        }

        this.lbDocinhos = new JLabel("Docinhos:");
        this.lblUnidades = new JLabel("Unidades:");
        this.lblValor = new JLabel("Valor por unidade:");

        this.txtUnidades = new JTextField();
        this.txtValor = new JTextField();
        this.txtValor.setEditable(false); // Campo de valor não editável

        this.arrayDocinhos = new JComboBox<>(docinhos);
        this.arrayDocinhos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceDocinho = arrayDocinhos.getSelectedIndex();
                txtValor.setText(String.valueOf(precos[indiceDocinho]));
            }
        });

        // Defina o valor inicial com base no primeiro item
        if (docinhos.length > 0) {
            txtValor.setText(String.valueOf(precos[0]));
        }

        this.pnlForm.add(lbDocinhos);
        this.pnlForm.add(arrayDocinhos);
        this.pnlForm.add(lblUnidades);
        this.pnlForm.add(txtUnidades);
        this.pnlForm.add(lblValor);
        this.pnlForm.add(txtValor);

        return this.pnlForm;
    }

    private JPanel getRodape() {
        if (this.pnlRodape == null) {
            this.pnlRodape = new JPanel();
        }

        // Criação dos botões
        this.btnLimpar = new JButton("Limpar");
        this.btnCadastrar = new JButton("Cadastrar");

        // Adição dos botões no rodapé
        this.pnlRodape.add(btnLimpar);
        this.pnlRodape.add(btnCadastrar);

        return this.pnlRodape;
    }

    private void eventos() {
        this.btnLimpar.addActionListener(this::btnLimpar);
        this.btnCadastrar.addActionListener(this::btnCadastrar);
    }

    private void btnLimpar(ActionEvent evento) {
        this.txtUnidades.setText("");
    }

    private void btnCadastrar(ActionEvent evento) {
        int unidades = Integer.parseInt(txtUnidades.getText());
        int indiceDocinho = arrayDocinhos.getSelectedIndex();
        float precoUnitario = precos[indiceDocinho];
        float precoTotal = unidades * precoUnitario;

        String docinhoSelecionado = (String) this.arrayDocinhos.getSelectedItem();

        PedidoModel pedidoModel = new PedidoModel(docinhoSelecionado, precoTotal, null, unidades);
        pedidoView.adicionarDocinho(pedidoModel); // Adiciona o docinho ao PedidoView
        String mensagem = String.format("Docinho adicionado: "+unidades+" unidades do doce "+ docinhoSelecionado +". O valaor por unidade é de R$"+precoUnitario+".\nValor total: R$"+precoTotal);
        JOptionPane.showMessageDialog(this, mensagem); //
        this.dispose(); // Fecha a janela após adicionar o docinho
    }
}
