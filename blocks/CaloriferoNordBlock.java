package it.lor54.rgb.blocks;

import it.lor54.rgb.RGBCore;
import it.lor54.rgb.entities.TileEntityCaloriferoNord;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;





public class CaloriferoNordBlock
  extends BlockContainer
{
  public static final String name = "Calorifero Nord";
  
  public CaloriferoNordBlock(int id, int texture)
  {
    super(id, Material.rock);
    setHardness(2.0F);
    setResistance(15.0F);
    setStepSound(Block.soundStoneFootstep);
    setCreativeTab(RGBCore.OthersTab);
    setBlockName("Calorifero Nord");
    blockIndexInTexture = 22;
  }
  
  public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
  {
    setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.27F);
  }
  

  public int getRenderType()
  {
    return -1;
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
  

  public boolean isOpaqueCube()
  {
    return false;
  }
  

  public boolean renderAsNormalBlock()
  {
    return false;
  }
  
  public int idDropped(int par1, int par2)
  {
    return blockID;
  }
  
  public int quantityDropped()
  {
    return 1;
  }
  

  public TileEntity createNewTileEntity(World world)
  {
    return null;
  }
  
  public TileEntity createTileEntity(World world, int meta)
  {
    return new TileEntityCaloriferoNord();
  }
}
