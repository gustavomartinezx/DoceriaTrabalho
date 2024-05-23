package GUIGerente;

import GUIFuncionario.FuncionarioModel;

public class GerenteModel {
    private FuncionarioModel funcionario;
    private final float valor;

    public GerenteModel(FuncionarioModel funcionario, float valor) {
        this.funcionario = funcionario;
        this.valor = valor;
    }

    public double getValor() { return valor; }

    @Override
    public String toString() {
        return "GerenteModel{" +
                "funcionario='" + funcionario + '\'' +
                ", valor='" + valor + '\'' + '}';
    }
}
