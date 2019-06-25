package it.lor54.rgb.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import it.lor54.rgb.RGBCore;
import it.lor54.rgb.entities.TileEntityElectricalLamp;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ElectricalLampBlock
  extends Block
{
  public static final String name = "Electrical Lamp";
  
  public ElectricalLampBlock(int par1, int texture)
  {
    super(par1, 211, Material.redstoneLight);
    setLightValue(0.0F);
    setCreativeTab(RGBCore.RealEETab);
    setBlockName("Electrical Lamp");
    blockIndexInTexture = 11;
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
  
  public int quantityDropped(Random rand)
  {
    return 1;
  }
  



  public int idDropped(int par1, Random par2Random, int par3)
  {
    return Blocks.electricalLamp.blockID;
  }
  



  @SideOnly(Side.CLIENT)
  public int idPicked(World par1World, int par2, int par3, int par4)
  {
    return Blocks.electricalLamp.blockID;
  }
  
  public TileEntity createNewTileEntity(World world)
  {
    return null;
  }
  
  public TileEntity createTileEntity(World world, int meta)
  {
    return new TileEntityElectricalLamp();
  }
}
