package com.zozonteq.dontattack.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DontAttack implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args[0].equalsIgnoreCase("set")){

            if(args[1].equalsIgnoreCase("power")){
                com.zozonteq.dontattack.DontAttack.power =Integer.parseInt(args[2]);
                sender.sendMessage("パワーが変更されました。");
            }
            else if(args[1].equalsIgnoreCase("usefire")){
                if(args[2]=="true"||args[2]=="enable"){
                    com.zozonteq.dontattack.DontAttack.useFire = true;
                    sender.sendMessage("爆発時に火を発生します。");
                }
                else if(args[2]=="false"||args[2]=="disable"){
                    com.zozonteq.dontattack.DontAttack.useFire = false;
                    sender.sendMessage("爆発時に火を発生しません。");
                }
            }
        }
        else{
            sender.sendMessage("set power [value]");
            sender.sendMessage("set usefire [boolean]");
        }
        return true;
    }
}
