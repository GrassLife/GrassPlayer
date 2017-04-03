package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Bukkit;

public class StaminaTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player ->
                GrassPlayer.findOrCreate(player).incrementStamina(5 * (player.isSprinting() ? -1 : 1))
        );
    }
}
