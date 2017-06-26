package life.grass.grassplayer.listener;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class PlayerStatisticIncrement implements Listener {

    @EventHandler
    public void onPlayerStatisticIncrement(PlayerStatisticIncrementEvent event) {
        Player player = event.getPlayer();

        if (event.getStatistic() == Statistic.JUMP) GrassPlayer.findOrCreate(player).incrementEffectiveStamina(-1);
    }
}
