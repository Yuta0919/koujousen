package yuta.koujousen.Listener;

import org.bukkit.*;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import yuta.koujousen.Koujousen;

public class Coreset implements Listener {
    @EventHandler
    public void blockbreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.RED_WOOL) {
            if (e.getPlayer().getScoreboard().getPlayerTeam(e.getPlayer()).getName().equals("red")) {
                e.setCancelled(true);
            } else {
                if (Koujousen.redcount == 1) {
                    Firework f = e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = f.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.PURPLE).withColor(Color.GREEN).with(FireworkEffect.Type.BALL_LARGE).withFlicker().build());
                    data.setPower(1);
                    f.setFireworkMeta(data);
                    Bukkit.getOnlinePlayers().forEach((player) -> {
                        player.sendTitle(ChatColor.BLUE + "BlUE WIN", "");
                    });
                }
                Bukkit.broadcastMessage(ChatColor.RED + e.getPlayer().getName() + "が赤のコアを破壊しました");
                Bukkit.getOnlinePlayers().forEach((player) -> {
                    Location loc = player.getLocation();
                    loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_HARP, 1.0F, 10.0F);
                });
                e.setDropItems(false);
                Koujousen.redcount--;
                Koujousen.rednumber.setScore(Koujousen.redcount);
            }
        }

        if (e.getBlock().getType() == Material.BLUE_WOOL) {
            if (e.getPlayer().getScoreboard().getPlayerTeam(e.getPlayer()).getName().equals("blue")) {
                e.setCancelled(true);
            } else {
                if (Koujousen.bluecount == 1) {
                    Firework f = e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = f.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.PURPLE).withColor(Color.GREEN).with(FireworkEffect.Type.BALL_LARGE).withFlicker().build());
                    data.setPower(1);
                    f.setFireworkMeta(data);
                    Bukkit.getOnlinePlayers().forEach((player) -> {
                        player.sendTitle(ChatColor.RED + "RED WIN", "");
                    });
                }
                Bukkit.broadcastMessage(ChatColor.AQUA + e.getPlayer().getName() + "が青のコアを破壊しました");
                Bukkit.getOnlinePlayers().forEach((player) -> {
                    Location loc = player.getLocation();
                    loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_HARP, 1.0F, 10.0F);
                });
                e.setDropItems(false);
                Koujousen.bluecount--;
                Koujousen.bluenumber.setScore(Koujousen.bluecount);
            }
        }
    }

    @EventHandler
    public void blockplace(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.RED_WOOL) {
            Koujousen.redcount++;
            Koujousen.rednumber.setScore(Koujousen.redcount);
        }
        if (e.getBlock().getType() == Material.BLUE_WOOL) {
            Koujousen.bluecount++;
            Koujousen.bluenumber.setScore(Koujousen.bluecount);
        }
    }
}
