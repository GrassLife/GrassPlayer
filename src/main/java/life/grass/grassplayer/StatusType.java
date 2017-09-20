package life.grass.grassplayer;

/**
 * Created by ecila on 2017/09/04.
 */
public enum StatusType {
    STRENGTH(1.0),
    INTELLIGENCE(1.0),
    DEXTERITY(1.0),
    AGILITY(0.5),
    VITALITY(0.5),
    FAITH(0.5);

    private double levelRate;

    StatusType(double levelRate) {
        this.levelRate = levelRate;
    }

    public double getLevelRate() {
        return this.levelRate;
    }
}
