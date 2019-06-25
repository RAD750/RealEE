package it.lor54.rgb.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import it.lor54.rgb.RGBCore;
import it.lor54.rgb.entities.TileEntityCaloriferoBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class CaloriferoBlock extends BlockContainer
{
  public static final String name = "Calorifero";
  
  public CaloriferoBlock(int id, int texture)
  {
    super(id, Material.rock);
    setHardness(2.0F);
    setResistance(15.0F);
    setStepSound(Block.soundStoneFootstep);
    setCreativeTab(RGBCore.OthersTab);
    setBlockName("Calorifero");
    blockIndexInTexture = 22;
  }
  

  public int getRenderType()
  {
    return -1;
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
    if (blockAccess.getBlockMetadata(x, y, z) == 1)
    {
      setBlockBounds(0.27F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F);


    }
    else if (blockAccess.getBlockMetadata(x, y, z) == 2)
    {
      setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.27F);


    }
    else if (blockAccess.getBlockMetadata(x, y, z) == 3)
    {
      setBlockBounds(1.0F, 0.0F, 0.0F, 0.72F, 1.0F, 1.0F);
    }
    else
    {
      setBlockBounds(0.0F, 0.0F, 0.72F, 1.0F, 1.0F, 1.0F);
    }
  }

  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity)
  {
    if ((entity instanceof EntityPlayer))
    {
      int yaw = (int)entity.rotationYaw;
      
      if (yaw < 0)
        yaw += 360;
      yaw += 22;
      yaw %= 360;
      int facing = yaw / 45;
      
      world.setBlockAndMetadataWithNotify(x, y, z, Blocks.caloriferoBlock.blockID, facing / 2);
    }
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
    return new TileEntityCaloriferoBlock();
  }
}
