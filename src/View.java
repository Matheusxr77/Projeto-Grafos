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
			Object[] options = {"1", "2", "3", "4"};
			
			// Displaying the menu using JOptionPane and getting user input
			int choice = JOptionPane.showOptionDialog(
					null, 
					"Menu - Escolha uma opção \n"
					+ "1 - Imprimir as cidades que o sistema abarca \n"
					+ "2 - Escolher o percurso \n"
					+ "3 - Calcular custo de vazamento por quilômetro \n"
					+ "4 - Sair \n",
					"Sistema de Gerenciamento de Distribuição de Energia Elétrica",
					JOptionPane.NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[0]);
			
			// Handling user's choice
			if (choice == JOptionPane.CLOSED_OPTION) {
				// Exiting if the user closes the option dialog
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
					// Prompting user to input the origin and destination cities
					String input1 = JOptionPane.showInputDialog(null, "Informe o nome da cidade de origem: ");
					String input2 = JOptionPane.showInputDialog(null, "Informe o nome da cidade destino: ");
					
					// Printing the shortest path between the specified cities
					graph.printShortestPath(City.findByCity(input1, list), City.findByCity(input2, list));
					break;
					
				// Calculating electricity leakage cost per kilometer
				case 2:
					// Prompting the user to input the distance to calculate the leakage
					String input = JOptionPane.showInputDialog(null, "Informe a quilometragem que deseja calcular o vazamento: ");
					
					// Converting the input to double
					double distance = Double.parseDouble(input);
					
					// Calculating and printing the electricity leakage cost for the specified distance
					graph.leakageCalculatorKilometer(distance);
					break;
				
				// Exit
				case 3:
					// Exiting
					JOptionPane.showMessageDialog(null, "\nVocê saiu do programa!");
					proceed = false;
					break;
			}
		}
	}
}