package life.grass.grassplayer;

import life.grass.grassplayer.timer.StaminaTimer;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        this.getServer().getScheduler().runTaskTimer(this, new StaminaTimer(), 0, 10);
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
