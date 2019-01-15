package it.lor54.rgb.items;

import it.lor54.rgb.RGBCore;
import net.minecraft.item.Item;

public class PaloItem extends Item
{
    public static final String name = "Wind Turbine Tower";

    public PaloItem(int id)
    {
        super(id);
        this.iconIndex = 28;
        this.setItemName(name);
        this.setCreativeTab(RGBCore.OthersTab);
    }

    public String getTextureFile()
    {
        return "/rgbmod/rgb.png";
    }
}