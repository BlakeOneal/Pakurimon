// This program works to create Pakuri objects to be stored in the pakudex array
public class Pakuri {
    // Objects are initialized with a species name, attack, defense, and speed
    private String species;
    private int attack = 0;
    private int defense = 0;
    private int speed = 0;
    // Pakuri method allows species name, attack, defense, and speed to be initialized specific to a pakuri object
    public Pakuri(String species) {
        this.species = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }
    // getSpecies method provides the species name to become visible outside of the Pakuri class
    public String getSpecies() {
        return species;
    }
    // getAttack method provides the species attack to become visible outside of the Pakuri class
    public int getAttack(){
        return attack;
    }
    // getDefense method provides the species defense to become visible outside of the Pakuri class
    public int getDefense(){
        return defense;
    }
    // getSpeed method provides the species speed to become visible outside of the Pakuri class
    public int getSpeed(){
        return speed;
    }
    // setAttack method sets the Pakuri object's attack to a different integer value prompted by other methods
    public void setAttack(int newAttack){
        this.attack = newAttack;
    }
    // Evolve method changes the attack, defense, and speed stats of a specific pakuri object
    public void evolve(){
        this.attack = attack * 2;
        this.defense = defense * 4;
        this.speed = speed * 3;
    }
}
