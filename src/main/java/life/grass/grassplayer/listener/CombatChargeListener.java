package life.grass.grassplayer.listener;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CombatChargeListener implements Listener{
	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			GrassPlayer player = GrassPlayer.get(e.getPlayer());
			player.setLastRightClick(System.currentTimeMillis());
		}
	}
}
