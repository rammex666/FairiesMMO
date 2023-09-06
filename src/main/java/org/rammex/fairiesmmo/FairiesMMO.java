package org.rammex.fairiesmmo;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.rammex.fairiesmmo.commands.fMain;
import org.rammex.fairiesmmo.events.PlayerJoin;

import java.io.File;
import java.io.IOException;

public final class FairiesMMO extends JavaPlugin {

    private FileConfiguration config;

    private FileConfiguration classdata;

    private File configFile;

    @Override
    public void onEnable() {
        message();
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);
        this.getCommand("fmain").setExecutor(new fMain(this));
        RefreshScoarBoard();
        ymlfiles();

    }

    @Override
    public void onDisable() {
        message();
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void message(){
        getLogger().info("-----------------------------------------");
        getLogger().info("");
        getLogger().info("FairiesMMO 1.0");
        getLogger().info("");
        getLogger().info("Plugin par .rammex");
        getLogger().info("");
        getLogger().info("");
        getLogger().info("-----------------------------------------");
    }

    public void RefreshScoarBoard(){
        new BukkitRunnable() {

            @Override
            public void run() {

                for(Player player : Bukkit.getOnlinePlayers()) {
                    PlayerJoin.updateScoreboard(player);
                }

            }

        }.runTaskTimer(this, 20L, 20L);
    }

    public void ymlfiles(){
        configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }
        config = YamlConfiguration.loadConfiguration(configFile);
        File dataFolder = new File(getDataFolder(), "data");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        File schematicFile = new File(dataFolder, "class.yml");
        if(!schematicFile.exists()){
            saveResource("data/class.yml", false);
        }
        classdata = YamlConfiguration.loadConfiguration(schematicFile);
    }

    public FileConfiguration getConfigg(){
        return config;
    }
    public FileConfiguration getClassData(){
        return classdata;
    }

    public FileConfiguration getSave(){
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
