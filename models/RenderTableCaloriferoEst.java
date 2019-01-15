package it.lor54.rgb.models;

import javax.swing.Renderer;

import org.lwjgl.opengl.GL11;

import it.lor54.rgb.models.ModelCaloriferoBlock;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class RenderTableCaloriferoEst extends TileEntitySpecialRenderer 
{	
	private ModelCaloriferoBlock calorifero;
	
	public RenderTableCaloriferoEst()
	{
		calorifero = new ModelCaloriferoBlock();
	}

	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float scale) {	
		GL11.glPushMatrix();
		
		GL11.glTranslated(x+0.5, y+1.5, z+0.5);
		GL11.glRotatef(180, 0, 0, 1);
		this.bindTextureByName("/rgbmod/calorifero.png");
		GL11.glRotatef(180, 0, 1, 0);
		this.calorifero.render((Entity)null, 0, -0.1f, 0, 0, 0, 0.0625f);
		GL11.glPopMatrix();
	}

}

