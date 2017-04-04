package life.grass.grassplayer.achievement;

import life.grass.grassplayer.Main;
import org.bukkit.event.Listener;

public enum GrassAchievement {
    RIGHT_CLICKING(RightClicking.class);

    private Achievement achievement;

    GrassAchievement(Class<? extends Achievement> clazz) {
        try {
            this.achievement = clazz.newInstance();

            if (Listener.class.isAssignableFrom(clazz)) {
                Main instance = Main.getInstance();
                instance.getServer().getPluginManager().registerEvents((Listener) achievement, instance);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getName() {
        return achievement.getName();
    }

    public int getMaxValue() {
        return achievement.getMaxValue();
    }

    public boolean isOpened(int value) {
        return achievement.isOpened(value);
    }
}
