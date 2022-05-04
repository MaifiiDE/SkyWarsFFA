package de.maifii.skywarsffa.utils;

import me.wawwior.config.ConfigProvider;
import me.wawwior.config.Configurable;
import me.wawwior.config.IConfig;
import me.wawwior.config.io.impl.FileInfo;
import org.bukkit.ChatColor;

public class MessageUtils extends Configurable<MessageUtils.MessageConfig, FileInfo> {

    public static MessageConfig messages;

    public static class MessageConfig implements IConfig {

        public String prefix = code('&', "&8&l»&7» &9SkyWarsFFA &7| ");
        public String noPermission = code('&',"Dazu hast du &ckeine §7Berechtigung!");
        public String buildOn = code('&',"Du wurdest in den &9Bau Modus &7hinzugefügt.");
        public String buildOff = code('&',"Du wurdest aus den &9Bau Modus &7entfernt.");
        public String wrongInput = code('&',"&cFalsche Eingabe&7! Bitte benutze &9/");
        public String locationSet = code('&',"Du hast erfolgreich eine &9Location &7gesetzt ");

    }

    public MessageUtils(ConfigProvider<FileInfo> provider) {
        super(MessageConfig.class, FileInfo.of("/", "messages"), provider);
        messages = config;
    }

    public static String code(char c, String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
