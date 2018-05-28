package poo.sb.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import poo.sb.model.Conta;
import poo.sb.model.ContaCorrente;
import poo.sb.model.ContaPoupanca;
import poo.sb.model.ClientePessoaJuridica;
import poo.sb.model.Transacao;
import poo.sb.utils.ConnectionFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Douglas
 */
public class ContaDAO {
    public static void inserir (Conta conta) throws SQLException{
        Connection con = ConnectionFactory.getConnetion();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO conta (id_titular, numero_conta, senha, saldo, tipo) VALUES(?,?,?,?,?)");
        stmt.setInt(1, conta.getTitular().getId());
        stmt.setInt(2, conta.getNumero());
        stmt.setString(3, conta.getSenha());
        stmt.setDouble(4, conta.getSaldo());
        if (conta instanceof ContaCorrente) {
            stmt.setString(5, "corrente");
        } else {
            stmt.setString(5, "poupanca");
        }
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }

    public static Conta obter(Integer numero_conta) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            con = ConnectionFactory.getConnetion();
            stmt = con.prepareStatement("SELECT * FROM conta WHERE (numero_conta=?) AND ativo=1");
            stmt.setInt(1, numero_conta);
            result = stmt.executeQuery();

            if (result.next()) {
                Conta conta;
                String tipo = result.getString("tipo");
                if (tipo.equals("corrente")) {
                    conta = new ContaCorrente();
                } else {
                    conta = new ContaPoupanca();
                }
                conta.setId(result.getInt("id"));
                conta.setTitular(ClienteDAO.obter(result.getInt("id_titular")));
                conta.setNumero(result.getInt("numero_conta"));
                conta.setSenha(result.getString("senha"));
                conta.setSaldo(result.getDouble("saldo"));
                conta.setTransacoes(pegaTransacoes(conta.getId()));
                return conta;
            }
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;
    }

    public static Conta obter(Integer param, String campo) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            con = ConnectionFactory.getConnetion();
            stmt = con.prepareStatement("SELECT * FROM conta WHERE (" + campo + "=?) AND ativo=1");
            stmt.setInt(1, param);
            result = stmt.executeQuery();

            if (result.next()) {
                Conta conta;
                String tipo = result.getString("tipo");
                if (tipo.equals("corrente")) {
                    conta = new ContaCorrente();
                } else {
                    conta = new ContaPoupanca();
                }
                conta.setId(result.getInt("id"));
                conta.setTitular(ClienteDAO.obter(result.getInt("id_titular")));
                conta.setNumero(result.getInt("numero_conta"));
                conta.setSenha(result.getString("senha"));
                conta.setSaldo(result.getDouble("saldo"));
                conta.setTransacoes(pegaTransacoes(conta.getId()));
                return conta;
            }
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;
    }

    public static Conta validarConta(Integer numero_conta, String senha) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            con = ConnectionFactory.getConnetion();
            stmt = con.prepareStatement("SELECT * FROM conta WHERE (numero_conta=?) AND (senha=?) AND ativo=1");
            stmt.setInt(1, numero_conta);
            stmt.setString(2, senha);
            result = stmt.executeQuery();

            if (result.next()) {
                Conta conta;
                String tipo = result.getString("tipo");
                if (tipo.equals("corrente")) {
                    conta = new ContaCorrente();
                } else {
                    conta = new ContaPoupanca();
                }
                conta.setId(result.getInt("id"));
                conta.setNumero(result.getInt("numero_conta"));
                conta.setSenha(result.getString("senha"));
                conta.setSaldo(result.getDouble("saldo"));
                conta.setTransacoes(pegaTransacoes(conta.getId()));
                return conta;
            }
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;
    }

    public static void atualizarSaldo(Conta conta) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnetion();
        stmt = con.prepareStatement("UPDATE conta SET saldo=? WHERE (id=?)");
        stmt.setDouble(1, conta.getSaldo());
        stmt.setInt(2, conta.getId());
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }

    public static void fechar(Conta conta) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnetion();
        stmt = con.prepareStatement("UPDATE conta SET ativo=?, saldo=? WHERE (id=?)");
        stmt.setInt(1, 0);
        stmt.setInt(2, 0);
        stmt.setInt(3, conta.getId());
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }

    public static void criarTransacao (Transacao item, Conta conta) throws SQLException{
        Connection con = ConnectionFactory.getConnetion();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO transacao (id_conta, data, tipo, valor, conta_destino, saldo) VALUES(?,?,?,?,?,?)");
        stmt.setInt(1, conta.getId());
        java.sql.Date dt = new java.sql.Date ((new Date()).getTime());
        stmt.setDate(2, dt);
        stmt.setString(3, item.getTipo());
        stmt.setDouble(4, item.getValor());
        if (item.getConta() != null) {
            stmt.setInt(5, conta.getId());
        } else {
            stmt.setInt(5, 0);
        }
        stmt.setDouble(6, conta.getSaldo());
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }

    private static List<Transacao> pegaTransacoes(int idConta) throws SQLException, Exception {
        Connection con = ConnectionFactory.getConnetion();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Transacao> acoes = new ArrayList<>();

        stmt = con.prepareStatement("SELECT * FROM transacao where id_conta=?");
        stmt.setInt(1, idConta);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Transacao acao = new Transacao();
            acao.setTipo(rs.getString("tipo"));
            acao.setConta(rs.getInt("id_conta"));
            Date d = new Date(rs.getTimestamp("data").getTime());
            acao.setData(d);
            acao.setValor(rs.getDouble("valor"));
            acao.setConta(rs.getInt("conta_destino"));
            acao.setSaldo(rs.getDouble("saldo"));
            acoes.add(acao);
        }
        return acoes;
    }
}
