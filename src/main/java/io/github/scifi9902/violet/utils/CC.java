package io.github.scifi9902.violet.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class CC {

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
