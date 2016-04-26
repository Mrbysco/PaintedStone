package mrbysco.paintedstone.client.gui;

import mrbysco.paintedstone.common.config.Config;
import mrbysco.paintedstone.common.lib.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class GuiModConfig extends GuiConfig
{
    public GuiModConfig(GuiScreen parentScreen)
    {
        super(parentScreen, new ConfigElement(Config.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.ID, false, false, Reference.NAME);
    }
}
