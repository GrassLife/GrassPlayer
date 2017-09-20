package life.grass.grassplayer.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

/**
 * Created by ecila on 2017/09/03.
 */
public class PlayerExpChangeListener implements Listener{
//    @EventHandler
//    public void onLevelChange(PlayerLevelChangeEvent e) {
//        いずれここで色々記録されることになるだろう
//    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        e.setKeepLevel(true);
    }
}
