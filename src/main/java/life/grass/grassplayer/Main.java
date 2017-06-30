package life.grass.grassplayer;

import life.grass.grassplayer.listener.PlayerStatisticIncrement;
import life.grass.grassplayer.timer.StaminaExhaustingTimer;
import life.grass.grassplayer.timer.StaminaRowingTimer;
import life.grass.grassplayer.timer.StaminaRunningTimer;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        this.getServer().getPluginManager().registerEvents(new PlayerStatisticIncrement(), this);

        this.getServer().getScheduler().runTaskTimer(this, new StaminaExhaustingTimer(), 0, 10);
        this.getServer().getScheduler().runTaskTimer(this, new StaminaRowingTimer(), 0, 10);
        this.getServer().getScheduler().runTaskTimer(this, new StaminaRunningTimer(), 0, 10);
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
