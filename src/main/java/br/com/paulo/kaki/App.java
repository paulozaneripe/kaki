package br.com.paulo.kaki;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		try(Scanner ler = new Scanner(System.in)) {
			System.out.print("Informe o tamanho do ovo: ");
			int tamanho = ler.nextInt();
			
			int menu = 0;
			Boolean estragado = false;
			
			while(!(menu == 1 || menu == 2)) {
				System.out.print("\nInforme se o ovo está estragado:\n\n1 - Sim\n2 - Não\n\nOpção: ");
				
				menu = ler.nextInt();
				
				if(menu != 1 && menu != 2) {
					System.err.println("Valor inválido!\n");
				}
				
				if(menu == 1) {
					estragado = true;
				} else if(menu == 2) {
					estragado = false;
				}
			}
			
			Ovo ovo = new Ovo(estragado, tamanho);
			
			menu = 0;
			
			while(!(menu == 3)) {
				System.out.print("\nO que fazer agora?\n\n1 - Quebrar o ovo\n2 - Fritar\n3 - Parar\n\nOpção: ");
				menu = ler.nextInt();
				
				if(menu == 1) {
					ovo.quebrar();
					
				} else if(menu == 2) {
					ovo.fritar();
				}
			}
			
			System.out.println("\nO ovo está " + ovo.pegarStatus());
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
}
