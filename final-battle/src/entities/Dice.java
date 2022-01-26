package entities;

import java.util.Random;

public interface Dice {
	
	default int D10() {
		Random dice = new Random();
		return dice.nextInt(10) + 1;
	}
	
	default int D20() {
		Random dice = new Random();
		return dice.nextInt(20) + 1;
	}
	
	void rollToAttack(Character defender, String difficultyLevel);
}