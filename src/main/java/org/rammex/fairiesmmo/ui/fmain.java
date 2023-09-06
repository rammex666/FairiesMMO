package org.rammex.fairiesmmo.ui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class fmain {

    public static void getfmainui(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "          Menu Principale");


        // Items
        inv.setItem(20, getItem(Material.PAPER, "Informations"));
        inv.setItem(21, getItem(Material.PAPER, "Bank"));
        inv.setItem(22, getItem(Material.PAPER, "HDV"));
        inv.setItem(23, getItem(Material.PAPER, "Challenges"));
        inv.setItem(24, getItem(Material.PAPER, "Challenges"));
        inv.setItem(29, getItem(Material.PAPER, "IS Warps"));
        inv.setItem(30, getItem(Material.PAPER, "Régénération"));
        inv.setItem(31, getItem(Material.PAPER, "Boutique"));
        inv.setItem(32, getItem(Material.PAPER, "Settings"));
        inv.setItem(33, getItem(Material.PAPER, "Settings"));




        // décors haut
        inv.setItem(0, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(1, getItem(Material.RED_STAINED_GLASS_PANE, ""));
        inv.setItem(2, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(3, getItem(Material.RED_STAINED_GLASS_PANE, ""));
        inv.setItem(4, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(5, getItem(Material.RED_STAINED_GLASS_PANE, ""));
        inv.setItem(6, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(7, getItem(Material.RED_STAINED_GLASS_PANE, ""));
        inv.setItem(8, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));

        // décors bas
        inv.setItem(45, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(46, getItem(Material.RED_STAINED_GLASS_PANE, ""));
        inv.setItem(47, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(48, getItem(Material.RED_STAINED_GLASS_PANE, ""));
        inv.setItem(49, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(50, getItem(Material.RED_STAINED_GLASS_PANE, ""));
        inv.setItem(51, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(52, getItem(Material.RED_STAINED_GLASS_PANE, ""));
        inv.setItem(53, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));

        // décors gauche
        inv.setItem(9, getItem(Material.RED_STAINED_GLASS_PANE, ""));
        inv.setItem(18, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(27, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(36, getItem(Material.RED_STAINED_GLASS_PANE, ""));

        // décors droite
        inv.setItem(17, getItem(Material.RED_STAINED_GLASS_PANE, ""));
        inv.setItem(26, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(35, getItem(Material.WHITE_STAINED_GLASS_PANE, ""));
        inv.setItem(44, getItem(Material.RED_STAINED_GLASS_PANE, ""));

        player.openInventory(inv);

    }



    public static ItemStack getItem(Material material, String customName) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        it.setItemMeta(customM);
        return it;
    }
}
