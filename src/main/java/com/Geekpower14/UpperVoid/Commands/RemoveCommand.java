package com.Geekpower14.UpperVoid.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.Geekpower14.UpperVoid.UpperVoid;
import com.Geekpower14.UpperVoid.Arena.Arena;

public class RemoveCommand implements BasicCommand {

	private UpperVoid plugin;

	public RemoveCommand(UpperVoid pl) {
		plugin = pl;
	}

	@Override
	public boolean onCommand(Player player, String[] args) {

		if (UpperVoid.hasPermission(player, this.getPermission())) {

			Arena arena = null;
			if (plugin.am.exist(args[0])) {
				arena = plugin.am.getArena(args[0]);
			}
			if (arena == null) {
				player.sendMessage(ChatColor.RED
						+ "Veuillez écrire un nom d'arène correct.");
				return true;
			}

			if (args.length != 1) {
				player.sendMessage(ChatColor.RED + "Please type a number !");
				return true;
			}

			plugin.am.deleteArena(arena.getName());
			player.sendMessage(ChatColor.GREEN + "Arena supprimé avec succés.");
		} else {
			player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission.");
		}

		return true;
	}

	@Override
	public String help(Player p) {
		if (UpperVoid.hasPermission(p, this.getPermission())) {
			return "/uv remove [Arena name] - Remove an arena.";
		}
		return "";
	}

	@Override
	public String getPermission() {
		return "UpperVoid.edit";
	}

}
