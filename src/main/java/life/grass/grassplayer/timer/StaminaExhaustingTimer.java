package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Bukkit;

public class StaminaExhaustingTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player ->
            GrassPlayer.findOrCreate(player).incrementEffectiveStamina(-5)
        );
    }
}