package de.maifii.skywarsffa.utils;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

public class MetadataUtils {

    public static MetadataValue VALUE_TRUE = new FixedMetadataValue(SkyWarsFFA.getInstance(), true);
    public static MetadataValue VALUE_FALSE = new FixedMetadataValue(SkyWarsFFA.getInstance(), false);

}
