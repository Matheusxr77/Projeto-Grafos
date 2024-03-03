// Declaring the package name
package src;

// Importing necessary library
import java.util.ArrayList;

// Main Class
public class Main {
	// Main method serves as the entry point of the program
	public static void main(String[] args) {
        // Creating an instance of Repository to populate the list of cities
		Repository repository = new Repository();
		
		// Invoking the databaseCities method of the Repository instance to populate the list of cities
		repository.databaseCities();

        // Obtaining the list of cities from the repository
		ArrayList<City> list = repository.list;

        // Creating an instance of Graph with the size of the city list
		Graph graph = new Graph(list.size());
		
        // Adding vertices to the graph for each city in the list
		for (City city : list) {
			graph.addVertex(city);
		}

        // Adding edges to the graph with specified distances between cities
		graph.addEdge(list.get(0), list.get(1), 22.6); // Garanhuns, Paranatama
		graph.addEdge(list.get(1), list.get(2), 15.4); // Paranatama, Saloa
		graph.addEdge(list.get(1), list.get(4), 24.0); // Paranatama, Meladinho
		graph.addEdge(list.get(4), list.get(5), 12.2); // Meladinho, Iati
		graph.addEdge(list.get(2), list.get(3), 25.9); // Saloa, Bom conselho
		graph.addEdge(list.get(5), list.get(3), 26.0); // Iati, Bom Conselho
		graph.addEdge(list.get(0), list.get(34), 23.2); // Garanhuns, Brejão
		graph.addEdge(list.get(34), list.get(3), 26.3); // Brejão, Bom Conselho
		graph.addEdge(list.get(0), list.get(16), 20.9); // Garannhus, Caétes
		graph.addEdge(list.get(16), list.get(10), 28.4); // Caetés, Tarci
		graph.addEdge(list.get(10), list.get(11), 14.5); // Tarci, Venturosa
		graph.addEdge(list.get(11), list.get(12), 12.6); // Venturosa, Pedra
		graph.addEdge(list.get(12), list.get(13), 19.1); // Pedra, Arcoverde
		graph.addEdge(list.get(13), list.get(15), 27.3); // Arcoverde, Buíque
		graph.addEdge(list.get(10), list.get(7), 9.1); // Tarci, Santo Antônio
		graph.addEdge(list.get(7), list.get(9), 18.8); // Santo Antônio, Japecanga
		graph.addEdge(list.get(9), list.get(8), 17.4); // Japecanga, Garcia
		graph.addEdge(list.get(8), list.get(6), 28.4); // Garcia, Aguas Belas
		graph.addEdge(list.get(6), list.get(5), 29.6); // Aguas Belas, Iati
		graph.addEdge(list.get(0), list.get(33), 16.3); // Garanhuns, Joao Joao
		graph.addEdge(list.get(33), list.get(32), 11.1); // Sao joao, Angelim
		graph.addEdge(list.get(32), list.get(45), 5.8); // Angelim, Palmerina
		graph.addEdge(list.get(45), list.get(42), 35.7); // Palmerina, Correntes
		graph.addEdge(list.get(0), list.get(46), 28.9); // Garanhuns, Iratama
		graph.addEdge(list.get(46), list.get(43), 24.0); // Iratama, Lagoa do Ouro
		graph.addEdge(list.get(46), list.get(44), 17.1); // Lagoa do Ouro, Barra do Brejo
		graph.addEdge(list.get(46), list.get(42), 15.8); // Lagoa ouro, Correntes
		graph.addEdge(list.get(42), list.get(40), 16.2); // Coorentes, Santana
		graph.addEdge(list.get(40), list.get(38), 26.3); // Santana, União
		graph.addEdge(list.get(38), list.get(37), 32.7); // União, Serra Grande
		graph.addEdge(list.get(32), list.get(31), 13.4); // Angelim, Canhotinho
		graph.addEdge(list.get(31), list.get(47), 27.4); // Canhotinho, Quipapá
		graph.addEdge(list.get(37), list.get(47), 26.1); // Serra Grande, Quipapá
		graph.addEdge(list.get(31), list.get(20), 33.3); // Canhorinho, Lajedo
		graph.addEdge(list.get(0), list.get(24), 18.6); // Garanhuns, Batinga
		graph.addEdge(list.get(24), list.get(21), 5.6); // Batinga, Jupi
		graph.addEdge(list.get(21), list.get(20), 13.7); // Jupi, Lajedo
		graph.addEdge(list.get(21), list.get(23), 41.6); // Jupi, Jurema
		graph.addEdge(list.get(16), list.get(17), 5.9); // Caetés, Capoeiras
		graph.addEdge(list.get(17), list.get(18), 33.); // Capoeiras, São Bento
		graph.addEdge(list.get(18), list.get(19), 12.1); // São Bento, Queimada Grande
		graph.addEdge(list.get(19), list.get(20), 8.7); // Queimada Grande, Lajedo
		graph.addEdge(list.get(20), list.get(26), 21.8); // Lajedo, Cachoeirinha
		graph.addEdge(list.get(20), list.get(25), 23.0); // Ibirajuba, Lajedo
		graph.addEdge(list.get(25), list.get(27), 17.8); // Ibirajuba, Altinho
		graph.addEdge(list.get(27), list.get(49), 15.0); // Altinho, Agrestina
		graph.addEdge(list.get(23), list.get(48), 21.2); // Jurama, Panelas
		graph.addEdge(list.get(23), list.get(28), 12.8); // Panelas, Cupira
		graph.addEdge(list.get(23), list.get(49), 18.7); // Cupira, Agrestina
		graph.addEdge(list.get(47), list.get(48), 22.2); // Quipapá, Panelas
		graph.addEdge(list.get(49), list.get(30), 18.5); // Agrestina, Batateira
		graph.addEdge(list.get(47), list.get(36), 33.5); // Quipapá, Jaqueira
		graph.addEdge(list.get(30), list.get(35), 21.8); // Batateira, Catende
		graph.addEdge(list.get(36), list.get(35), 14.7); // Jaqueira, Catende
		graph.addEdge(list.get(30), list.get(29), 23.6); // Batateira, Bonito
		graph.addEdge(list.get(26), list.get(25), 29.7); // Cachoeirinha, Ibirajuba
		graph.addEdge(list.get(22), list.get(20), 10.3); // Jacaré, Lajedo
		graph.addEdge(list.get(22), list.get(23), 28.4); // Jacaré, Jurema
		graph.addEdge(list.get(22), list.get(21), 28.4); // Jacaré, Jupi

        // Performing the Floyd-Warshall algorithm to find shortest paths between all pairs of vertices
		graph.floydWarshallAlgorithm();

        // Creating an instance of View to display the menu and handle user interactions
		View view = new View();
		
		// Invoking the menu method of the View instance to display the menu and handle user interactions
		view.menu(graph, list);
	}
}