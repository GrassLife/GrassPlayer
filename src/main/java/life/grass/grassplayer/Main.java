package life.grass.grassplayer;

import life.grass.grassplayer.timer.StaminaExhaustingTimer;
import life.grass.grassplayer.timer.StaminaRunningTimer;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        this.getServer().getScheduler().runTaskTimer(this, new StaminaRunningTimer(), 0, 10);
        this.getServer().getScheduler().runTaskTimer(this, new StaminaExhaustingTimer(), 20 * 80, 20 * 80);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        instance = null;

        this.getServer().getScheduler().cancelTasks(this);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    public static Main getInstance() {
        return instance;
    }
}
