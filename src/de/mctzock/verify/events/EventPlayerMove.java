package de.mctzock.verify.events;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.mctzock.verify.Vars;

public class EventPlayerMove implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent e)
	{
		if(!Vars.verified.contains(e.getPlayer().getName()))
		{
			e.setCancelled(true);
			e.getPlayer().sendMessage("[§5Verify§r] Du musst dich zuerst verifizieren! /verify <password>");
			e.getPlayer().sendMessage("[§5Verify§r] Oder logge dich ein! /login <password>");
		}
	}
}
