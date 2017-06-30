package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Bukkit;

public class StaminaRunningTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            GrassPlayer grassPlayer = GrassPlayer.findOrCreate(player);

            if (player.isSprinting()) {
                grassPlayer.incrementStamina(-5);
                grassPlayer.incrementEffectiveStamina(Math.random() < 0.3D ? -1 : 0);
            } else {
                grassPlayer.incrementStamina(5);
            }
        });
    }
}
