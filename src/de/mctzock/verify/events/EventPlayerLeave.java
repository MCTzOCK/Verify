package de.mctzock.verify.events;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.mctzock.verify.Vars;

public class EventPlayerLeave implements Listener{
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e)
	{
		Vars.verified.remove(e.getPlayer().getName());
	}
}
