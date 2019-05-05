package it.lor54.rgb.items;

import it.lor54.rgb.RGBCore;
import it.lor54.rgb.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WindmillGroundItem extends Item
{
  public static final String name = "Wind Turbine Baseplate";
  
  public WindmillGroundItem(int id)
  {
    super(id);
    maxStackSize = 1;
    setItemName("Wind Turbine Baseplate");
    setCreativeTab(RGBCore.OthersTab);
    iconIndex = 24;
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
  
  public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2)
  {
    if (!world.isRemote)
    {
      if (!player.capabilities.isCreativeMode)
      {
        itemstack.stackSize -= 1;
      }
      
      int yaw = (int)player.rotationYaw;
      
      if (yaw < 0)
        yaw += 360;
      yaw += 22;
      yaw %= 360;
      int facing = yaw / 45;
      
      world.setBlockAndMetadataWithNotify(x, y + 1, z, Blocks.blockWindmillGround.blockID, facing / 2);
      return true;
    }
    return false;
  }
}
