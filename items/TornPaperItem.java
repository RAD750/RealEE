package it.lor54.rgb.items;

import it.lor54.rgb.RGBCore;
import net.minecraft.item.Item;

public class TornPaperItem extends Item
{
  public static final String name = "Torn Paper";
  
  public TornPaperItem(int id)
  {
    super(id);
    iconIndex = 5;
    setItemName("Torn Paper");
    setCreativeTab(RGBCore.OthersTab);
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
}
