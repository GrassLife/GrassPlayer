package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Bukkit;

public class StaminaRunningTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            GrassPlayer grassPlayer = GrassPlayer.findOrCreate(player);

            if (player.isSprinting() && player.getVehicle() == null) {
                grassPlayer.incrementStamina(-20);
                grassPlayer.incrementEffectiveStamina(Math.random() < 0.2D ? -1 : 0);
            } else {
                grassPlayer.incrementStamina(25);
            }
        });
    }
}
