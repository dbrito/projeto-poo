package poo.sb.DAO;

import poo.sb.utils.ConnectionFactory;
import poo.sb.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import poo.sb.model.ClientePessoaFisica;
import poo.sb.model.ClientePessoaJuridica;


public class ClienteDAO {
    
    public static void inserir (Cliente cliente) throws SQLException{
        Connection con = ConnectionFactory.getConnetion();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO cliente (nome, cpf_cnpj, telefone, cep, endereco, cidade, estado, tipo) VALUES(?,?,?,?,?,?,?,?)");
        stmt.setString(1, cliente.getNome());
        if (cliente instanceof ClientePessoaJuridica) {
            stmt.setString(2, ((ClientePessoaJuridica) cliente).getCnpj());
            stmt.setString(8, "pessoa_juridica");
        } else {
            stmt.setString(2, ((ClientePessoaFisica) cliente).getCpf());
            stmt.setString(8, "pessoa_fisica");
        }
        stmt.setString(3, cliente.getTelefone());
        stmt.setString(4, cliente.getCep());
        stmt.setString(5, cliente.getEndereco());
        stmt.setString(6, cliente.getCidade());
        stmt.setString(7, cliente.getCidade());
        stmt.execute();        
        ConnectionFactory.closeConnection(con, stmt);
    }    

    public static Cliente obter(String cpfCnpj) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            con = ConnectionFactory.getConnetion();
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE (cpf_cnpj=?)");
            stmt.setString(1, cpfCnpj);
            result = stmt.executeQuery();

            if (result.next()) {
                Cliente cliente;
                String tipo = result.getString("tipo");
                if (tipo.equals("pessoa_fisica")) {
                    cliente = new ClientePessoaFisica();
                } else {
                    cliente = new ClientePessoaJuridica();
                }
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("nome"));

                String cpf_cnpj = result.getString("cpf_cnpj");
                if (cliente instanceof ClientePessoaJuridica) {
                    ((ClientePessoaJuridica) cliente).setCnpj(cpf_cnpj);
                } else {
                    ((ClientePessoaFisica) cliente).setCpf(cpf_cnpj);
                }

                cliente.setTelefone(result.getString("telefone"));
                cliente.setTelefone(result.getString("cep"));
                cliente.setTelefone(result.getString("endereco"));
                cliente.setTelefone(result.getString("cidade"));
                cliente.setTelefone(result.getString("estado"));
                return cliente;
            }
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;
    }
    
    public static Cliente obter(Integer cliente_id) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            con = ConnectionFactory.getConnetion();
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE (id=?)");
            stmt.setInt(1, cliente_id);
            result = stmt.executeQuery();

            if (result.next()) {
                Cliente cliente;
                String tipo = result.getString("tipo");
                if (tipo.equals("pessoa_fisica")) {
                    cliente = new ClientePessoaFisica();
                } else {
                    cliente = new ClientePessoaJuridica();
                }
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("nome"));

                String cpf_cnpj = result.getString("cpf_cnpj");
                if (cliente instanceof ClientePessoaJuridica) {
                    ((ClientePessoaJuridica) cliente).setCnpj(cpf_cnpj);
                } else {
                    ((ClientePessoaFisica) cliente).setCpf(cpf_cnpj);
                }

                cliente.setTelefone(result.getString("telefone"));
                cliente.setTelefone(result.getString("cep"));
                cliente.setTelefone(result.getString("endereco"));
                cliente.setTelefone(result.getString("cidade"));
                cliente.setTelefone(result.getString("estado"));
                return cliente;
            }
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;
    }
}


