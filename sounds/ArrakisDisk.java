package it.lor54.rgb.sounds;

import it.lor54.rgb.RGBCore;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockJukeBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ArrakisDisk
  extends ItemRecord
{
  public String recordName = "arrakis";
  public static final String name = "Inno Arrakis";
  
  public ArrakisDisk(int id)
  {
    super(id, "arrakis");
    setCreativeTab(RGBCore.OthersTab);
    maxStackSize = 1;
    iconIndex = 19;
    recordName = "arrakis";
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
  
  public String getRecordTitle()
  {
    return "C418 - " + recordName;
  }
  
  public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
  {
    if ((par3World.getBlockId(par4, par5, par6) == Block.jukebox.blockID) && (par3World.getBlockMetadata(par4, par5, par6) == 0))
    {
      if (par3World.isRemote)
      {
        return true;
      }
      

      ((BlockJukeBox)Block.jukebox).insertRecord(par3World, par4, par5, par6, par1ItemStack);
      par3World.playAuxSFXAtEntity((EntityPlayer)null, 1005, par4, par5, par6, itemID);
      par1ItemStack.stackSize -= 1;
      return true;
    }
    


    return false;
  }
  


  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
  {
    par3List.add("Inno Arrakis");
  }
}
