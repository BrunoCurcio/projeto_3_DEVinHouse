package entities;

public class Warrior extends CombatClass {
	
	  public Warrior(String name, Gender characterGender, Weapons weapon) {
	        super(CombatClass.MAX_HEALTH, 20, 15, name, characterGender, weapon);
	    }
}
