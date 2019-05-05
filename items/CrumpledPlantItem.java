package it.lor54.rgb.items;

import it.lor54.rgb.RGBCore;
import net.minecraft.item.Item;

public class CrumpledPlantItem extends Item
{
  public static final String name = "Crumpled Plant";
  
  public CrumpledPlantItem(int id)
  {
    super(id);
    iconIndex = 6;
    setItemName("Crumpled Plant");
    setCreativeTab(RGBCore.OthersTab);
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
}
