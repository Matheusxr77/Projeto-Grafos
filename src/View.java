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
			
			int choice = JOptionPane.showOptionDialog(
					null, 
					"Menu - Escolha uma opção \n"
					+ "1 - Imprimir as cidades que o sistema abarca \n"
					+ "2 - Imprimir a distância de cada a partir da matriz \n"
					+ "3 - Escolher o percurso \n"
					+ "4 - Sair \n",
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
					System.out.println("");
					// Printing the adjacency matrix
					graph.printMatrix();
					break;
					
                // Printing the shortest path between the origin and destination cities
				case 2:
					// Declaring Scanner objects to read input from the user for origin and destination cities
					//Scanner text = new Scanner(System.in);
					//String input1 = null;
					//String input2 = null;
	
					//System.out.println("");
					// Asking for the origin and destination cities
					String input1 = JOptionPane.showInputDialog(null, "Informe o nome da cidade de origem: ");
					//input1 = text.nextLine();
					String input2 = JOptionPane.showInputDialog(null, "Informe o nome da cidade destino: ");
					//input2 = text.nextLine();
	
                    // Printing the shortest path between the origin and destination cities
					graph.printShortestPath(City.findByCity(input1, list), City.findByCity(input2, list));
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