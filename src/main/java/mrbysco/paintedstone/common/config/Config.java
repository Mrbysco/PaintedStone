package mrbysco.paintedstone.common.config;

import java.io.File;

import mrbysco.paintedstone.common.lib.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config
{
    public static Configuration config;

    public static boolean coloredStone;
    public static boolean coloredCobble;
    public static boolean coloredMossCobble;
    public static boolean coloredStoneBrick;
    public static boolean coloredMossStoneBrick;
    public static boolean coloredCrackedBrick;
    public static boolean coloredStoneRoad;
    public static boolean coloredStoneFancyBrick;
    public static boolean coloredStoneSquareBrick;

    public static void init(File configFile)
    {
        if (config == null)
        {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        coloredStone = config.get(Configuration.CATEGORY_GENERAL, "Colored Stone", true).getBoolean(true);
        coloredCobble = config.get(Configuration.CATEGORY_GENERAL, "Colored Cobblestone", true).getBoolean(true);
        coloredMossCobble = config.get(Configuration.CATEGORY_GENERAL, "Colored Mossy Cobble", true).getBoolean(true);
        coloredStoneBrick = config.get(Configuration.CATEGORY_GENERAL, "Colored Stone Brick", true).getBoolean(true);
        coloredMossStoneBrick = config.get(Configuration.CATEGORY_GENERAL, "Colored Mossy Stone Brick", true).getBoolean(true);
        coloredCrackedBrick = config.get(Configuration.CATEGORY_GENERAL, "Colored Cracked Stone Brick", true).getBoolean(true);
        coloredStoneRoad = config.get(Configuration.CATEGORY_GENERAL, "Colored Stone Road", true).getBoolean(true);
        coloredStoneFancyBrick = config.get(Configuration.CATEGORY_GENERAL, "Colored Fancy Stone Brick", true).getBoolean(true);
        coloredStoneSquareBrick = config.get(Configuration.CATEGORY_GENERAL, "Colored Chiseled Stone Brick", true).getBoolean(true);

        if (config.hasChanged())
            config.save();
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equalsIgnoreCase(Reference.ID))
            loadConfiguration();
    }
}
