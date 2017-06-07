/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.xeiotos.HabitatReloaded;

import java.util.LinkedList;
import java.util.List;
import org.bukkit.Bukkit;

/**
 *
 * @author Chris
 */
public class Habitat {
    private List<String> players = new LinkedList<>();
    
    public void addPlayer(String player, Habitat oldHabitat) {
        if (!players.contains(player)) {
            players.add(player);
            Bukkit.getServer().getPluginManager().callEvent(new PlayerEnterHabitatEvent(Bukkit.getPlayer(player), this, oldHabitat));
        }
    }

    public void removePlayer(String player, Habitat newHabitat) {
        if (players.contains(player)) {
            players.remove(player);
            Bukkit.getServer().getPluginManager().callEvent(new PlayerLeaveHabitatEvent(Bukkit.getPlayer(player), this, newHabitat));
        }
    }

    public List<String> getPlayers() {
        return players;
    }
}
