package poo.sb.model;

import java.util.ArrayList;
import java.util.List;

public class Conta implements AcoesConta {
    private Integer id;   
    private Integer numero;
    private String senha;
    private Cliente titular;
    private Double saldo;    
    private List<Transacao> transacoes =  new ArrayList<Transacao>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    @Override
    public Boolean sacar(Double valor) {
        if (this.saldo < valor) return false;
        this.saldo -= valor;
        return true;
    }

    @Override
    public Boolean depositar(Double valor) {
        this.saldo += valor;
        return true;
    }

    @Override
    public Boolean transferir(Double valor, Conta destino) {                
        if (this.saldo < valor) return false;
        this.saldo -= valor;
        destino.setSaldo(destino.getSaldo() + valor);
        return true;
    }

    @Override
    public Double getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
        
    public void addTransacao(Transacao item) {
        transacoes.add(item);
    }
        
    @Override
    public List<Transacao> getExtrato() {
        return this.transacoes;
    }        
}
