package it.lor54.rgb;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import it.lor54.rgb.blocks.Blocks;
import it.lor54.rgb.items.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class OthersTab extends CreativeTabs
{
    public OthersTab(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack() // ICONA TAB
    {
        return new ItemStack(Items.crumpledPlant.itemID, 1, 0);
    }

    public String getTranslatedTabLabel() // NOME TAB
    {
        return "RGBCraft Other Objects";
    }
}
