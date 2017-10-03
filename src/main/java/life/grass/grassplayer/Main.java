package life.grass.grassplayer;

import life.grass.grassplayer.listener.PlayerStatisticIncrement;
import life.grass.grassplayer.timer.StaminaExhaustingTimer;
import life.grass.grassplayer.timer.StaminaRecoveringTimer;
import life.grass.grassplayer.timer.StaminaRowingTimer;
import life.grass.grassplayer.timer.StaminaRunningTimer;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        this.getServer().getPluginManager().registerEvents(new PlayerStatisticIncrement(), this);

        registerSchedulers();
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

    private void registerSchedulers() {
        BukkitScheduler scheduler = this.getServer().getScheduler();

        scheduler.runTaskTimer(this, new StaminaExhaustingTimer(), 0, 10);
        scheduler.runTaskTimer(this, new StaminaRecoveringTimer(), 0, 10);
        scheduler.runTaskTimer(this, new StaminaRowingTimer(), 0, 10);
        scheduler.runTaskTimer(this, new StaminaRunningTimer(), 0, 10);
    }
}
