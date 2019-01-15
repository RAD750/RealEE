package it.lor54.rgb.models;

import org.lwjgl.opengl.GL11;

import it.lor54.rgb.blocks.Blocks;
import it.lor54.rgb.entities.WindmillTileEntity;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class RenderTableWindmill extends TileEntitySpecialRenderer
{
	private float pixel = 1F/16F;
	
	private int textureWidth = 32;
	private int textureHeight = 32;

	int old = 2;
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) 
	{
		int x1 = tileentity.xCoord, y1 = tileentity.yCoord, z1 = tileentity.zCoord;
		
		while(tileentity.getWorldObj().getBlockMetadata(x1, y1, z1) < 15 && tileentity.getWorldObj().getBlockId(x1, y1, z1) == Blocks.blockWindmill.blockID)
		{
			y1++;
		}
		
		int x2 = tileentity.xCoord, y2 = tileentity.yCoord, z2 = tileentity.zCoord;
		
		
		int i = 0;
		/** direction = from 1 to 4 - ultimo blocco*/
		while(tileentity.getWorldObj().getBlockId(x2, y2, z2) != Blocks.blockWindmillGround.blockID && i < 17)
		{
			y2--;
			i++;
		}
				
		int metadata = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
		
		int direction = 2;
		if(tileentity.getWorldObj().getBlockId(x2, y2, z2) == Blocks.blockWindmillGround.blockID)
		{
			direction = tileentity.getWorldObj().getBlockMetadata(x2, y2, z2) + 1;
			if(direction == 1)
				direction = 3;
			else
				if(direction == 3)
					direction = 1;
		}
						
   		//System.out.println(tileentity.getWorldObj().getBlockMetadata(x1, y1-2, z1));

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef((float) x, (float) y, (float) z);
		
		GL11.glTranslatef(0.5F, 0, 0.5F);
		GL11.glRotatef((direction)*90, 0, 1, 0);
		GL11.glTranslatef(-0.5F, 0, -0.5F);

		Tessellator tessellator = new Tessellator();
		this.bindTextureByName("/rgbmod/windmill.png");
		tessellator.startDrawingQuads();
		{
			if(metadata >= 0 && metadata <= 14)
			{
				tessellator.addVertexWithUV((16-8)/2*pixel, 0, 1-(16-8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV((16-8)/2*pixel, 1, 1-(16-8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((16-8)/2*pixel, 1, (16-8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((16-8)/2*pixel, 0, (16-8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV(1-(16-8)/2*pixel, 0, 1-(16-8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(16-8)/2*pixel, 1, 1-(16-8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((16-8)/2*pixel, 1, 1-(16-8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((16-8)/2*pixel, 0, 1-(16-8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV((16-8)/2*pixel, 0, (16-8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV((16-8)/2*pixel, 1, (16-8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(16-8)/2*pixel, 1, (16-8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(16-8)/2*pixel, 0, (16-8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
			
				tessellator.addVertexWithUV(1-(16-8)/2*pixel, 0, (16-8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(16-8)/2*pixel, 1, (16-8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(16-8)/2*pixel, 1, 1-(16-8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(16-8)/2*pixel, 0, 1-(16-8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
			}
			else
			{
				if(metadata > 14)
				{
					this.bindTextureByName("/rgbmod/WindmillNacelle.png");
					//Superiore
					tessellator.addVertexWithUV(1, 1, 1, 1, 1);
					tessellator.addVertexWithUV(1, 1, 0, 1, 0);
					tessellator.addVertexWithUV(0, 1, 0, 0, 0);
					tessellator.addVertexWithUV(0, 1, 1, 0, 1);
					
					//Inferiore
					tessellator.addVertexWithUV(0, 0, 1, 0, 0);
					tessellator.addVertexWithUV(0, 0, 0, 0, 1);
					tessellator.addVertexWithUV(1, 0, 0, 1, 1);
					tessellator.addVertexWithUV(1, 0, 1, 1, 0);
					
					tessellator.addVertexWithUV(1, 0, 0, 1, 0);
					tessellator.addVertexWithUV(0, 0, 0, 0, 0);
					tessellator.addVertexWithUV(0, 1, 0, 0, 1);
					tessellator.addVertexWithUV(1, 1, 0, 1, 1);
					
					tessellator.addVertexWithUV(1, 0, 0, 1, 1);
					tessellator.addVertexWithUV(1, 1, 0, 1, 0);
					tessellator.addVertexWithUV(1, 1, 1, 0, 0);
					tessellator.addVertexWithUV(1, 0, 1, 0, 1);
					
					tessellator.addVertexWithUV(0, 0, 0, 1, 1);
					tessellator.addVertexWithUV(0, 0, 1, 0, 1);
					tessellator.addVertexWithUV(0, 1, 1, 0, 0);
					tessellator.addVertexWithUV(0, 1, 0, 1, 0);
				}
				else
				{
					/*this.bindTextureByName("/rgbmod/WindmillFloor.png");
					tessellator.addVertexWithUV(1, 1, 1, 1, 1);
					tessellator.addVertexWithUV(1, 1, 0, 1, 0);
					tessellator.addVertexWithUV(0, 1, 0, 0, 0);
					tessellator.addVertexWithUV(0, 1, 1, 0, 1);
					
					tessellator.addVertexWithUV(0, 0, 1, 0, 0);
					tessellator.addVertexWithUV(0, 0, 0, 0, 1);
					tessellator.addVertexWithUV(1, 0, 0, 1, 1);
					tessellator.addVertexWithUV(1, 0, 1, 1, 0);
					
					tessellator.addVertexWithUV(1, 0, 1, 1, 1);
					tessellator.addVertexWithUV(1, 1, 1, 1, 0);
					tessellator.addVertexWithUV(0, 1, 1, 0, 0);
					tessellator.addVertexWithUV(0, 0, 1, 0, 1);
					
					tessellator.addVertexWithUV(1, 0, 0, 1, 0);
					tessellator.addVertexWithUV(0, 0, 0, 0, 0);
					tessellator.addVertexWithUV(0, 1, 0, 0, 1);
					tessellator.addVertexWithUV(1, 1, 0, 1, 1);
					
					tessellator.addVertexWithUV(1, 0, 0, 1, 1);
					tessellator.addVertexWithUV(1, 1, 0, 1, 0);
					tessellator.addVertexWithUV(1, 1, 1, 0, 0);
					tessellator.addVertexWithUV(1, 0, 1, 0, 1);
					
					tessellator.addVertexWithUV(0, 0, 0, 1, 1);
					tessellator.addVertexWithUV(0, 0, 1, 0, 1);
					tessellator.addVertexWithUV(0, 1, 1, 0, 0);
					tessellator.addVertexWithUV(0, 1, 0, 1, 0);*/
				}
			}
		}
		tessellator.draw();
		
		if(metadata > 14)
		{
			this.bindTextureByName("/rgbmod/WindmillNacelleLogo.png");
			tessellator.startDrawingQuads();
			{
				//lato logo
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 1, 0, 0);
				tessellator.addVertexWithUV(0, 0, 1, 0, 1);
			}
			tessellator.draw();
		}
		
		if(metadata == -1)
		{
			this.bindTextureByName("/rgbmod/windmill2.png");
			tessellator.startDrawingQuads();
			{
				tessellator.addVertexWithUV(pixel*13, pixel*16+0.1, pixel*13, 1, 1);
				tessellator.addVertexWithUV(pixel*13, pixel*16+0.1, pixel*3, 1, 0);
				tessellator.addVertexWithUV(pixel*3, pixel*16+0.1, pixel*3, 0, 0);
				tessellator.addVertexWithUV(pixel*3, pixel*16+0.1, pixel*13, 0, 1);

				tessellator.addVertexWithUV(pixel*13, pixel*14+0.1, pixel*13, 1, 1F/10F*2);
				tessellator.addVertexWithUV(pixel*13, pixel*16+0.1, pixel*13, 1, 0);
				tessellator.addVertexWithUV(pixel*3, pixel*16+0.1, pixel*13, 0, 0);
				tessellator.addVertexWithUV(pixel*3, pixel*14+0.1, pixel*13, 0, 1F/10F*2);
					
				tessellator.addVertexWithUV(pixel*3, pixel*14+0.1, pixel*3, 1, 1F/10F*2);
				tessellator.addVertexWithUV(pixel*3, pixel*16+0.1, pixel*3, 1, 0);
				tessellator.addVertexWithUV(pixel*13, pixel*16+0.1, pixel*3, 0, 0);
				tessellator.addVertexWithUV(pixel*13, pixel*14+0.1, pixel*3, 0, 1F/10F*2);
					
				tessellator.addVertexWithUV(pixel*13, pixel*14+0.1, pixel*3, 1, 1F/10F*2);
				tessellator.addVertexWithUV(pixel*13, pixel*16+0.1, pixel*3, 1, 0);
				tessellator.addVertexWithUV(pixel*13, pixel*16+0.1, pixel*13, 0, 0);
				tessellator.addVertexWithUV(pixel*13, pixel*14+0.1, pixel*13, 0, 1F/10F*2);
					
				tessellator.addVertexWithUV(pixel*3, pixel*14+0.1, pixel*13, 1, 1F/10F*2);
				tessellator.addVertexWithUV(pixel*3, pixel*16+0.1, pixel*13, 1, 0);
				tessellator.addVertexWithUV(pixel*3, pixel*16+0.1, pixel*3, 0, 0);
				tessellator.addVertexWithUV(pixel*3, pixel*14+0.1, pixel*3, 0, 1F/10F*2);
			}
			tessellator.draw();
		}
		
		if(metadata == 15) drawRotor(tileentity);
		GL11.glEnable(GL11.GL_LIGHTING);
	GL11.glPopMatrix();
}

private void drawRotor(TileEntity tileentity)
{
	WindmillTileEntity windmill = (WindmillTileEntity) tileentity.getWorldObj().getBlockTileEntity(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
	
	GL11.glTranslatef(0, 0.5F, 0.5F);
	GL11.glRotatef(windmill.rotation, 1, 0, 0);
	GL11.glTranslatef(0, -0.5F, -0.5F);
	
	GL11.glColor3f(247, 247, 247);
	
	Tessellator tessellator = new Tessellator();
	this.bindTextureByName("/rgbmod/windmill.png");
	tessellator.startDrawingQuads();
	{
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 2.5*pixel+0.5F, 10*(1F/textureWidth), 1*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 6.0F, 1*pixel+0.5F, 10*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 6.0F, -1*pixel+0.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, -2.5*pixel+0.5F, 9*(1F/textureWidth), 1*(1F/textureHeight));
		
		tessellator.addVertexWithUV(-2*pixel, -5.0F,        1*pixel+0.5F, 10*(1F/textureWidth), 1*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 2.5F*pixel+0.5F, 10*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, -2.5F*pixel+0.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, -5.0F,         -1*pixel+0.5F, 9*(1F/textureWidth), 1*(1F/textureHeight));
								
		/*tessellator.addVertexWithUV(2*pixel, 0.5F-1*pixel, 6.0F, 10*(1F/textureWidth), 1*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 6.0F, 10*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 0.5F+1*pixel, 9*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(2*pixel, 0.5F-1*pixel, 0.5F+1*pixel, 9*(1F/textureWidth), 1*(1F/textureHeight));
		
		tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 0.5F-1*pixel, 10*(1F/textureWidth), 1*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 0.5F-1*pixel, 10*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, -5.0F, 9*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, -1.5F, 9*(1F/textureWidth), 1*(1F/textureHeight));*/

		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, -2.5*pixel+0.5F, 9*(1F/textureWidth), 1*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 6.0F, -1*pixel+0.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 6.0F, 1*pixel+0.5F, 10*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 2.5*pixel+0.5F, 10*(1F/textureWidth), 1*(1F/textureHeight));
		
		tessellator.addVertexWithUV(-2*pixel, -5.0F,         -1*pixel+0.5F, 9*(1F/textureWidth), 1*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, -2.5F*pixel+0.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
;			tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 2.5F*pixel+0.5F, 10*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, -5.0F,        1*pixel+0.5F, 10*(1F/textureWidth), 1*(1F/textureHeight));
		
		/*tessellator.addVertexWithUV(-2*pixel, -5.0F, -1*pixel+0.5F, 9*(1F/textureWidth), 1*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, -1*pixel+0.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 1*pixel+0.5F, 10*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, -5.0F, 1*pixel+0.5F, 10*(1F/textureWidth), 1*(1F/textureHeight));*/
		
		/*tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 0.5F+1*pixel, 9*(1F/textureWidth), 1*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 0.5F+1*pixel, 9*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 2.5F, 10*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 2.5F, 10*(1F/textureWidth), 1*(1F/textureHeight));
		
		tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, -1.5F, 9*(1F/textureWidth), 1*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, -1.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 0.5F-1*pixel, 10*(1F/textureWidth), 0*(1F/textureHeight));
		tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 0.5F-1*pixel, 10*(1F/textureWidth), 1*(1F/textureHeight));*/
	}
	tessellator.draw();
	
	this.bindTextureByName("/rgbmod/windmill2.png");
	tessellator.startDrawingQuads();
	{
		tessellator.addVertexWithUV(-2*pixel, 7*pixel, 9*pixel, 6*(1F/10F), 6*(1F/10F));
		tessellator.addVertexWithUV(-2*pixel, 9*pixel, 9*pixel, 6*(1F/10F), 4*(1F/10F));
		tessellator.addVertexWithUV(-2*pixel, 9*pixel, 7*pixel, 4*(1F/10F), 4*(1F/10F));
		tessellator.addVertexWithUV(-2*pixel, 7*pixel, 7*pixel, 4*(1F/10F), 6*(1F/10F));

		tessellator.addVertexWithUV(-2*pixel, 7*pixel, 7*pixel, 6*(1F/10F), 6*(1F/10F));
		tessellator.addVertexWithUV(-2*pixel, 9*pixel, 7*pixel, 6*(1F/10F), 4*(1F/10F));
		tessellator.addVertexWithUV(0*pixel, 9*pixel, 7*pixel, 4*(1F/10F), 4*(1F/10F));
		tessellator.addVertexWithUV(0*pixel, 7*pixel, 7*pixel, 4*(1F/10F), 6*(1F/10F));

		tessellator.addVertexWithUV(0*pixel, 7*pixel, 9*pixel, 6*(1F/10F), 4*(1F/10F));
		tessellator.addVertexWithUV(0*pixel, 9*pixel, 9*pixel, 6*(1F/10F), 6*(1F/10F));
		tessellator.addVertexWithUV(-2*pixel, 9*pixel, 9*pixel, 4*(1F/10F), 6*(1F/10F));
		tessellator.addVertexWithUV(-2*pixel, 7*pixel, 9*pixel, 4*(1F/10F), 4*(1F/10F));

		tessellator.addVertexWithUV(0*pixel, 9*pixel, 9*pixel, 6*(1F/10F), 6*(1F/10F));
		tessellator.addVertexWithUV(0*pixel, 9*pixel, 7*pixel, 6*(1F/10F), 4*(1F/10F));
		tessellator.addVertexWithUV(-2*pixel, 9*pixel, 7*pixel, 4*(1F/10F), 4*(1F/10F));
		tessellator.addVertexWithUV(-2*pixel, 9*pixel, 9*pixel, 4*(1F/10F), 6*(1F/10F));

		tessellator.addVertexWithUV(-2*pixel, 7*pixel, 9*pixel, 4*(1F/10F), 4*(1F/10F));
		tessellator.addVertexWithUV(-2*pixel, 7*pixel, 7*pixel, 4*(1F/10F), 6*(1F/10F));
		tessellator.addVertexWithUV(0*pixel, 7*pixel, 7*pixel, 6*(1F/10F), 6*(1F/10F));
		tessellator.addVertexWithUV(0*pixel, 7*pixel, 9*pixel, 6*(1F/10F), 4*(1F/10F));

	}
	tessellator.draw();
}
}
