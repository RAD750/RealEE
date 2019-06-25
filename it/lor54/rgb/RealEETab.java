package it.lor54.rgb;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import it.lor54.rgb.blocks.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RealEETab extends CreativeTabs
{
  public RealEETab(int par1, String par2Str)
  {
    super(par1, par2Str);
  }
  

  @SideOnly(Side.CLIENT)
  public ItemStack getIconItemStack()
  {
    return new ItemStack(Blocks.emergencyFlareLit.blockID, 1, 0);
  }
  
  public String getTranslatedTabLabel()
  {
    return "RealEE Electronic Objects";
  }
}
