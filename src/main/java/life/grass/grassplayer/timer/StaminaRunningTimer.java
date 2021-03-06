package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Bukkit;

public class StaminaRunningTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            GrassPlayer grassPlayer = GrassPlayer.findOrCreate(player);

            if (player.isSprinting() && player.getVehicle() == null) {
                grassPlayer.incrementStamina(-10);
                grassPlayer.incrementEffectiveStamina(Math.random() < 0.3D ? -1 : 0);
            }
        });
    }
}
