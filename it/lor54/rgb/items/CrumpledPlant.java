package it.lor54.rgb.items;

import it.lor54.rgb.RGBCore;
import net.minecraft.item.Item;

public class CrumpledPlant extends Item
{
	public static final String name = "Crumpled Plant";
	
	public CrumpledPlant(int id)
	{
		super(id);
		this.iconIndex = 6;
		this.setItemName(name);
		this.setCreativeTab(RGBCore.OthersTab);
	}
	
	public String getTextureFile()
	{
		return "/rgbmod/rgb.png";
	}
}
