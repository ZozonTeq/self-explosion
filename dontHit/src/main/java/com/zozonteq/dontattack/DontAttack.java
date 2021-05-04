package com.zozonteq.dontattack;
import org.bukkit.World;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.*;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DontAttack extends JavaPlugin implements Listener {
    public JavaPlugin plugin;
    public static int power = 3;
    public static boolean useFire = false;
    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(this,this);
        getCommand("dontattack").setExecutor(new com.zozonteq.dontattack.commands.DontAttack());
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
    @EventHandler
    public void onAttack(org.bukkit.event.entity.EntityDamageByEntityEvent e){
        Entity damager = e.getDamager();
        Entity entity = e.getEntity();
        if(damager.getType()== EntityType.PLAYER){
            World w = damager.getWorld();
            w.createExplosion(damager.getLocation(),power,useFire);
        }
    }
}
