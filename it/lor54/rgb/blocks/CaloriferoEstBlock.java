package it.lor54.rgb.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import it.lor54.rgb.RGBCore;
import it.lor54.rgb.entities.TileEntityCaloriferoEst;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;



public class CaloriferoEstBlock
  extends BlockContainer
{
  public static final String name = "Calorifero Est";
  
  public CaloriferoEstBlock(int id, int texture)
  {
    super(id, Material.rock);
    setHardness(2.0F);
    setResistance(15.0F);
    setStepSound(Block.soundStoneFootstep);
    setCreativeTab(RGBCore.OthersTab);
    setBlockName("Calorifero Est");
    blockIndexInTexture = 22;
  }
  
  public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
  {
	  this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
  }
  
  @SideOnly(Side.CLIENT)
  public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
  {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
  }
  
  public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
  {
    setBlockBounds(1.0F, 0.0F, 0.0F, 0.72F, 1.0F, 1.0F);
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
    return new TileEntityCaloriferoEst();
  }
}
