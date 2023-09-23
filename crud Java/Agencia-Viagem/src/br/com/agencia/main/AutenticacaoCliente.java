package br.com.agencia.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.agencia.model.Cliente;

public class AutenticacaoCliente {

	public boolean autenticar(String email, String senha) {
        try {
            // Conectar ao banco de dados
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia_viagem", "root", "Uc6j0(ym5769");

            // Criar a consulta SQL
            String query = "SELECT senha FROM cliente WHERE email = ?";

            // Preparar a declaração
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);

            // Executar a consulta
            ResultSet result = stmt.executeQuery();

            // Verificar se o email existe
            if (result.next()) {
                // Comparar a senha
                String senhaNoBanco = result.getString("senha");
                if (senha.equals(senhaNoBanco)) {
                	Cliente cliente = new Cliente();
                	cliente.setEmail(email);
                	SessaoUsuario.iniciarSessao(cliente);
                    // Senha correta, permitir acesso
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Se chegou aqui, algo deu errado (email não existe ou senha incorreta)
        return false;
    }
}