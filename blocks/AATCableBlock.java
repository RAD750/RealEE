package it.lor54.rgb.blocks;

import it.lor54.rgb.RGBCore;
import it.lor54.rgb.cables.AATCableTileEntity;
import it.lor54.rgb.entities.TileEntityWindmillFloor;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class AATCableBlock extends BlockContainer
{
    public static final String name = "AAT Cable";
    float pixel = 1F/16F;

    public AATCableBlock(int id, int texture)
    {
        super(id, Material.ground);
        //this.setHardness(2F);
        //this.setResistance(15F);
        //this.setStepSound(Block.soundStoneFootstep);
        this.setCreativeTab(RGBCore.RealEETab);
        this.setBlockName(name);
        this.blockIndexInTexture = 12;
        this.setBlockBounds(11*pixel/2, 11*pixel/2, 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2);
        this.useNeighborBrightness[this.blockID] = true;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
    	AATCableTileEntity cable = (AATCableTileEntity) world.getBlockTileEntity(x, y, z);
    	
        if(cable != null)
        {
        	float minX = 11*pixel/2 - (cable.connections[5] != null?(11*pixel/2):0);
        	float maxX = 1-11*pixel/2 + (cable.connections[3] != null?(11*pixel/2):0);
        	float minY = 11*pixel/2 - (cable.connections[1] != null?(11*pixel/2):0);
        	float maxY = 1-11*pixel/2 + (cable.connections[0] != null?(11*pixel/2):0);
        	float minZ = 11*pixel/2 - (cable.connections[2] != null?(11*pixel/2):0);
        	float maxZ = 1-11*pixel/2 + (cable.connections[4] != null?(11*pixel/2):0);

        	this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        }
    	
		return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(x+this.minX, y+this.minY, z+this.minZ, x+this.maxX, y+this.maxY, z+this.maxZ);
	}

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
    	AATCableTileEntity cable = (AATCableTileEntity) world.getBlockTileEntity(x, y, z);
    	
        if(cable != null)
        {
        	System.out.println(cable.connections[2]);
        	
        	float minX = 11*pixel/2 - (cable.connections[5] != null?(11*pixel/2):0);
        	float maxX = 1-11*pixel/2 + (cable.connections[3] != null?(11*pixel/2):0);
        	float minY = 11*pixel/2 - (cable.connections[1] != null?(11*pixel/2):0);
        	float maxY = 1-11*pixel/2 + (cable.connections[0] != null?(11*pixel/2):0);
        	float minZ = 11*pixel/2 - (cable.connections[2] != null?(11*pixel/2):0);
        	float maxZ = 1-11*pixel/2 + (cable.connections[4] != null?(11*pixel/2):0);

        	this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        }
    	
		return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(x+this.minX, y+this.minY, z+this.minZ, x+this.maxX, y+this.maxY, z+this.maxZ);
	}
    
    public int idDropped()
    {
        return this.blockID;
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
		if(world.getBlockTileEntity(x, y, z) != null)
		{
			AATCableTileEntity tile = (AATCableTileEntity) world.getBlockTileEntity(x, y, z);
			tile.setInactive();
		}
	}
}
