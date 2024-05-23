package GUIFuncionario;

public class FuncionarioModel {
    private String nome;
    private String cpf;
    private String cargo;
    private float salario;


    public FuncionarioModel(String nome, String cpf, String cargo, float salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() { return cpf; }
    public String getCargo() { return cargo; }

    public float getSalario() { return salario; }

    @Override
    public String toString() {
        return "FuncionarioModel{" +
                "nome='" + nome + '\'' +
                ", cpf= '" + cpf + '\'' +
                ", cargo= '" + cargo + '\'' +
                ", salario='" + salario + '\'' + '}';
    }
}
