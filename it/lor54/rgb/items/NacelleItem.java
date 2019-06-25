package it.lor54.rgb.items;

import it.lor54.rgb.RGBCore;
import net.minecraft.item.Item;

public class NacelleItem extends Item
{
  public static final String name = "Wind Generator";
  
  public NacelleItem(int id)
  {
    super(id);
    iconIndex = 26;
    setItemName("Wind Generator");
    setCreativeTab(RGBCore.OthersTab);
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
}
