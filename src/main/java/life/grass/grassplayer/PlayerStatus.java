package life.grass.grassplayer;

import org.bukkit.entity.Player;

import java.util.Map;

/**
 * Created by ecila on 2017/09/03.
 */
public class PlayerStatus {
    private Player parent;
    private Map<StatusType, Integer> equipmentBonus;

    public PlayerStatus(Player parent) {
        this.parent = parent;
    }

    public Player getParent() {
        return parent;
    }

    public int getRawStatus(StatusType type) {
        return (int) ((double) parent.getLevel() * type.getLevelRate());
    }
}
