package it.lor54.rgb.entities;

import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileSourceEvent;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;

public class TileEntityWindmillFloor extends TileEntity implements IEnergySource
{
	private boolean added = false;
	public int power = 0;
	private boolean enabled = true;
	
	public void updateEntity()
	{
		if(enabled)
		{
			if(!added)
			{
				EnergyTileLoadEvent loadevent = new EnergyTileLoadEvent(this);
				MinecraftForge.EVENT_BUS.post(loadevent);
				added = true;
			}
			
			if(this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord+16, this.zCoord) instanceof WindmillTileEntity)
			{

				WindmillTileEntity tile = (WindmillTileEntity) this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord+16, this.zCoord);
				power = (int) (tile.vento*10);
			
				EnergyTileSourceEvent sourceEvent = new EnergyTileSourceEvent(this, power);
				MinecraftForge.EVENT_BUS.post(sourceEvent);
	    	
			}
		}
	}

	@Override
	public boolean isAddedToEnergyNet() {
		return added;
	}

	@Override
	public boolean emitsEnergyTo(TileEntity receiver, Direction direction) {
		return true;
	}

	@Override
	public int getMaxEnergyOutput() {
		return 130;
	}
	
	public void setInactive()
	{
		this.enabled = false;
		this.worldObj.removeBlockTileEntity(this.xCoord, this.yCoord, this.zCoord);
		invalidate();
	}
}
