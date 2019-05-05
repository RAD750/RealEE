package it.lor54.rgb.blocks;

import it.lor54.rgb.cables.AATCableTileEntity;
import java.io.PrintStream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AABBPool;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class AATCableBlock extends BlockContainer
{
  public static final String name = "AAT Cable";
  float pixel = 0.0625F;
  
  public AATCableBlock(int id, int texture)
  {
    super(id, net.minecraft.block.material.Material.ground);
    


    setCreativeTab(it.lor54.rgb.RGBCore.RealEETab);
    setBlockName("AAT Cable");
    blockIndexInTexture = 12;
    setBlockBounds(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F);
    Block.useNeighborBrightness[blockID] = true;
  }
  
  public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
  {
    AATCableTileEntity cable = (AATCableTileEntity)world.getBlockTileEntity(x, y, z);
    
    if (cable != null)
    {
      float minX = 11.0F * pixel / 2.0F - (cable.connections[5] != null ? 11.0F * pixel / 2.0F : 0.0F);
      float maxX = 1.0F - 11.0F * pixel / 2.0F + (cable.connections[3] != null ? 11.0F * pixel / 2.0F : 0.0F);
      float minY = 11.0F * pixel / 2.0F - (cable.connections[1] != null ? 11.0F * pixel / 2.0F : 0.0F);
      float maxY = 1.0F - 11.0F * pixel / 2.0F + (cable.connections[0] != null ? 11.0F * pixel / 2.0F : 0.0F);
      float minZ = 11.0F * pixel / 2.0F - (cable.connections[2] != null ? 11.0F * pixel / 2.0F : 0.0F);
      float maxZ = 1.0F - 11.0F * pixel / 2.0F + (cable.connections[4] != null ? 11.0F * pixel / 2.0F : 0.0F);
      
      setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
    }
    
    return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + this.maxY, z + this.maxZ);
  }
  
  public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
  {
    AATCableTileEntity cable = (AATCableTileEntity)world.getBlockTileEntity(x, y, z);
    
    if (cable != null)
    {      
      float minX = 11.0F * pixel / 2.0F - (cable.connections[5] != null ? 11.0F * pixel / 2.0F : 0.0F);
      float maxX = 1.0F - 11.0F * pixel / 2.0F + (cable.connections[3] != null ? 11.0F * pixel / 2.0F : 0.0F);
      float minY = 11.0F * pixel / 2.0F - (cable.connections[1] != null ? 11.0F * pixel / 2.0F : 0.0F);
      float maxY = 1.0F - 11.0F * pixel / 2.0F + (cable.connections[0] != null ? 11.0F * pixel / 2.0F : 0.0F);
      float minZ = 11.0F * pixel / 2.0F - (cable.connections[2] != null ? 11.0F * pixel / 2.0F : 0.0F);
      float maxZ = 1.0F - 11.0F * pixel / 2.0F + (cable.connections[4] != null ? 11.0F * pixel / 2.0F : 0.0F);
      
      setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
    }
    
    return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + this.maxY, z + this.maxZ);
  }
  
  public int idDropped()
  {
    return blockID;
  }
  
  public int quantityDropped()
  {
    return 1;
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
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
  
  public TileEntity createNewTileEntity(World world)
  {
    return new AATCableTileEntity();
  }
  
  public TileEntity createTileEntity(World world, int meta)
  {
    return new AATCableTileEntity();
  }
  
  public void breakBlock(World world, int x, int y, int z, int blockID, int metadata)
  {
    if (world.getBlockTileEntity(x, y, z) != null)
    {
      AATCableTileEntity tile = (AATCableTileEntity)world.getBlockTileEntity(x, y, z);
      tile.setInactive();
    }
  }
}
