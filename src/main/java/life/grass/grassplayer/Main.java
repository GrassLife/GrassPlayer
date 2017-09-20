package life.grass.grassplayer;

import life.grass.grassplayer.listener.PlayerExpChangeListener;
import life.grass.grassplayer.listener.PlayerStatisticIncrement;
import life.grass.grassplayer.timer.*;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Arrays;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        this.getServer().getPluginManager().registerEvents(new PlayerStatisticIncrement(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerExpChangeListener(), this);

        registerSchedulers();

        getCommand("profile").setExecutor(new PlayerCommandExecutor());
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

        scheduler.runTaskTimer(this, new ManaShowingTimer(), 0, 4);
        scheduler.runTaskTimer(this, new ManaVaporizingTimer(), 0, 30);
        scheduler.runTaskTimer(this, new StaminaExhaustingTimer(), 0, 10);
        scheduler.runTaskTimer(this, new StaminaRowingTimer(), 0, 10);
        scheduler.runTaskTimer(this, new StaminaRunningTimer(), 0, 10);
    }
}
