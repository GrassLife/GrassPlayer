package life.grass.grassplayer.achievement;

import java.util.Arrays;

public enum GrassAchievement {
    RIGHT_CLICKING(RightClicking.class);

    private Achievement achievement;

    GrassAchievement(Class<? extends Achievement> clazz) {
        /* under developing

        try {
            this.achievement = clazz.newInstance();

            if (Listener.class.isAssignableFrom(clazz)) {
                Main instance = Main.getInstance();
                instance.getServer().getPluginManager().registerEvents((Listener) achievement, instance);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        */
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

    static GrassAchievement fromClass(Class<? extends Achievement> clazz) {
        return Arrays.stream(GrassAchievement.values())
                .filter(enumerator -> enumerator.getAchievement().getClass().equals(clazz))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private Achievement getAchievement() {
        return this.achievement;
    }
}
