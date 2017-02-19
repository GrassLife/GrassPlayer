package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Bukkit;

public class StaminaTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            GrassPlayer grassPlayer = GrassPlayer.findOrCreate(player);

            grassPlayer.incrementStamina(5 * (player.isSprinting() ? -1 : 1));
        });
    }
}
