package it.lor54.rgb.blocks;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksCraftingRecipes 
{
	public void addCraftingRecipes()
	{
		if(Loader.isModLoaded("Railcraft"))
		{
			//GameRegistry.addRecipe(Railcraft.rail, "", 'B', Items.stick);
		}
	}
}
