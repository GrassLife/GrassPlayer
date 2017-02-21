package life.grass.grassplayer;

import life.grass.grassplayer.listener.CombatChargeListener;
import life.grass.grassplayer.timer.CombatChargeTimer;
import life.grass.grassplayer.timer.StaminaTimer;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        this.getServer().getScheduler().runTaskTimer(this, new StaminaTimer(), 0, 10);
		this.getServer().getScheduler().runTaskTimer(this, new CombatChargeTimer(), 0, 4);
		this.getServer().getPluginManager().registerEvents(new CombatChargeListener(), this);
	}
	
    @Override
    public void onDisable() {
        super.onDisable();

        this.getServer().getScheduler().cancelTasks(this);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }
}
