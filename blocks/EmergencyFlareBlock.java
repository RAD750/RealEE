package it.lor54.rgb.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import it.lor54.rgb.RGBCore;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class EmergencyFlareBlock
  extends Block
{
  public static final String name = "Emergency Flare";
  
  public EmergencyFlareBlock(int par1, int texture)
  {
    super(par1, 211, Material.redstoneLight);
    setLightValue(0.0F);
    setCreativeTab(RGBCore.RealEETab);
    setBlockName("Emergency Flare");
    blockIndexInTexture = 3;
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
  
  public int getBlockTextureFromSide(int side)
  {
    if ((side == 0) || (side == 1))
    {
      return blockIndexInTexture + 7;
    }
    

    if ((side == 2) || (side == 3))
    {
      return blockIndexInTexture;
    }
    

    return blockIndexInTexture;
  }
  





  public void onBlockAdded(final World par1World, final int par2, final int par3, final int par4)
  {
    par1World.setBlock(par2, par3, par4, Blocks.emergencyFlareLit.blockID);
    
    if (!par1World.isRemote)
    {
      new Timer().schedule(new TimerTask()
      {




        public void run() {
          par1World.setBlock(par2, par3, par4, 0); } }, 30000L);
    }
  }
  








  public void onNeighborBlockChange(final World par1World, final int par2, final int par3, final int par4, int par5)
  {
    par1World.setBlock(par2, par3, par4, Blocks.emergencyFlareLit.blockID);
    
    if (!par1World.isRemote)
    {
      new Timer().schedule(new TimerTask()
      {




        public void run() {
          par1World.setBlock(par2, par3, par4, 0); } }, 30000L);
    }
  }
  



  public void onChunkLoad() {}
  



  public int quantityDropped(Random rand)
  {
    return 1;
  }
  



  public int idDropped(int par1, Random par2Random, int par3)
  {
    return Blocks.emergencyFlare.blockID;
  }
  




  @SideOnly(Side.CLIENT)
  public int idPicked(World par1World, int par2, int par3, int par4)
  {
    return Blocks.emergencyFlare.blockID;
  }
}
