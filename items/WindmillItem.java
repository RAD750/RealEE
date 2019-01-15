package it.lor54.rgb.items;

import it.lor54.rgb.RGBCore;
import it.lor54.rgb.blocks.Blocks;
import it.lor54.rgb.entities.WindmillTileEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class WindmillItem extends Item
{
    public static final String name = "Wind Turbine";

    public WindmillItem(int id)
    {
        super(id);
        this.maxStackSize = 1;
        this.setItemName(name);
        this.setCreativeTab(RGBCore.OthersTab);
        this.iconIndex = 25;
    }
    
    public String getTextureFile()
    {
        return "/rgbmod/rgb.png";
    }
    
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2)
    {
    	if(!world.isRemote)
    	{
    		if (!player.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }
    		
       		if(side == 1 && world.getBlockId(x, y, z) == Blocks.blockWindmillGround.blockID)
       		{
       			boolean notEnoughSpace = false;
       			
       			for(int x1 = 0; x1 < 1; x1++)
       			{
       				for(int z1 = -1; z1 < 1; z1++)
       				{
       					for(int y1 = 1; y1 < 15; y1++)
       					{
       						if(!world.isAirBlock(x+x1, y+y1+1, z+z1)) notEnoughSpace = true;
       					}
       				}
       			}
       			
       			if(!notEnoughSpace)
       			{
       				int direction = (-(int) player.rotationYaw+45)/90;
       				if(direction == 0) direction = 4;
       				
       				for(int y1 = -1; y1 < 15; y1++)
       				{									
       					// if then, else (y1+1)==15?(y1+1+direction):(y1+1)
       					if(y1+1==15)
       					{
               	        	world.setBlockAndMetadataWithNotify(x, y+y1+2, z, Blocks.blockWindmill.blockID, y1+1);
       					}
       					else
       					{
               	        	world.setBlockAndMetadataWithNotify(x, y+y1+2, z, Blocks.blockWindmill.blockID, y1+1);
       					}
       				}
       				
       				return true;
       			}
       		}
    	}
        return false;
    }
}
