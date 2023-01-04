package me.seetaadev.colors.color;

import org.bukkit.DyeColor;

public enum Color {
    WHITE("WHITE", "&fWhite", DyeColor.WHITE.getWoolData()),
    ORANGE("ORANGE", "&6Orange", DyeColor.ORANGE.getWoolData()),
    LIGHT_BLUE("LIGHT_BLUE", "&bLight Blue", DyeColor.LIGHT_BLUE.getWoolData()),
    MAGENTA("MAGENTA", "&5Magenta", DyeColor.MAGENTA.getWoolData()),
    YELLOW("YELLOW", "&eYellow", DyeColor.YELLOW.getWoolData()),
    LIME("LIME", "&aLime", DyeColor.LIME.getWoolData()),
    PINK("PINK", "&dPink", DyeColor.PINK.getWoolData()),
    GRAY("GRAY", "&8Gray", DyeColor.GRAY.getWoolData()),
    LIGHT_GRAY("LIGHT_GRAY", "&7Light Gray", DyeColor.SILVER.getWoolData()),
    CYAN("CYAN", "&3Cyan", DyeColor.CYAN.getWoolData()),
    PURPLE("PURPLE", "&5Purple", DyeColor.PURPLE.getWoolData()),
    BLUE("BLUE", "&9Blue", DyeColor.BLUE.getWoolData()),
    BROWN("BROWN", "&4Brown", DyeColor.BROWN.getWoolData()),
    GREEN("GREEN", "&2Green", DyeColor.GREEN.getWoolData()),
    RED("RED", "&cRed", DyeColor.RED.getWoolData()),
    BLACK("BLACK", "&0Black", DyeColor.BLACK.getWoolData());

    private final String name;
    private final String displayName;
    private final Byte material;

    Color(String name, String displayName, Byte material) {
        this.name = name;
        this.displayName = displayName;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Byte getMaterial() {
        return material;
    }

    public static Color fromName(String name) {
        for (Color color : values()) {
            if (color.getName().equalsIgnoreCase(name)) {
                return color;
            }
        }
        return null;
    }
}
