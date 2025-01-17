package entities;

public enum Weapons {
	SWORD(9, "Espada", "com sua espada"),
	AXE(10, "Machado", "com seu machado"),
	HAMMER(9, "Martelo", "com seu martelo"),
	CLUB(10, "Clava", "com sua clava"),
	BOW_AND_ARROW(9, "Arco e flecha", "com seu arco, a flecha atingiu"),
	CROSSBOW(10, "Besta", "com sua besta, o virote atingiu"),
	STAFF(10, "Cajado", "com seu cajado, lan�ando uma bola de fogo"),
	GRIMOIRE(11, "Grim�rio", "absorvendo energia do livro com uma m�o e liberando com a outra"),
	TRAP(12, "Armadilha", null),
	DOUBLE_AXE(12, "Machado de l�mina dupla", null);
	
	private int atkPower;
	private String name;
	private String complement;
	
	 Weapons(int atkPower, String name, String complement) {
		this.atkPower = atkPower;
		this.name = name;
		this.complement = complement;
	}

	public int getAtkPower() {
		return atkPower;
	}

	public String getName() {
		return name;
	}
	
	public String getComplement() {
		return this.complement;
	}
}