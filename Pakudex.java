/*
Title: Arrays.sort() in Java with examples
Author: GeeksforGeeks
Date: 4/04/2020
Description: Looked at website to learn how to use comparators with arrays.sort() to avoid null pointer exceptions
Code Version: 1
Availability: Public
In line 97, Source code is from website https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
 */
import java.util.Comparator;
import java.util.Objects;
import java.util.Arrays;
// This program works to create Pakudex objects, which serve as arrays to hold Pakuri objects
public class Pakudex {
    // Int size and capacity used to keep track of the size of the array and the amount of Pakuri objects that can be held within the Pakudex object
    private static int size = 0;
    private int capacity;
    // Declares three private arrays, the Pakuri object speciesArray, a string array namesArray, and a string array ArraytoReturn
    private Pakuri[] speciesArray;
    private String[] namesArray;
    private String[] arrayToReturn;

    // Default constructor for the Pakudex object, assigns default values to speciesArray and namesArray
    public Pakudex() {
        capacity = 20;
        speciesArray = new Pakuri[capacity];
        namesArray = new String[capacity];
    }
// Non-default constructor, passes in capacity from userInput and initializes arrays to be size int capacity
    public Pakudex(int capacity) {
        this.capacity = capacity;
        speciesArray = new Pakuri[this.capacity];
        namesArray = new String[this.capacity];
    }
// getSize returns the size of the array, making it visible to other classes
    public int getSize() {
        return size;
    }
// getCapacity returns the capacity of the array, making it visible to other classes
    public int getCapacity() {
        return capacity;
    }

    // getspeciesArray works through the namesArray and assigns every non-null value to be held within arrayToReturn
    public String[] getSpeciesArray() {
        // int count serves to keep track of the amount of non-null elements within namesArray used to create the size of arrayToReturn
        int count = 0;
        // iterates through every element within namesArray, increments count by one each time a non-null element appears in namesArray
        for (int i = 0; i <= namesArray.length - 1; i++) {
            if (namesArray[i] != null) {
                count++;
            }
        }
        // If the count of non-null elements (namesArray is null) amounts to 0, returns a null value
        if (count == 0) {
            return null;
        }
        else {
            // Initializes a new array arrayToReturn size count and assigns every value in arrayToReturn to be the same as namesArray at index i
            arrayToReturn = new String[count];
            for (int i = 0; i <= arrayToReturn.length - 1; i++) {
                arrayToReturn[i] = namesArray[i];
            }
            // Returns the newly created array arrayToReturn
        }
        return arrayToReturn;
    }
// getStats method reads the species string from user Input, searches for the existence of that Pakuri in the Pakudex, and returns that Pakuri's stats
    public int[] getStats(String species) {
        // Creates a new array pakuriStats used to hold attack, defense, and speed values
        int[] pakuriStats = new int[3];
        // Iterates through namesArray and ensures that namesArray[i] equals the species name (species exists within pakudex), then assigns values to pakuriStats array
        for (int i = 0; i <= namesArray.length - 1; i++) {
            if (Objects.equals(namesArray[i], species)) {
                pakuriStats[0] = speciesArray[i].getAttack();
                pakuriStats[1] = speciesArray[i].getDefense();
                pakuriStats[2] = speciesArray[i].getSpeed();
                break;
            }
            // If the species does not exist, assigns 0 to every pakuriStats value
            else {
                pakuriStats[0] = 0;
                pakuriStats[1] = 0;
                pakuriStats[2] = 0;
            }
        }
        // If the species does not exist, returns a null value
        if (pakuriStats[0] == 0) {
            return null;
        }
        // Returns the newly created array pakuriStats
return pakuriStats;
    }
// sortPakuri method sorts the namesArray object in lexicographical order
    public void sortPakuri() {
        // Comparator used to avoid null pointer issue, sorts null objects last
        Arrays.sort(namesArray, Comparator.nullsLast(Comparator.naturalOrder()));
    }
// addPakuri method adds the Pakuri with species name read from user Input to Pakudex object
    public boolean addPakuri(String species) {
        int i;
        int j = 0;
        // Ensures that namesArray has a null value, AKA has space to hold another species
        for (i = 0; i <= namesArray.length - 1; i++) {
            if (namesArray[i] == null) {
                // Iterates through array to ensure that the species does not already exist
                for (j = j; j <= namesArray.length - 1; j++)
                {
                    // If species is detected to already exist, provides an error statement to the user
                    if (Objects.equals(namesArray[j], species)) {
                        System.out.println("Error: Pakudex already contains this species!");
                        // Returns false if Pakuri is not added successfully
                        return false;
                    }
                    // If the value of j = namesArray.length - 1, (Iterates through every possible element and species does not already exist), adds Pakuri to Pakudex
                    if (j == namesArray.length - 1) {
                        namesArray[i] = species;
                        speciesArray[i] = new Pakuri(species);
                        size++;
                        // Returns true if Pakuri is added successfully
                        return true;
                    }
                }
            }
        }
        return false;
    }
// evolveSpecies method evolves the Pakuri with species name provided from user Input, which alters the stats of the Pakuri
    public boolean evolveSpecies(String species) {
        int i;
        // Checks if the Pakuri exists, if it does, invokes the evolve method within the Pakuri class
        for (i = 0; i <= namesArray.length - 1; i++) {
            if (Objects.equals(namesArray[i], species)) {
                speciesArray[i].evolve();
                // Returns true if Pakuri is successfully evolved
                return true;
            }
        }
        // Returns false if Pakuri is not evolved
return false;
    }
}
