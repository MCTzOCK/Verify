package de.mctzock.verify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.mctzock.verify.ConfigFiles;
import de.mctzock.verify.Vars;

public class CommandLogin implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{
			if(!Vars.verified.contains(sender.getName()))
			{
				if(args.length == 1)
				{
					try {
						if(new ConfigFiles().read(sender.getName()).equals(args[0]))
						{
							Vars.verified.remove(sender.getName());
							Vars.verified.add(sender.getName());
							sender.sendMessage("[§5Verify§r] Du bist nun eingeloggt!");
						}else
						{
							sender.sendMessage("[§5Verify§r] Falsches Passwort!");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else
				{
					sender.sendMessage("[§5Verify§r] /login <password> oder /verify <password>");
				}
			}else
			{
				sender.sendMessage("[§5Verify§r] Du bist bereits eingeloggt!");
			}
		}else
		{
			sender.sendMessage("[§5Verify§r] Du musst ein Spieler sein!");
		}
		return true;
	}
}
