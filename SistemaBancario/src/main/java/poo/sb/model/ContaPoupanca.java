/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.sb.model;

/**
 *
 * @author Douglas
 */
public class ContaPoupanca extends Conta {
    public void atualizarRendimentos() {
        this.setSaldo(this.getSaldo() * 0.06);
    }
}
