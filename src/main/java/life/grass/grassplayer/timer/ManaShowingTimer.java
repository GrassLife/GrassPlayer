package life.grass.grassplayer.timer;

import life.grass.grassplayer.GrassPlayer;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class ManaShowingTimer implements Runnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().stream()
                .map(GrassPlayer::findOrCreate)
                .filter(GrassPlayer::hasMana)
                .forEach(grassPlayer -> {
                    Player player = grassPlayer.toPlayer();
                    sendActionBar(player, ChatColor.DARK_AQUA + "Mana: " + ChatColor.BOLD + grassPlayer.getMana());
                    player.getWorld().spawnParticle(Particle.SPELL_WITCH, player.getLocation().clone().add(Math.random() - 0.5, 0.5, Math.random() - 0.5), 2, 0, 0.4, 0, 0.005);
                });
    }

    private void sendActionBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, ComponentSerializer.parse("{\"text\": \"" + message + "\"}")[0]);
    }
}
