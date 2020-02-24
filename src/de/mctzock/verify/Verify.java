package de.mctzock.verify;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.mctzock.verify.commands.CommandLogin;
import de.mctzock.verify.commands.CommandLogout;
import de.mctzock.verify.commands.CommandVerify;
import de.mctzock.verify.events.EventPlayerLeave;
import de.mctzock.verify.events.EventPlayerMove;

public class Verify extends JavaPlugin{

	@Override
	public void onEnable() {
		new ConfigFiles().createFilesIfNotExists();
		getCommand("verify").setExecutor(new CommandVerify());
		getCommand("login").setExecutor(new CommandLogin());
		getCommand("logout").setExecutor(new CommandLogout());
		Bukkit.getPluginManager().registerEvents(new EventPlayerMove(), this);
		Bukkit.getPluginManager().registerEvents(new EventPlayerLeave(), this);
		super.onEnable();
	}
}
