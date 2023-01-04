package me.seetaadev.colors.commands;

import com.meteoritepvp.api.MeteoritePlugin;
import com.meteoritepvp.api.command.Command;
import com.meteoritepvp.api.command.CommandClass;
import com.meteoritepvp.api.command.DefaultCommand;
import com.meteoritepvp.api.inventory.MeteoriteInventory;
import com.meteoritepvp.api.inventory.presets.BasicInventory;
import com.meteoritepvp.api.utils.CC;
import com.meteoritepvp.api.utils.Message;
import me.seetaadev.colors.Cache;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@DefaultCommand
@Command(name = "colors", description = "Opens the colors menu")
public class MainCommand implements CommandClass {

    @Command(name = "", description = "Main command for Colors")
    public void colorsCommand(CommandSender sender, MeteoritePlugin plugin, Player player, String[] params) {
        MeteoriteInventory inventory = new MeteoriteInventory(plugin, CC.RED + CC.BOLD + "Colors", 9, 6, false);

        BasicInventory basicInventory = new BasicInventory();


        if(Cache.getColors().isEmpty()) {
            sender.sendMessage(Message.fromMainConfig(plugin, "messages.no-colors", player));
            return;
        }

        for(int i = 0; i < Cache.getColors().size(); i++) {
            basicInventory.setItem(i, Cache.getColors().get(i));
        }
        basicInventory.update();
        inventory.applyPage(basicInventory);

        if(player != null) inventory.show(player);
    }

    @Command(args = "add", description = "Add a color to the list")
    public void addColor(CommandSender sender, String[] params, MeteoritePlugin plugin) {
        Player player = (Player) sender;
        if(params.length == 0) {
            sender.sendMessage(Message.fromMainConfig(plugin, "message.specify-color", player));
            return;
        }

        Cache cache = Cache.getCache(params[0].toUpperCase());
        if(cache.addToMap()) {
            sender.sendMessage(Message.fromMainConfig(plugin, "message.success-add", player).replace("%color%", params[0]));
        } else {
            sender.sendMessage(Message.fromMainConfig(plugin, "message.error-already-exists", player));
        }
    }

    @Command(args = "remove", description = "Remove a color from the list", params = "@colors")
    public void removeColor(CommandSender sender, String[] params, MeteoritePlugin plugin) {
        Player player = (Player) sender;
        if(params.length == 0) {
            sender.sendMessage(Message.fromMainConfig(plugin, "message.specify-color", player));
            return;
        }

        Cache cache = Cache.getCache(params[0].toUpperCase());
        if(cache.removeFromMap()) {
            sender.sendMessage(Message.fromMainConfig(plugin, "message.success-remove", player).replace("%color%", params[0]));
        } else {
            sender.sendMessage(Message.fromMainConfig(plugin, "message.error-doesnt-exist", player));
        }
    }


}
