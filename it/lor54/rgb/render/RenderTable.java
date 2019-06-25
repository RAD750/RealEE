package it.lor54.rgb.render;

import javax.swing.Renderer;

import org.lwjgl.opengl.GL11;

import it.lor54.rgb.models.RTG_IEU_OneModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class RenderTable extends TileEntitySpecialRenderer 
{	
	private RTG_IEU_OneModel RTG_IEUOne;
	
	public RenderTable()
	{
		RTG_IEUOne = new RTG_IEU_OneModel();
	}

	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float scale) {	
		GL11.glPushMatrix();
		
		GL11.glTranslated(x+0.5, y+1.5, z+0.5);
		GL11.glRotatef(180, 0, 0, 1);
		this.bindTextureByName("/rgbmod/RTG_IEU-1.png");
		this.RTG_IEUOne.render((Entity)null, 0, -0.1f, 0, 0, 0, 0.0625f);
		GL11.glPopMatrix();
	}

}
