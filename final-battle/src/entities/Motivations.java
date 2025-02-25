package entities;

public enum Motivations {
	VENGEANCE(1, "Vingan�a"),
	GLORY (2, "Gl�ria");
	
	private int id;
	private String motivation;
	
	Motivations (int id, String motivation) {
		this.id = id;
		this.motivation = motivation;
	}

	public int getId() {
		return id;
	}

	public String getMotivation() {
		return motivation;
	}

	public static String getMotivation(int id) {
        return  Motivations.values()[id].getMotivation();
    }
	
}
