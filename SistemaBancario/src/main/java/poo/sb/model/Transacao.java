package poo.sb.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import poo.sb.utils.Utils;

public class Transacao {
    Date data;
    String tipo;
    Double valor;
    Integer conta;

    public Date getData() {
        return data;
    }
    
     public String getDataFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");        
        return sdf.format(data);        
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }
    
    public String getValorFormatado() {
        return Utils.numToBrl(valor);
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    
}
