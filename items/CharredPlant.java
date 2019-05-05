package it.lor54.rgb.items;

import it.lor54.rgb.RGBCore;
import net.minecraft.item.Item;

public class CharredPlant extends Item
{
	public static final String name = "Charred Plant";
	
	public CharredPlant(int id)
	{
		super(id);
		this.iconIndex = 7;
		this.setItemName(name);
		this.setCreativeTab(RGBCore.OthersTab);
	}
	
	public String getTextureFile()
	{
		return "/rgbmod/rgb.png";
	}
}
