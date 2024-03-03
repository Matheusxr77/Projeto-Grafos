// Declaring the package name
package src;

// Importing necessary library
import java.util.ArrayList;
import java.util.Scanner;

// View Class
public class View {
	// Declaring a private Scanner object named 'scan' to read input from the user
	private Scanner scan;
	
    // Method to display the menu and handle user inputs
	public void menu(Graph graph, ArrayList<City> list) {
		// Initializing Scanner object
		scan = new Scanner(System.in);
		
		// Variable to control menu loop
		Boolean proceed = true;
		
		// Menu loop
		while (proceed) {
			// Displaying menu options
			System.out.println("\nSistema de Gerenciamento do Transporte da Rede Elétrica - M&M Gus\n");
			System.out.println("1 - Imprimir as cidades que o sistema abarca");
			System.out.println("2 - Imprimir a distância de cada a partir da matriz que distribui energia");
			System.out.println("3 - Escolher o percurso");
			System.out.println("4 - Sair");

			// Reading user input
			int option = scan.nextInt();
			
			// Switch-case to handle user's choice
			switch (option) {
				// Printing the list of cities
				case 1:
					System.out.println("");
					// Printing the list of cities
					graph.printCities();
					break;
					
				// Printing the adjacency matrix
				case 2:
					System.out.println("");
					// Printing the adjacency matrix
					graph.printMatrix();
					break;
					
                // Printing the shortest path between the origin and destination cities
				case 3:
					// Declaring Scanner objects to read input from the user for origin and destination cities
					Scanner text = new Scanner(System.in);
					String input1 = null;
					String input2 = null;
	
					System.out.println("");
					// Asking for the origin and destination cities
					System.out.println("Informe o nome da cidade de origem: ");
					input1 = text.nextLine();
					System.out.println("Informe o nome da cidade de destino: ");
					input2 = text.nextLine();
	
                    // Printing the shortest path between the origin and destination cities
					graph.printShortestPath(City.findByCity(input1, list), City.findByCity(input2, list));
					break;
					
				// Exit
				case 4:
					// Exiting
					System.out.println("\nVocê saiu do programa!");
					proceed = false;
					break;
				
				// Handling invalid input
				default:
					System.out.println("\nOpção inválida!");
					break;
			}
		}
	}
}