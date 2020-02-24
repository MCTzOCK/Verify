package de.mctzock.verify.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.mctzock.verify.ConfigFiles;
import de.mctzock.verify.Vars;

public class CommandVerify implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{
			Player p = (Player) sender;
			if(args.length == 1)
			{
				if(!Vars.verified.contains(sender.getName()))
				{
					try {
						if(new ConfigFiles().read(p.getName()).equals("") || new ConfigFiles().read(p.getName()).equals(null))
						{
							new ConfigFiles().write(p.getName(), args[0]);
							Vars.verified.add(p.getName());
							p.sendMessage("[§5Verify§r] Du bist nun verifiziert!");
						}else
						{
							p.sendMessage("[§5Verify§r] Du bist bereits verifiziert!");
						}
					} catch (IOException e) {
						p.sendMessage("[§5Verify§r] §cEin Fehler ist aufgetreten: " + e.getStackTrace());
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else
				{
					try {
						
					} catch (Exception e) {
						p.sendMessage("[§5Verify§r] §cEin Fehler ist aufgetreten: " + e.getStackTrace());
						e.printStackTrace();
					}
					p.sendMessage("[§5Verify§r] Du bist bereits verifiziert!");
				}
			}else
			{
				p.sendMessage("[§5Verify§r] Du musst ein Passwort angeben!");
			}
		}else
		{
			sender.sendMessage("[§5Verify§r] Du musst ein Spieler sein!");
		}
		return true;
	}
}
