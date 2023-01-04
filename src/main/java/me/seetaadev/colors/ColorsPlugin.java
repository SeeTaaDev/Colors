package me.seetaadev.colors;

import com.meteoritepvp.api.MeteoritePlugin;
import me.seetaadev.colors.commands.MainCommand;

import java.util.List;

public class ColorsPlugin extends MeteoritePlugin {

    @Override
    protected void onRegisterMainCommand(String description) { }


    @Override
    protected void onRegisterCommands(String... aliases) {
        super.onRegisterCommands("c", "colors");
    }

    @Override
    protected void onInit() {
        super.onInit();

        registerCommandClass(MainCommand.class);
    }

    @Override
    public void onEnable() {
        super.onEnable();

        saveDefaultConfig();
        reloadConfig();

        registerPlaceholderParameter("colors", (sender -> getColors()));
    }

    public List<String> getColors() {
        return Cache.getNames();
    }
}
