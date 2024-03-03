// Declaring the package name
package src;

// Importing necessary library
import java.util.ArrayList;
import javax.swing.JOptionPane;

// View Class
public class View {
    // Method to display the menu and handle user inputs
	public void menu(Graph graph, ArrayList<City> list) {
		// Variable to control menu loop
		Boolean proceed = true;
		
		// Menu loop
		while (proceed) {
			// Displaying menu options
			Object[] options = {"1", "2", "3"};
			
			int choice = JOptionPane.showOptionDialog(
					null, 
					"Menu - Escolha uma opção \n"
					+ "1 - Imprimir as cidades que o sistema abarca \n"
					+ "2 - Escolher o percurso \n"
					+ "3 - Sair \n",
					"Sistema de Gerenciamento de Distribuição de Energia Elétrica",
					JOptionPane.NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[0]);
			
			if (choice == JOptionPane.CLOSED_OPTION) {
				proceed = false;
			}

			// Switch-case to handle user's choice
			switch (choice) {
				// Printing the list of cities
				case 0:
					System.out.println("");
					// Printing the list of cities
					graph.printCities();
					break;
					
				// Printing the adjacency matrix
				case 1:
					String input1 = JOptionPane.showInputDialog(null, "Informe o nome da cidade de origem: ");
					String input2 = JOptionPane.showInputDialog(null, "Informe o nome da cidade destino: ");
					graph.printShortestPath(City.findByCity(input1, list), City.findByCity(input2, list));
					break;
					
                // Exit
				case 2:
					// Exiting
					JOptionPane.showMessageDialog(null, "\nVocê saiu do programa!");
					proceed = false;
					break;
			}
		}
	}
}