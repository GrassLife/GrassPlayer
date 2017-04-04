package life.grass.grassplayer.achievement;

import life.grass.grassplayer.Main;
import org.bukkit.event.Listener;

public enum GrassAchievement {
    RIGHT_CLICKING(RightClicking.class);

    private Achievement achievement;

    GrassAchievement(Class<? extends Achievement> clazz) {
        System.out.println("test");
        try {
            this.achievement = clazz.newInstance();

            if (Listener.class.isAssignableFrom(clazz)) {
                Main instance = Main.getInstance();
                instance.getServer().getPluginManager().registerEvents(((Class<? extends Listener>) clazz).newInstance(), instance);
                System.out.println("listener");
            }
            System.out.println("loaded");
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
