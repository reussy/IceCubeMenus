package com.reussy.exodus.icecubemenus.commands;

import com.reussy.exodus.icecubemenus.menu.MenuBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand implements CommandExecutor {
    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("ice")){

            if (args.length == 0) {
                MenuBuilder menuBuilder;
                menuBuilder = new MenuBuilder(54, "Ice Cube");
                menuBuilder.openGUI(player);
            }
        }

        return false;
    }
}
