package life.grass.grassplayer.achievement;

import life.grass.grassplayer.GrassPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class RightClicking implements Achievement, Listener {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isOpened(int value) {
        return 20 < value;
    }

    @Override
    public int getMaxValue() {
        return 50;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }

        switch (event.getAction()) {
            case RIGHT_CLICK_AIR:
            case RIGHT_CLICK_BLOCK:
                break;
            default:
                return;
        }

        Player player = event.getPlayer();
        GrassPlayer grassPlayer = GrassPlayer.findOrCreate(player);
        GrassAchievement achievement = GrassAchievement.fromClass(this.getClass());

        grassPlayer.incrementAchievementValue(achievement, 1);
        player.sendMessage("[Achievement] Right-Clicking: "
                + grassPlayer.getAchievementValue(achievement)
                + " " + (grassPlayer.hasOpenedAchievement(achievement) ? "[OPENED]" : "")
                + " " + (achievement.getMaxValue() == grassPlayer.getAchievementValue(achievement) ? "[MAX]" : "")
        );
    }
}
