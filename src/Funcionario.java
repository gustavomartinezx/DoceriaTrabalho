import java.util.Locale;
import java.util.Scanner;

public class Funcionario {
    Scanner entrada = new Scanner(System.in);
    private String Nome;
    private int idade;
    private String sexo;
    private float salario;
    private String CPF;

    public void setInformacoes() {
        System.out.println("Qual é o nome do funcionário?");
        this.setNome(entrada.nextLine());

        System.out.println("Qual é a idade do funcionário?");
        while (!entrada.hasNextInt()) {
            System.out.println("Tipo errado! Insira um valor inteiro!");
            entrada.next();
        }
        this.setIdade(entrada.nextInt());

        System.out.println("Qual o salário do funcionário?");
        while (!entrada.hasNextFloat()) {
            System.out.println("Tipo errado! Insira um valor float!");
            entrada.next();
        }
        this.setSalario(entrada.nextFloat());

        System.out.println("Qual o sexo do funcionário? Insira M ou F");
        while(true){
            String sexo = entrada.next().toUpperCase();
            if(sexo.equals("M") || sexo.equals("F")){
                this.setSexo(sexo);
                break;
            } else{
                System.out.println("Informação inválida,");
            }
        }


        System.out.println("Digite o CPF do funcionário (apenas números):");
        String cpf = entrada.next();

        while (cpf.length() != 11) {
            System.out.println("CPF inválido! Digite novamente (tem que contar 11 digitos!):");
            cpf = entrada.next();
        }

        this.CPF = cpf;


    }

    public void mostrarInformacoes() {
        System.out.println("==== INFORMAÇÕES DO FUNCIONÁRIO===:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
        System.out.println("Salário: " + this.getSalario());
        System.out.println("Sexo: " + this.getSexo());
        System.out.println("Sexo: " + this.getCPF());

    }


    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
