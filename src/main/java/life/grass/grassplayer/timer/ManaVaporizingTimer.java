package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Bukkit;

public class ManaVaporizingTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().stream()
                .map(GrassPlayer::findOrCreate)
                .filter(GrassPlayer::hasMana)
                .forEach(grassPlayer -> grassPlayer.incrementMana(-1));
    }
}
