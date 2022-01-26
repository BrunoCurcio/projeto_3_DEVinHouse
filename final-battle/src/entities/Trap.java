package entities;

public class Trap implements Dice{
	
	Weapons weapon;
	
	public Trap() {

		this.weapon = Weapons.TRAP;
	}

	@Override
	public void rollToAttack(Character defender, String difficultyLevel) {
		int diceResult = this.D10();
		
		if (diceResult == 1) {
			System.out.println("O ataque da armadilha pegou de rasp�o e voc� n�o sofreu dano.");
		} else {
			int deliveredAtk = diceResult + this.weapon.getAtkPower();
			
			if (difficultyLevel == "Easy") {
				double decreasedAtk = deliveredAtk * 0.2;
				deliveredAtk = (int) (deliveredAtk - decreasedAtk);
			}
			
			int damageTaken = defender.takeDamage(deliveredAtk, false);
			
			if (damageTaken < 1) {
				System.out.println("A flecha pegou de rasp�o na armadura e voc� n�o sofreu dano!");
			} else {
				System.out.printf("Voc� sofreu %d de dano e agora possui %d pontos de vida.%n", damageTaken, defender.getHealthPoints());				
			}
		}
	}

}
