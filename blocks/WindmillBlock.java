package it.lor54.rgb.blocks;

import java.util.Random;

import it.lor54.rgb.RGBCore;
import it.lor54.rgb.entities.WindmillTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialPortal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class WindmillBlock extends BlockContainer
{
    public static final String name = "Windmill Block";
    
    public WindmillBlock(int id, int texture)
    {
        super(id, Material.rock);
        this.setHardness(50);
        //this.setResistance(15F);
        this.setStepSound(Block.soundMetalFootstep);
        this.setCreativeTab(null);
        this.setBlockName(name);
        this.useNeighborBrightness[this.blockID] = true;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
    {
    	float pixel = 1F/16F;
    	
    	if(blockAccess.getBlockMetadata(x, y, z) < 15 && blockAccess.getBlockMetadata(x, y, z) >= 0) this.setBlockBounds(pixel*4, 0, pixel*4, 1-pixel*4, 1, 1-pixel*4);
    	else this.setBlockBounds(0, 0, 0, 1, 1, 1);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
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

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new WindmillTileEntity();
	}
	
	public void breakBlock(World world, int x, int y, int z, int blockID, int metadata)
	{
		if(world.getBlockId(x, y+1, z) == Blocks.blockWindmill.blockID)
			world.setBlock(x, y+1, z, 0);
		if(world.getBlockId(x, y-1, z) == Blocks.blockWindmill.blockID)
			world.setBlock(x, y-1, z, 0);
		
		if(world.getBlockTileEntity(x, y, z) != null)
		{
			WindmillTileEntity tile = (WindmillTileEntity) world.getBlockTileEntity(x, y, z);
			tile.setInactive();
		}
		
	}
}
