package life.grass.grassplayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by ecila on 2017/09/21.
 */
public class PlayerCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("PROFILE")) {
            Player player = (Player) sender;
            GrassPlayer grassPlayer = GrassPlayer.findOrCreate(player);

            player.sendMessage("-----" + player.getDisplayName() + "-----");
            player.sendMessage("Level: " + player.getLevel());
            player.sendMessage("Stamina: " + grassPlayer.getStamina() + "/" + grassPlayer.getEffectiveStamina() + "/" + grassPlayer.getMaxStamina());
            for (StatusType status : StatusType.values()) {
                player.sendMessage(status.getLabel() + ": " + grassPlayer.getRawStatus(status));
            }
            player.sendMessage(" ");

            return true;
        } else if (command.getName().equalsIgnoreCase("PLAYER")) {
            if (args[0].equalsIgnoreCase("RECOVER")) {
                GrassPlayer grassPlayer = GrassPlayer.findOrCreate((Player) sender);
                grassPlayer.setEffectiveStamina(grassPlayer.getMaxStamina());
                sender.sendMessage("Recovered");
                return true;
            } else if (args[0].equalsIgnoreCase("SETLEVEL")) {
                GrassPlayer grassPlayer = GrassPlayer.findOrCreate((Player) sender);
                grassPlayer.forceSettingLevel(Integer.parseInt(args[1]));
                sender.sendMessage("Force setting level");
                return true;
            }
        }
        return false;
    }
}
