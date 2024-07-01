package HW3Arrays;                                                                                                                  //Morgan Pickens          
                                                                                                                                    // 5/27/2024

public class City implements Comparable<City> {
    private String name; // For the name of the city
    private String country; // Country 
    private String state; // State 
    private int population; // and the population of the city 

    
     // Constructor to initialize a City object.
     
     // @param name       
    //  @param country    
     // @param state      
     // @param population 
     // @throws IllegalArgumentException any null or empty param (but not the state)
     //
    public City(String name, String country, String state, int population) {
        if (name == null || name.isEmpty() || country == null || country.isEmpty()) {
            throw new IllegalArgumentException("Invalid arguments"); // This is to check the input 
        }
        this.name = name;
        this.country = country;
        this.state = state;
        this.population = population;
    }

    // The following below are the methods we use for name, country, state, and population. 
    public String getName() { return name; }

    
    public String getCountry() { return country; }

    
    public String getState() { return state; }

   
    public int getPopulation() { return population; }
    
                      // The below is for our override 
    @Override
    public int compareTo(City other) {
       
        int countryCompare = this.country.compareTo(other.country);
        if (countryCompare != 0) {
            return countryCompare;
        }
        int stateCompare = this.state.compareTo(other.state);
        if (stateCompare != 0) {
            return stateCompare;
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        
        return name + ", " + state + ", " + country + ": " + population;
    }
}

