package org.mach;

import org.mach.collections.ListManager;
import org.mach.events.EventManager;
import org.mach.superclass.Cartao;
import org.mach.superclass.Compra;

import java.util.Scanner;

public class AppManager {

    public static void main(String[] args) {

        Cartao cartao = new Cartao();
        ListManager listManager = new ListManager();
        EventManager event = new EventManager();

        int input = 1;
        Scanner scanner = new Scanner(System.in);

        while (input == 1) {

            System.out.println("Digite o limite do cartão: ");
            cartao.setLimite(scanner.nextDouble());
            scanner.nextLine(); // Consume the newline character
            System.out.println("Digite a descrição da compra: ");
            Compra compra = new Compra();
            compra.setDescricao(scanner.nextLine());
            System.out.println("Digite o valor da compra:");
            compra.setValor(scanner.nextDouble());

            if (cartao.getLimite() >= compra.getValor()) {
                event.compra(compra, cartao, listManager);
            } else {
                System.out.println("Saldo insuficiente.");
            }

            System.out.println("Digite 0 para sair ou 1 para continuar.");
            input = scanner.nextInt();

            if (input == 0) {
                System.out.println("************************");
                System.out.println("COMPRAS REALIZADAS: \n");
                listManager.compras.forEach(System.out::println);
                System.out.println("\n************************");

                System.out.println("Saldo do cartão: " + String.format("%.2f", cartao.getLimite()));
                break;
            }
        }
        scanner.close();
    }
}