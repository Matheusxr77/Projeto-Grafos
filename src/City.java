// Declaring the package name
package src;

// Importing necessary library
import java.util.List;

// Declaring a class named City which implements the Comparable interface with type parameter City
public class City implements Comparable<City> { 
    // Declaring instance variable
    private String name;

    // Constructor for City class
    public City(String name) {
    	// Setting the name of the city
        this.setName(name);
    }

    // Getter method for the name of the city
    public String getName() {
        return name;
    }

    // Setter method for the name of the city
    public void setName(String name) {
        this.name = name;
    }

    // Static method to find a city by its name in a list of cities
    public static City findByCity(String name, List<City> cities) {
    	// Iterating through the list of cities
        for (City city : cities) {
        	// Checking if the name of the current city matches the specified name
            if (city.getName().equalsIgnoreCase(name)) {
            	// Returning the city if found
                return city; 
            }
        }
     // Returning null if the city is not found in the list
        return null; 
    }

    // Overriding the compareTo method of the Comparable interface
    @Override
    public int compareTo(City c) {
    	// Currently, all cities are considered equal, so returning 0
        return 0; 
    }
}