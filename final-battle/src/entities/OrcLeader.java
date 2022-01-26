package entities;

public class OrcLeader extends Enemy {
    private static final int MAX_HEALTH = 200;

    public OrcLeader() {
        super(MAX_HEALTH, 17, 17, Weapons.DOUBLE_AXE);
    }
}