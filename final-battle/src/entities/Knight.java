package entities;

public class Knight extends CombatClass{

	public Knight(String name, Gender characterGender, Weapons weapon) {
		
        super(CombatClass.MAX_HEALTH, 15, 20, name, characterGender, weapon);
    }
}
