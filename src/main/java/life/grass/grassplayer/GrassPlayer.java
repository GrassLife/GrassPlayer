package life.grass.grassplayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GrassPlayer {
    private static Map<String, GrassPlayer> playerMap;

    private String uuid;
    private int stamina, effectiveStamina, maxStamina;

    static {
        playerMap = new HashMap<>();
    }

    private GrassPlayer(String uuid) {
        this.uuid = uuid;
        stamina = 100;
        effectiveStamina = 100;
        maxStamina = 100;
    }

    public static GrassPlayer get(Player player) {
        return get(player.getUniqueId().toString());
    }

    public static GrassPlayer get(String uuid) {
        if (!playerMap.containsKey(uuid)) {
            playerMap.put(uuid, new GrassPlayer(uuid));
        }

        return playerMap.get(uuid);
    }

    public boolean save() {
        return false;
    }

    public Player toPlayer() {
        return Bukkit.getPlayer(UUID.fromString(uuid));
    }

    public int getStamina() {
        return stamina;
    }

    public int getEffectiveStamina() {
        return effectiveStamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void incrementStamina(int stamina) {
        setStamina(this.stamina + stamina);
    }

    public void setStamina(int stamina) {
        if (stamina < 0) {
            stamina = 0;
        } else if (effectiveStamina < stamina) {
            stamina = effectiveStamina;
        }

        this.stamina = stamina;
        applyStaminaToFoodLevel();
    }

    public void setEffectiveStamina(int effectiveStamina) {
        if (effectiveStamina < 0) {
            effectiveStamina = 0;
        } else if (maxStamina < effectiveStamina) {
            effectiveStamina = maxStamina;
        }

        this.effectiveStamina = effectiveStamina;
        applyStaminaToFoodLevel();
    }

    public void setMaxStamina(int maxStamina) {
        if (maxStamina < 0) {
            maxStamina = 0;
        }

        this.maxStamina = maxStamina;
    }

    private void applyStaminaToFoodLevel() {
        Player player = toPlayer();
        
        player.setFoodLevel((int) (20 * (float) stamina / effectiveStamina));
        player.setSaturation(1);
    }
}
