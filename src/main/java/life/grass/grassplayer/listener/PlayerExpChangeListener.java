package life.grass.grassplayer.listener;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

/**
 * Created by ecila on 2017/09/03.
 */
public class PlayerExpChangeListener implements Listener{
    @EventHandler
    public void onLevelChange(PlayerLevelChangeEvent e) {
        GrassPlayer grassPlayer = GrassPlayer.findOrCreate(e.getPlayer());
        grassPlayer.levelUp();

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        e.getEntity().setExp(0);
        e.setKeepLevel(true);
    }
}
