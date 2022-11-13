package Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import yuta.koujousen.Gametimer;


public class readyTimer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.isOp()){
            Gametimer.game= Integer.parseInt(args[0]);
            Gametimer.countdown();
        }
        return true;
    }
}
