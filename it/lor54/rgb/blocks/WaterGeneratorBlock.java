package it.lor54.rgb.blocks;

import it.lor54.rgb.RGBCore;
import it.lor54.rgb.entities.TileEntityWaterGenerator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;






public class WaterGeneratorBlock
  extends BlockContainer
{
  public static final String name = "Mini-Hydro Turbine";
  
  public WaterGeneratorBlock(int id, int texture)
  {
    super(id, Material.rock);
    setHardness(2.0F);
    setResistance(15.0F);
    setStepSound(Block.soundStoneFootstep);
    setCreativeTab(RGBCore.RealEETab);
    setBlockName("Mini-Hydro Turbine");
  }
  
  public int idDropped(int par1, Random rand, int par2)
  {
    return blockID;
  }
  
  public int quantityDropped(Random rand)
  {
    return 1;
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
  
  public int getBlockTextureFromSide(int side)
  {
    if ((side == 0) || (side == 1))
    {
      return blockIndexInTexture;
    }
    

    if ((side == 2) || (side == 3))
    {
      return blockIndexInTexture + 2;
    }
    

    return blockIndexInTexture + 1;
  }
  


  public TileEntity createNewTileEntity(World world)
  {
    return new TileEntityWaterGenerator();
  }
  
  public TileEntity createTileEntity(World world, int meta)
  {
    return new TileEntityWaterGenerator();
  }
}
