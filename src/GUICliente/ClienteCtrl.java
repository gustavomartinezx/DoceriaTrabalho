package GUICliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClienteCtrl {
    private static ArrayList<ClienteModel> clientela = new ArrayList<>();

    public static void adicionarCliente(ClienteModel cliente) {
        clientela.add(cliente);
    }

    public static ArrayList<ClienteModel> getClientes() {
        return clientela;
    }


    static {
        adicionarCliente(new ClienteModel("João", "12345678901", "Rua A, 123"));
        adicionarCliente(new ClienteModel("Maria", "98765432109", "Rua B, 456"));
        adicionarCliente(new ClienteModel("Pedro", "45612378902", "Rua C, 789"));
    }
}