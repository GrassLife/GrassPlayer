package life.grass.grassplayer;

/**
 * Created by ecila on 2017/09/04.
 */
public enum StatusType {
    STRENGTH("Str", 1.0),
    INTELLIGENCE("Int", 1.0),
    DEXTERITY("Dex", 1.0),
    AGILITY("Agi", 0.5),
    VITALITY("Vit", 0.5),
    FAITH("Fth", 0.5);

    private double levelRate;
    private String label;

    StatusType(String label, double levelRate) {
        this.levelRate = levelRate;
        this.label = label;
    }

    public double getLevelRate() {
        return this.levelRate;
    }

    public String getLabel() {
        return this.label;
    }
}
