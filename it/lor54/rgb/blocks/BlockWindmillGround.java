package it.lor54.rgb.blocks;

import it.lor54.rgb.entities.TileEntityWindmillFloor;
import it.lor54.rgb.items.Items;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWindmillGround
  extends BlockContainer
{
  public static final String name = "Windmill Block Ground";
  
  public BlockWindmillGround(int id, int texture)
  {
    super(id, Material.rock);
    setHardness(50.0F);
    

    setStepSound(Block.soundStoneFootstep);
    setCreativeTab(null);
    setBlockName("Windmill Block Ground");
  }
  

  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
  
  public int getBlockTextureFromSide(int side)
  {
    return 10;
  }
  
  public int idDropped(int par1, Random par2Random, int par3)
  {
    return Items.windmillGround.itemID;
  }
  
  public int quantityDropped(Random par1Random)
  {
    return 1;
  }
  
  public TileEntity createNewTileEntity(World var1)
  {
    return new TileEntityWindmillFloor();
  }
  
  public void breakBlock(World world, int x, int y, int z, int blockID, int metadata)
  {
    if (world.getBlockId(x, y + 1, z) == Blocks.blockWindmill.blockID) {
      world.setBlock(x, y + 1, z, 0);
    }
    
    if (world.getBlockTileEntity(x, y, z) != null)
    {
      TileEntityWindmillFloor tile = (TileEntityWindmillFloor)world.getBlockTileEntity(x, y, z);
      tile.setInactive();
    }
  }
}
