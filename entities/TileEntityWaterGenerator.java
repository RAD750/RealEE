package it.lor54.rgb.entities;

import ic2.api.Direction;
import ic2.api.energy.EnergyNet;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileSourceEvent;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class TileEntityWaterGenerator extends TileEntity implements IEnergySource
{
    public boolean added = false;

    public boolean find(World world, int blockID, int distance, int xCenter, int yCenter, int zCenter)
    {
        for (int z = zCenter - distance ; z < zCenter + distance; z++)
        {
            for (int x = xCenter - distance ; x < xCenter + distance; x++)
            {
                for (int y = yCenter - distance; y < yCenter + distance && y > 0 && y < 128; y++)
                {
                    if (world.getBlockId(x , y, z) == blockID)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void updateEntity()
    {
        if (find(this.getWorldObj(), Block.waterMoving.blockID, 2, this.xCoord, this.yCoord, this.zCoord))
        {
        	if(!added)
    		{
    			EnergyTileLoadEvent loadevent = new EnergyTileLoadEvent(this);
    			MinecraftForge.EVENT_BUS.post(loadevent);
    			added = true;
    		}

        	EnergyTileSourceEvent sourceEvent = new EnergyTileSourceEvent(this, 20);
        	MinecraftForge.EVENT_BUS.post(sourceEvent);
        }
    }

    public boolean emitsEnergyTo(TileEntity receiver, Direction direction)
    {
        return true;
    }

    public boolean isAddedToEnergyNet()
    {
        return added;
    }

    public int getMaxEnergyOutput()
    {
        return 20;
    }
}
