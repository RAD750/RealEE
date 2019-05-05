package it.lor54.rgb.blocks;

import it.lor54.rgb.entities.WindmillTileEntity;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WindmillBlock
  extends BlockContainer
{
  public static final String name = "Windmill Block";
  
  public WindmillBlock(int id, int texture)
  {
    super(id, Material.rock);
    setHardness(50.0F);
    
    setStepSound(Block.soundMetalFootstep);
    setCreativeTab(null);
    setBlockName("Windmill Block");
    Block.useNeighborBrightness[blockID] = true;
  }
  
  public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
  {
    float pixel = 0.0625F;
    
    if ((blockAccess.getBlockMetadata(x, y, z) < 15) && (blockAccess.getBlockMetadata(x, y, z) >= 0)) setBlockBounds(pixel * 4.0F, 0.0F, pixel * 4.0F, 1.0F - pixel * 4.0F, 1.0F, 1.0F - pixel * 4.0F); else {
      setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
  }
  
  public int idDropped(int par1, Random par2Random, int par3) {
    return 0;
  }
  
  public int quantityDropped(Random par1Random)
  {
    return 0;
  }
  
  public int getRenderType()
  {
    return -1;
  }
  
  public boolean isOpaqueCube()
  {
    return false;
  }
  
  public boolean renderAsNormalBlock()
  {
    return false;
  }
  
  public TileEntity createNewTileEntity(World var1)
  {
    return new WindmillTileEntity();
  }
  
  public void breakBlock(World world, int x, int y, int z, int blockID, int metadata)
  {
    if (world.getBlockId(x, y + 1, z) == Blocks.blockWindmill.blockID)
      world.setBlock(x, y + 1, z, 0);
    if (world.getBlockId(x, y - 1, z) == Blocks.blockWindmill.blockID) {
      world.setBlock(x, y - 1, z, 0);
    }
    if (world.getBlockTileEntity(x, y, z) != null)
    {
      WindmillTileEntity tile = (WindmillTileEntity)world.getBlockTileEntity(x, y, z);
      tile.setInactive();
    }
  }
}
