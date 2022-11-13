package yuta.koujousen.Listener;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;
import yuta.koujousen.Koujousen;

public class Startitem implements Listener {
    @EventHandler
    public static void playerrespawn(PlayerRespawnEvent e) {
        BukkitRunnable task = new BukkitRunnable() {
            public void run() {
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                ItemStack sword = new ItemStack(Material.WOODEN_SWORD, 1);
                ItemStack axe = new ItemStack(Material.WOODEN_AXE, 1);
                ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE, 1);
                ItemStack shovel = new ItemStack(Material.WOODEN_SHOVEL, 1);
                ItemStack bow = new ItemStack(Material.BOW, 1);
                ItemStack bread = new ItemStack(Material.BREAD, 64);
                ItemStack rottenflesh = new ItemStack(Material.ROTTEN_FLESH, 64);
                LeatherArmorMeta meta = (LeatherArmorMeta) helmet.getItemMeta();
                ItemMeta meta1 = axe.getItemMeta();
                if (e.getPlayer().getScoreboard().getPlayerTeam(e.getPlayer()).getName().equals("blue")) {
                    meta.setColor(Color.BLUE);
                }

                if (e.getPlayer().getScoreboard().getPlayerTeam(e.getPlayer()).getName().equals("red")) {
                    meta.setColor(Color.RED);
                }

                meta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
                meta1.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                helmet.setItemMeta(meta);
                leggings.setItemMeta(meta);
                boots.setItemMeta(meta);
                chestplate.setItemMeta(meta);
                bread.setItemMeta(meta1);
                sword.setItemMeta(meta1);
                axe.setItemMeta(meta1);
                pickaxe.setItemMeta(meta1);
                shovel.setItemMeta(meta1);
                bow.setItemMeta(meta1);
                e.getPlayer().getInventory().addItem(new ItemStack(Material.OAK_LOG, 64));
                e.getPlayer().getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
                e.getPlayer().getInventory().addItem(new ItemStack(Material.GLASS, 64));
                if (e.getPlayer().getName().equals(".ninkenlex1128")) {
                    e.getPlayer().getInventory().addItem(rottenflesh);
                } else {
                    e.getPlayer().getInventory().addItem(bread);
                }

                e.getPlayer().getInventory().addItem(new ItemStack(Material.ARROW, 16));
                e.getPlayer().getInventory().addItem(sword);
                e.getPlayer().getInventory().addItem(axe);
                e.getPlayer().getInventory().addItem(pickaxe);
                e.getPlayer().getInventory().addItem(shovel);
                e.getPlayer().getInventory().addItem(bow);
                e.getPlayer().getInventory().setHelmet(helmet);
                e.getPlayer().getInventory().setLeggings(leggings);
                e.getPlayer().getInventory().setBoots(boots);
                e.getPlayer().getInventory().setChestplate(chestplate);
                this.cancel();
            }
        };
        task.runTaskTimer(Koujousen.getPlugin(), 20L, 20L);
    }
}
