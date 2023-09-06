package org.rammex.fairiesmmo.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.rammex.fairiesmmo.FairiesMMO;
import org.rammex.fairiesmmo.tools.ScoreHelper;

public class PlayerJoin implements Listener {

    FairiesMMO plugin;



    public PlayerJoin(FairiesMMO plugin) {
        this.plugin = plugin;
    }


    private void createScoreboard(Player player) {
        ScoreHelper helper = ScoreHelper.createScore(player);
        helper.setTitle("&aFairiesMMO");
        helper.setSlot(5, "&7&m--------------------------------");
        helper.setSlot(4, "&aPlayer&f: " + player.getName());
        helper.setSlot(3, "&aLocation&f: " + getLocation(player));
        helper.setSlot(2, "&aClass&f: "+this.plugin.getClassData().getString("players."+player.getName()+".class"));
        helper.setSlot(1, "&7&m--------------------------------");
    }

    public static void updateScoreboard(Player player) {
        if(ScoreHelper.hasScore(player)) {
            ScoreHelper helper = ScoreHelper.getByPlayer(player);
            helper.setSlot(3, "&aLocation&f: " + getLocation(player));

        }
    }

    private static String getLocation(Player player) {
        Location l = player.getLocation();
        return l.getBlockX() + ", " + l.getBlockY() + ", " + l.getBlockZ();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        createScoreboard(player);

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(ScoreHelper.hasScore(player)) {
            ScoreHelper.removeScore(player);
        }
    }



}
