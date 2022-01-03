package com.reussy.exodus.icecubemenus;

import com.reussy.exodus.icecubemenus.commands.MenuCommand;
import com.reussy.exodus.icecubemenus.listeners.MenuInteract;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class IceCubeMenus extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getPluginCommand("ice").setExecutor(new MenuCommand());
        Bukkit.getPluginManager().registerEvents(new MenuInteract(), this);

    }

    @Override
    public void onDisable() {



    }
}
