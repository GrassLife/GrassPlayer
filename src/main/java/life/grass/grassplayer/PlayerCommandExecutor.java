package life.grass.grassplayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by ecila on 2017/09/21.
 */
public class PlayerCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("PROFILE")) {
            System.out.printf("TESTTTTTTTTT");
            return true;
        }
        return false;
    }
}
