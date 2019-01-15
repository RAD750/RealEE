package it.lor54.rgb.blocks;

import it.lor54.rgb.RGBCore;
import it.lor54.rgb.entities.TileEntityCaloriferoEst;
import it.lor54.rgb.entities.TileEntityWaterGenerator;
import it.lor54.rgb.gui.ChangeGuiColor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CaloriferoEstBlock extends BlockContainer
{
	public static final String name = "Calorifero Est";
	
	public CaloriferoEstBlock(int id, int texture)
	{
		super(id, Material.rock);
		this.setHardness(2F);
		this.setResistance(15F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setCreativeTab(RGBCore.OthersTab);
		this.setBlockName(name);
		this.blockIndexInTexture = 22;
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
    {
		this.setBlockBounds(1, 0, 0, 0.72F, 1, 1);  		
    }
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
    public String getTextureFile()
    {
        return "/rgbmod/rgb.png";
    }

	@Override
    public boolean isOpaqueCube()
    {
        return false;
    }
	    
	@Override
	public boolean renderAsNormalBlock()
	{
	    return false;
	}
	
	public int idDropped(int par1, int par2)
	{
		return this.blockID;
	}
	
	public int quantityDropped()
	{
		return 1;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return null;
	}
	
	public TileEntity createTileEntity(World world, int meta)
	{
		return new TileEntityCaloriferoEst();
	}
}

