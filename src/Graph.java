// Declaring the package name
package src;

// Importing necessary library
import java.util.ArrayList;
import java.util.List;

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
				System.out.print(matrix[i][j] + " "); 
			}
			
			// Moving to the next line after printing each row
			System.out.println();
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
	public void calculationElectricityLeakage(City origin, City destination) {
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
		
		// Printing the leakage cost
		System.out.printf("Custo para transportar a energia eletrica (vazamento de cada kW por km): R$ %.3f", cost);
	}


	// Method to print the list of cities
	public void printCities() {
		// Iterate through each city in the list of vertices
		for (City city : this.vertex) {
			// Printing the index and name of each city in the list
			System.out.println(getVertexIndex(city) + " - " + city.getName());
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
			System.out.println("Não existe caminho entre " + origin.getName() + " e " + destination.getName());
		} else {
		    // Printing the origin and destination cities
			System.out.println("Percurso de " + origin.getName() + " para " + destination.getName() + "\n");
			
			// Adding the origin city to the path
			path += origin.getName(); 
			
			// Loop until reaching the destination city
			while (i != j) {
			    // Updating i to the next vertex in the shortest path
				i = next[i][j];
				
				// Adding the name of the current city to the path
				path += " -> " + vertex.get(i).getName();
			}
			
			// Printing the shortest path
			System.out.println("Caminho percorrido: " + path);
			
			// Printing the distance between origin and destination
			System.out.printf("Distância percorrida: %.2f Km\n", matrix[vertex.indexOf(origin)][vertex.indexOf(destination)]);
			
			// Calculating and printing the electricity leakage cost
			calculationElectricityLeakage(origin, destination);
			
			// Printing a newlin
			System.out.println();
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