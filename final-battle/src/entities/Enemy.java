package entities;

public abstract class Enemy extends Character implements Dice{
	
	private Weapons weapon;

	public Enemy(int healthPoints, int atkPoints, int defPoints, Weapons weapon) {
		super(healthPoints, atkPoints, defPoints);
		this.weapon = weapon;
	}
	
	 public Weapons getWeapon() {
		return this.weapon;
	}
	
	@Override
	public void rollToAttack(Character defender, String difficultyLevel) {
		int diceResult = this.D20();
		int damageTaken;
		
		if (diceResult == 1) {
			System.out.println("O inimigo errou o ataque! Voc� n�o sofreu dano.");
		} else {
			int deliveredAtk = this.getAtkPoints() + diceResult + this.weapon.getAtkPower();
			
			if (difficultyLevel == "Easy") {
				double decreasedAtk = deliveredAtk * 0.2;
				deliveredAtk = (int) (deliveredAtk - decreasedAtk);
			}
			
			if (diceResult == 20) {
				damageTaken = defender.takeDamage(deliveredAtk, true);
				System.out.print("O inimigo acertou um ataque cr�tico! ");
			} else {
				damageTaken = defender.takeDamage(deliveredAtk, false);
				System.out.print("O inimigo atacou! ");
			}
			
			if (damageTaken < 1) {
				System.out.println("Voc� bloqueou o ataque do inimigo e n�o sofreu nenhum dano!");
			} else {
				System.out.printf("Voc� sofreu %d de dano e agora possui %d pontos de vida.%n", damageTaken, defender.getHealthPoints());				
			}
		}
	}
}