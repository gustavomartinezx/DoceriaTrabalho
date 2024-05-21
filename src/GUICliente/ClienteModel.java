package GUICliente;

public class ClienteModel {
    private String nome;
    private String cpf;
    private String endereco;

    public ClienteModel(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
