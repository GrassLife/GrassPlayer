package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Bukkit;

public class CombatChargeTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            GrassPlayer grassPlayer = GrassPlayer.get(player);
			long c = System.currentTimeMillis();
			long l = grassPlayer.getLastRightClick();
			if((c - l) <= 200) {
//				player.sendMessage("You are right-clicking");
			} else {
//				player.sendMessage("You are NOT right-clicking");
			}
        });
    }
}
