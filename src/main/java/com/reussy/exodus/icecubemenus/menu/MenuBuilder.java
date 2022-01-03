package com.reussy.exodus.icecubemenus.menu;

import com.reussy.exodus.icecubemenus.IceCubeMenus;
import com.reussy.exodus.icecubemenus.utility.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MenuBuilder extends GUI{
    public MenuBuilder(int inventorySize, String inventoryName) {
        super(inventorySize, inventoryName);

        final int[] slot = {10};
        ItemStack[] itemStacks = {ItemBuilder.newBuilder()
                .setMaterial(Material.valueOf("WOOL"))
                .setData(4)
                .setDisplayNamePAPI("&a%player_name%")
                .setLorePAPI(Arrays.asList("&r ", "&fLived: %player_seconds_lived%", "&7I am Yellow Wool with data!", "&r ", "&eClick me"))
                .setQuantity(1)
                .addEnchant(Enchantment.ARROW_DAMAGE, 5)
                .addItemFlag(ItemFlag.HIDE_ENCHANTS)
                .build(), ItemBuilder.newBuilder()
                .setMaterial(Material.valueOf("APPLE"))
                .setDisplayName("&dDelicious apple!")
                .setLore(Arrays.asList("&r ", "&7Eat me???"))
                .setQuantity(2)
                .build(), ItemBuilder.newBuilder()
                .setMaterial(Material.valueOf("GOLD_NUGGET"))
                .setDisplayName("&d&6Pirate Nugget!")
                .setLore(Arrays.asList("&r ", "&7Brilliant!"))
                .setQuantity(3)
                .build()};

        Arrays.stream(itemStacks).sorted(Comparator.comparingInt(ItemStack::getAmount)).forEach(itemStack -> {

            addItem(slot[0], itemStack, player -> player.playSound(player.getLocation(), Sound.valueOf("CLICK"), 1.0F, 1.0F));
            slot[0]++;
        });

        addItem(50, ItemBuilder.of(Material.HOPPER, "&6Sorted by: &aLower number", ""));
        addItem(53, ItemBuilder.of(Material.ARROW, "&aNext Page", "&7Go to page 2."));

        /*
        addItem(0, ItemBuilder.of(Material.APPLE, "&dDelicious apple!", "&7Eat me???"), player -> Bukkit.getConsoleSender().sendMessage("Hey"));

        addItem(22, ItemBuilder.newBuilder()
                .setMaterial(Material.valueOf("WOOL"))
                .setData(4)
                .setDisplayNamePAPI("&a%player_name%")
                .setLorePAPI(Arrays.asList("&r ", "&fLived: %player_seconds_lived%", "&7I am Yellow Wool with data!", "&r ", "&eClick me"))
                .setQuantity(1)
                .addEnchant(Enchantment.ARROW_DAMAGE, 5)
                .addItemFlag(ItemFlag.HIDE_ENCHANTS)
                .build(), player -> Arrays.stream(new Object[] {"Hao", "Cube", "Item", "Enchant", "Floor", "Beer", "Array", "Gershwin"})
                .sorted()
                .forEach(o -> player.sendMessage(o.toString())));
    }
             */
    }
}
