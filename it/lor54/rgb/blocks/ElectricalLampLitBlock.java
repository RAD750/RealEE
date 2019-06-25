package it.lor54.rgb.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import it.lor54.rgb.RGBCore;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class ElectricalLampLitBlock
  extends Block
{
  public static final String name = "Electrical Lamp Lit";
  
  public ElectricalLampLitBlock(int par1, int texture)
  {
    super(par1, 211, Material.redstoneLight);
    setLightValue(1.0F);
    setCreativeTab(RGBCore.RealEETab);
    setBlockName("Electrical Lamp Lit");
    blockIndexInTexture = 12;
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
  
  public void onBlockAdded(World par1World, int par2, int par3, int par4) {}
  
  public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {}

  public int idDropped(int par1, Random par2Random, int par3)
  {
    return blockID;
  }


  @SideOnly(Side.CLIENT)
  public int idPicked(World par1World, int par2, int par3, int par4)
  {
    return Blocks.emergencyFlare.blockID;
  }
  
  public int quantityDropped(Random rand)
  {
    return 0;
  }
}
