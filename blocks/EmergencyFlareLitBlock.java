package it.lor54.rgb.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import it.lor54.rgb.RGBCore;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
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

public class EmergencyFlareLitBlock extends Block
{
    public static final String name = "Emergency Flare Lit";

    public EmergencyFlareLitBlock(int par1, int texture)
    {
        super(par1, 211, Material.redstoneLight);
        this.setLightValue(1.0F);
        this.setCreativeTab(RGBCore.RealEETab);
        this.setBlockName(name);
        this.blockIndexInTexture = 4;
    }

    public String getTextureFile()
    {
        return "/rgbmod/rgb.png";
    }

    public int getBlockTextureFromSide(int side)
    {
        if (side == 0 || side == 1) // SOPRA E SOTTO
        {
            return this.blockIndexInTexture;
        }
        else
        {
            if (side == 2 || side == 3) // SINISTRA E DESTRA
            {
                return this.blockIndexInTexture + 6;
            }
            else // AVANTI E DIETRO
            {
                return this.blockIndexInTexture + 6;
            }
        }
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(final World par1World, final int par2, final int par3, final int par4)
    {
        if (!par1World.isRemote)
        {
            new java.util.Timer().schedule
            (
                    new java.util.TimerTask()
            {
                @Override
                public void run()
                {
                    par1World.setBlock(par2, par3, par4, 0);
                }
            },
            30000
            );
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(final World par1World, final int par2, final int par3, final int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            new java.util.Timer().schedule
            (
                    new java.util.TimerTask()
            {
                @Override
                public void run()
                {
                    par1World.setBlock(par2, par3, par4, 0);
                }
            },
            30000
            );
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return Blocks.emergencyFlare.blockID;
    }

    public int quantityDropped(Random rand)
    {
        return 0;
    }
}
