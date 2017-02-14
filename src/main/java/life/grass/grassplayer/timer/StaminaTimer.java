package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Bukkit;

public class StaminaTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            GrassPlayer grassPlayer = GrassPlayer.get(player);

            grassPlayer.setStamina(grassPlayer.getStamina() + 5 * (player.isSprinting() ? -1 : 1));
            player.setFoodLevel((int) (20 * (float) grassPlayer.getStamina() / grassPlayer.getEffectiveStamina()));
        });
    }
}
