// Declaring the package name
package src;

// Importing necessary library
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

// Graph Class
public class Graph {
	// Declaring instance variables
	private double[][] matrix;
	private int[][] next;
	private int numberVertices;
	
	// List of vertices (cities)
	private List<City> vertex;
	
	// Constant representing infinity
	double INF = Double.POSITIVE_INFINITY;

	// Constructor for Graph class
	public Graph(int numberVertices) {
		// Initializing instance variables
		this.numberVertices = numberVertices;
		this.vertex = new ArrayList<City>(numberVertices);
		this.matrix = new double[numberVertices][numberVertices];
		this.next = new int[numberVertices][numberVertices];
		
		// Initializing the matrix with INF values
		for (int i = 0; i < numberVertices; i++) {
			for (int j = 0; j < numberVertices; j++) {
				if (i == j) {
					// Diagonal elements set to 0
					matrix[i][j] = 0;
				} else {
					// Non-diagonal elements set to INF
					matrix[i][j] = INF;
				}
			}
		}
	}

	// Method to get the index of a city in the vertex list
	public int getVertexIndex(City city) {
		// Returning the index of the specified city in the list of cities
		return this.vertex.indexOf(city); 
	}

	// Method to add a city to the vertex list
	public void addVertex(City city) {
		// Adding the specified city to the list of cities
		this.vertex.add(city);
	}

	// Method to add an edge between two cities with a specified distance
	public void addEdge(City origin, City destination, double distance) {
		// Getting the index of the origin city and destination city
		int i = vertex.indexOf(origin);
		int j = vertex.indexOf(destination);
		
		// Checking if both cities are present in the graph
		if (i >= 0 && j >= 0) {
			// Setting the distance between origin and destination
			matrix[i][j] = distance;
			
			// Setting the distance between destination and origin (assuming undirected graph)
			matrix[j][i] = distance;
		}
	}

	// Method to print the adjacency matrix
	public void printMatrix() {		
		// Loop through each row of the matrix
		for (int i = 0; i < numberVertices; i++) {
			// Loop through each element in the current row
			for (int j = 0; j < numberVertices; j++) {
				// Printing the elements of the matrix
				JOptionPane.showMessageDialog(null, matrix[i][j] + " "); 
			}
		}
	}

	// Method to perform the Floyd-Warshall algorithm to find the shortest paths between all pairs of vertices
	public void floydWarshallAlgorithm() {
	    // Iterate through all vertices
		for (int i = 0; i < numberVertices; i++) {
		    // Iterate through all vertices again
			for (int j = 0; j < numberVertices; j++) {
			    // Check if there is a direct edge between vertex i and vertex j
				if (matrix[i][j] != INF) {
				    // Setting the next vertex to j if there is a direct edge between i and j
					next[i][j] = j;
				}
			}
		}
		
	    // Iterate through all vertices
		for (int k = 0; k < numberVertices; k++) {
		    // Iterate through all vertices
			for (int i = 0; i < numberVertices; i++) {
			    // Iterate through all vertices again
				for (int j = 0; j < numberVertices; j++) {
				    // If going from vertex i to vertex k and then to vertex j is shorter than going directly from i to j
					if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
					    // Update the distance between i and j via vertex k
						matrix[i][j] = matrix[i][k] + matrix[k][j];
						
						// Update the next vertex to go from i to j
						next[i][j] = next[i][k];
					}
				}
			}
		}
	}

	// Method to calculate electricity leakage cost between two cities
	public String calculationElectricityLeakage(City origin, City destination) {
	    // Getting the index of the origin city and destination city
		int i = vertex.indexOf(origin);
		int j = vertex.indexOf(destination);
		
		// Declaring an variable
		double cost = 0.0;
		
	    // Loop until reaching the destination city
		while (i != j) {
		    // If the origin city is the first city (index 0)
			if (i == 0) {
			    // Adding the distance from i to next[i][j] to the leakage cost
				cost += matrix[i][next[i][j]];
			} else {
			    // Adding the distance from (i-1) to i to the leakage cost
				cost += matrix[i - 1][i];
			}
			
			// Updating i to the next vertex in the shortest path
			i = next[i][j]; 
		}
		
		// Calculating the total leakage cost based on the distance between the origin and destination cities
		cost = 0.035 * matrix[vertex.indexOf(origin)][vertex.indexOf(destination)];
		String message = "Custo para transportar a energia elétrica (vazamento de cada kW por km): R$ " + String.format("%.3f", cost);
		
		// Printing the leakage cost
		return message;
				
		//JOptionPane.showMessageDialog(null, message);
	}


	// Method to print the list of cities
	public void printCities() {
	    final int max = 25;
	    StringBuilder cityList = new StringBuilder();
	    int count = 0;
		// Iterate through each city in the list of vertices
		for (int i = 0; i < this.vertex.size(); i++) {
	        cityList.append(getVertexIndex(this.vertex.get(i))).append(" - ").append(this.vertex.get(i).getName()).append("\n");
	        count++;
	        if (count == max || i == this.vertex.size() - 1) {
	            JOptionPane.showMessageDialog(null, cityList.toString());
	            cityList = new StringBuilder();
	            count = 0;
	        }
		}
	}

	// Method to print the shortest path between two cities
	public void printShortestPath(City origin, City destination) {
	    // Getting the index of the origin city and destination city
		int i = vertex.indexOf(origin);
		int j = vertex.indexOf(destination);
		
		// Declaring an empty string variable to store the path traversed
		String path = "";

	    // If there is no path between the origin and destination cities
		if (matrix[i][j] == INF) {
		    // Printing a message indicating that there is no path between the origin and destination cities
			JOptionPane.showMessageDialog(null, "Não existe caminho entre " + origin.getName() + " e " + destination.getName());
		} else {
			String message1 = "Percurso de " + origin.getName() + " para " + destination.getName();
			// Adding the origin city to the path
			path += origin.getName(); 
			
			// Loop until reaching the destination city
			while (i != j) {
			    // Updating i to the next vertex in the shortest path
				i = next[i][j];
				
				// Adding the name of the current city to the path
				path += " -> " + vertex.get(i).getName();
			}
			double num = matrix[vertex.indexOf(origin)][vertex.indexOf(destination)];
			String message2 = "Caminho percorrido: " + path + "\n" + "Distância percorrida: " + String.format("%.2f", num) + "km" + "\n";
			// Calculating and printing the electricity leakage cost
			String message3 = calculationElectricityLeakage(origin, destination);
			JOptionPane.showMessageDialog(null, message1 + "\n" + message2 + message3);
		}
	}

	// Method to get the adjacency matrix
	public double[][] getMatrix() {
	    // Returning the adjacency matrix
		return matrix;
	}

	// Method to set the adjacency matrix
	public void setMatrix(double[][] matrix) {
	    // Setting the adjacency matrix
		this.matrix = matrix;
	}

	// Method to get the list of cities
	public List<City> getVertex() {
	    // Returning the list of cities
		return vertex;
	}

	// Method to set the list of cities
	public void setVertex(List<City> vertex) {
	    // Setting the list of cities
		this.vertex = vertex;
	}

	// Method to get the number of vertices
	public int getNumberVertices() {
	    // Returning the number of vertices
		return numberVertices;
	}

	// Method to set the number of vertices
	public void setNumberVertices(int numberVertices) {
	    // Setting the number of vertices
		this.numberVertices = numberVertices;
	}
}