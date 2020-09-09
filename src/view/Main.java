package view;

import controller.RedesController;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int opc = 0; 
		String system;
		RedesController so = new RedesController();
		system = so.os();
		
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Métodos ProcessosControler \n1 - Exibir Sistema Operacional \n2 - Exibibir IPv4's \n3 - Média de pimgs em MS do google \n9 - Enecerrar"));
			switch (opc) {
				case 1:
					System.out.println(so.os());
					break;
				case 2:
					so.ip(system, "ip address show");
					break;
				case 3:
					so.ping("Linux", "ping www.google.com.br");
					break;
				case 9:
					System.out.println("Processos Encerrados!");
					break;
				default:
					System.out.println("Opção inválida!");
					
			}
		
		}
		
	}
}
