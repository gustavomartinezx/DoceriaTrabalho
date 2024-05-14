import java.util.Scanner;

public class Gerente extends Funcionario {


    public void ContrataFuncionario() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Qual funcionário você decide contratar?");
        System.out.println("""
                [1] Caixa
                [2] Doceiro
                [3] Entregador
                """);
        int numeroFuncionario = entrada.nextInt();

        switch (numeroFuncionario){
            case 1:
                Caixa FuncionarioCaixa = new Caixa();

        }
    }
}
