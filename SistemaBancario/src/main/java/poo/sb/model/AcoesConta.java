package poo.sb.model;

import java.util.List;

public interface AcoesConta {
    
    public Boolean sacar(Double valor);
    public Boolean depositar(Double valor);
    public Boolean transferir(Double valor, Conta destino);
    public Double getSaldo();
    public List<Transacao> getExtrato();
    
}
