package br.com.agencia.main;

import br.com.agencia.model.Cliente;

public class SessaoUsuario {
	private static Cliente clienteLogado;

    public static void iniciarSessao(Cliente cliente) {
        clienteLogado = cliente;
    }

    public static void encerrarSessao() {
        clienteLogado = null;
    }

    public static Cliente getClienteLogado() {
        return clienteLogado;
    }

    public static boolean estaLogado() {
        return clienteLogado != null;
    }
}
