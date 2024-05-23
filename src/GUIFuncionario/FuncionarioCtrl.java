package GUIFuncionario;

import GUIGerente.GerenteModel;

import java.util.ArrayList;

public class FuncionarioCtrl {
    private static ArrayList<FuncionarioModel> funcionarios = new ArrayList<>();

    public static void adicionarFuncionario(FuncionarioModel funcionario) {
        funcionarios.add(funcionario);
    }

    public static ArrayList<FuncionarioModel> getFuncionarios() {
        return funcionarios;
    }


    static {
        adicionarFuncionario(new FuncionarioModel("Ewellyn", "12345678", "Doceiro",6543));
        adicionarFuncionario(new FuncionarioModel("Gustavo", "98765432", "Entregador", 5432));
        adicionarFuncionario(new FuncionarioModel("Maria Eduarda", "456123789", "Caixa",7245));
    }
}