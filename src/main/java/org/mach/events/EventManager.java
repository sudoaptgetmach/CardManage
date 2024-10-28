package org.mach.events;

import org.mach.collections.ListManager;
import org.mach.superclass.Cartao;
import org.mach.superclass.Compra;

public class EventManager {

    public void compra(Compra compra, Cartao cartao, ListManager listManager) {
        double limite = cartao.getLimite();
        double valorCompra = compra.getValor();

        if (limite >= valorCompra) {
            listManager.compras.add(compra);
            cartao.setLimite(limite - valorCompra);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}