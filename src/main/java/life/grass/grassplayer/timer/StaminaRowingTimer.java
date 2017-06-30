package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Boat;

public class StaminaRowingTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            GrassPlayer grassPlayer = GrassPlayer.findOrCreate(player);

            if (player.getVehicle() instanceof Boat)
                grassPlayer.incrementEffectiveStamina(Math.random() < 0.15D ? -1 : 0);
        });
    }
}
