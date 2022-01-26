package entities;

public abstract class CombatClass extends Character implements Dice {

	private String name;
	private Gender gender;
	private Motivations motivation;
	private Weapons weapon;
	public static final int MAX_HEALTH = 200;
	
	public CombatClass(int healthPoints, int atkPoints, int defPoints, String name, Gender characterGender, Weapons weapon) {
		
		super(healthPoints, atkPoints, defPoints);
		this.name = name;
		this.gender = characterGender;
		this.motivation = null;
		this.weapon = weapon;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Motivations getMotivation() {
		return motivation;
	}

	public void setMotivation(Motivations motivation) {
		this.motivation = motivation;
	}

	public Weapons getWeapon() {
		return weapon;
	}

	public static int getMaxHealth() {
		return MAX_HEALTH;
	}

	@Override
	public void rollToAttack(Character defender, String difficultyLevel) {
		int diceResult = this.D20();
		int damageDealt;
		
		if (diceResult == 1) {
			System.out.println("Voc� errou seu ataque! O inimigo n�o sofreu dano algum.");
		} else {
			int deliveredAtk = this.getAtkPoints() + diceResult + this.weapon.getAtkPower();
			
			if (difficultyLevel == "Hard") {
				double decreasedAtk = deliveredAtk * 0.1;
				deliveredAtk = (int) (deliveredAtk - decreasedAtk);
			}
					
			if (diceResult == 20) {
				damageDealt = defender.takeDamage(deliveredAtk, true);
				System.out.print("Voc� acertou um ataque cr�tico!");
			} else {
				damageDealt = defender.takeDamage(deliveredAtk, false);
			}
			
			if (damageDealt < 1) {
				System.out.println("O inimigo bloqueou seu ataque e n�o sofreu dano algum!");
			} else {
				System.out.printf("Voc� atacou %s e causou %d de dano no inimigo!%n", this.weapon.getComplement(), damageDealt);
			}
		}
	}	
}