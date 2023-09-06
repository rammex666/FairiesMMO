package org.rammex.fairiesmmo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.fairiesmmo.FairiesMMO;
import org.rammex.fairiesmmo.ui.fmain;

public class fMain implements CommandExecutor {

    FairiesMMO plugin;

    public fMain(FairiesMMO plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender Sender, Command cmd, String arg0, String[] args) {
        Player player = (Player) Sender;
        if(hasclass(player)) {
            fmain.getfmainui(player);
        }
        return false;
    }


    private boolean hasclass(Player player) {
        return !"none".equals(this.plugin.getConfigg().getString("players." + player.getName() + ".class"));
    }
}
