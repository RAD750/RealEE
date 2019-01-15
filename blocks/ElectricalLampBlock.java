package it.lor54.rgb.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import it.lor54.rgb.RGBCore;
import it.lor54.rgb.entities.TileEntityElectricalLamp;
import it.lor54.rgb.entities.TileEntityWaterGenerator;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import net.minecraftforge.common.ForgeDirection;
import static net.minecraftforge.common.ForgeDirection.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class ElectricalLampBlock extends Block
{
    public static final String name = "Electrical Lamp";

    public ElectricalLampBlock(int par1, int texture)
    {
        super(par1, 211, Material.redstoneLight);
        this.setLightValue(0.0F);
        this.setCreativeTab(RGBCore.RealEETab);
        this.setBlockName(name);
        this.blockIndexInTexture = 11;
    }

    public String getTextureFile()
    {
        return "/rgbmod/rgb.png";
    }

    public int quantityDropped(Random rand)
    {
        return 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Blocks.electricalLamp.blockID;
    }

    @SideOnly(Side.CLIENT)
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return Blocks.electricalLamp.blockID;
    }

    public TileEntity createNewTileEntity(World world)
    {
        return null;
    }

    public TileEntity createTileEntity(World world, int meta)
    {
        return new TileEntityElectricalLamp();
    }
}