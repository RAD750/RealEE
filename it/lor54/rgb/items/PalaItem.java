package it.lor54.rgb.items;

import it.lor54.rgb.RGBCore;
import net.minecraft.item.Item;

public class PalaItem extends Item
{
  public static final String name = "Wind Turbine Blades";
  
  public PalaItem(int id)
  {
    super(id);
    iconIndex = 27;
    setItemName("Wind Turbine Blades");
    setCreativeTab(RGBCore.OthersTab);
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
}
