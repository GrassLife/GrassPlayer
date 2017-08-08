package life.grass.grassplayer;

import life.grass.grassplayer.achievement.GrassAchievement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class GrassPlayer {
    private static Map<String, GrassPlayer> playerMap;

    private String uuid;
    private int stamina, effectiveStamina, maxStamina, mana;
    private Map<GrassAchievement, Integer> achievementMap;

    static {
        playerMap = new HashMap<>();
    }

    private GrassPlayer(String uuid) {
        this.uuid = uuid;
        stamina = 500;
        effectiveStamina = 500;
        maxStamina = 500;
        mana = 0;
        achievementMap = new HashMap<>();

        Arrays.stream(GrassAchievement.values()).forEach(achievement -> achievementMap.put(achievement, 0));
    }

    public static void create(Player player) {
        String uuid = player.getUniqueId().toString();
        playerMap.put(uuid, new GrassPlayer(uuid));
    }

    public static Optional<GrassPlayer> find(Player player) {
        return Optional.ofNullable(playerMap.get(player.getUniqueId().toString()));
    }

    public static GrassPlayer findOrCreate(Player player) {
        String uuid = player.getUniqueId().toString();

        if (!playerMap.containsKey(uuid)) {
            create(player);
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

    public int getMana() {
        return mana;
    }

    public boolean hasMana() {
        return 0 < mana;
    }

    public boolean hasOpenedAchievement(GrassAchievement achievement) {
        return achievement.isOpened(getAchievementValue(achievement));
    }

    public int getAchievementValue(GrassAchievement achievement) {
        return achievementMap.getOrDefault(achievement, 0);
    }

    public void incrementStamina(int stamina) {
        setStamina(this.stamina + stamina);
    }

    public void incrementEffectiveStamina(int effectiveStamina) {
        setEffectiveStamina(this.effectiveStamina + effectiveStamina);
    }

    public void setStamina(int stamina) {
        if (stamina < 0) {
            stamina = 0;
        }

        if (effectiveStamina < stamina) {
            stamina = effectiveStamina;
        }

        this.stamina = stamina;
        applyStaminaToFoodLevel();
    }

    public void setEffectiveStamina(int effectiveStamina) {
        if (effectiveStamina < 5) {
            effectiveStamina = 5;
        }

        if (maxStamina < effectiveStamina) {
            effectiveStamina = maxStamina;
        }

        if (effectiveStamina < stamina) {
            stamina = effectiveStamina;
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

    public void incrementMana(int mana) {
        setMana(this.mana + mana);
    }

    public void setMana(int mana) {
        if (mana < 0) {
            mana = 0;
        }

        this.mana = mana;
    }

    @Deprecated
    public void incrementAchievementValue(GrassAchievement achievement, int value) {
        setAchievementValue(achievement, getAchievementValue(achievement) + value);
    }

    @Deprecated
    public void setAchievementValue(GrassAchievement achievement, int value) {
        if (achievement.getMaxValue() < value) {
            return;
        }

        achievementMap.put(achievement, value);
    }

    public void applyStaminaToFoodLevel() {
        Player player = toPlayer();

        player.setFoodLevel((int) (20 * (float) stamina / maxStamina));
        player.setSaturation(1);
    }
}
