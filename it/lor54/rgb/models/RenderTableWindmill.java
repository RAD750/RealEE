package it.lor54.rgb.models;

import it.lor54.rgb.blocks.Blocks;
import it.lor54.rgb.entities.WindmillTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderTableWindmill extends TileEntitySpecialRenderer
{
  private float pixel = 0.0625F;
  
  private int textureWidth = 32;
  private int textureHeight = 32;
  
  int old = 2;
  
  public RenderTableWindmill() {}
  
  public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
    int x1 = tileentity.xCoord; int y1 = tileentity.yCoord; int z1 = tileentity.zCoord;
    
    while ((tileentity.getWorldObj().getBlockMetadata(x1, y1, z1) < 15) && (tileentity.getWorldObj().getBlockId(x1, y1, z1) == Blocks.blockWindmill.blockID))
    {
      y1++;
    }
    
    int x2 = tileentity.xCoord; int y2 = tileentity.yCoord; int z2 = tileentity.zCoord;
    

    int i = 0;
    
    while ((tileentity.getWorldObj().getBlockId(x2, y2, z2) != Blocks.blockWindmillGround.blockID) && (i < 17))
    {
      y2--;
      i++;
    }
    
    int metadata = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
    
    int direction = 2;
    if (tileentity.getWorldObj().getBlockId(x2, y2, z2) == Blocks.blockWindmillGround.blockID)
    {
      direction = tileentity.getWorldObj().getBlockMetadata(x2, y2, z2) + 1;
      if (direction == 1) {
        direction = 3;
      }
      else if (direction == 3) {
        direction = 1;
      }
    }
    

    GL11.glPushMatrix();
    GL11.glDisable(2896);
    GL11.glTranslatef((float)x, (float)y, (float)z);
    
    GL11.glTranslatef(0.5F, 0.0F, 0.5F);
    GL11.glRotatef(direction * 90, 0.0F, 1.0F, 0.0F);
    GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
    
    Tessellator tessellator = new Tessellator();
    bindTextureByName("/rgbmod/windmill.png");
    tessellator.startDrawingQuads();
    
    if ((metadata >= 0) && (metadata <= 14))
    {
      tessellator.addVertexWithUV(4.0F * pixel, 0.0D, 1.0F - 4.0F * pixel, 8.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(4.0F * pixel, 1.0D, 1.0F - 4.0F * pixel, 8.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(4.0F * pixel, 1.0D, 4.0F * pixel, 0.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(4.0F * pixel, 0.0D, 4.0F * pixel, 0.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
      
      tessellator.addVertexWithUV(1.0F - 4.0F * pixel, 0.0D, 1.0F - 4.0F * pixel, 8.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(1.0F - 4.0F * pixel, 1.0D, 1.0F - 4.0F * pixel, 8.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(4.0F * pixel, 1.0D, 1.0F - 4.0F * pixel, 0.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(4.0F * pixel, 0.0D, 1.0F - 4.0F * pixel, 0.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
      
      tessellator.addVertexWithUV(4.0F * pixel, 0.0D, 4.0F * pixel, 8.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(4.0F * pixel, 1.0D, 4.0F * pixel, 8.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(1.0F - 4.0F * pixel, 1.0D, 4.0F * pixel, 0.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(1.0F - 4.0F * pixel, 0.0D, 4.0F * pixel, 0.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
      
      tessellator.addVertexWithUV(1.0F - 4.0F * pixel, 0.0D, 4.0F * pixel, 8.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(1.0F - 4.0F * pixel, 1.0D, 4.0F * pixel, 8.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(1.0F - 4.0F * pixel, 1.0D, 1.0F - 4.0F * pixel, 0.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
      tessellator.addVertexWithUV(1.0F - 4.0F * pixel, 0.0D, 1.0F - 4.0F * pixel, 0.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));


    }
    else if (metadata > 14)
    {
      bindTextureByName("/rgbmod/WindmillNacelle.png");
      
      tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0D, 1.0D);
      tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 1.0D, 0.0D);
      tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 0.0D, 0.0D);
      tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 0.0D, 1.0D);
      

      tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
      tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1.0D);
      tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 1.0D, 1.0D);
      tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 1.0D, 0.0D);
      
      tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 1.0D, 0.0D);
      tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
      tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 0.0D, 1.0D);
      tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 1.0D, 1.0D);
      
      tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 1.0D, 1.0D);
      tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 1.0D, 0.0D);
      tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 0.0D, 0.0D);
      tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
      
      tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 1.0D, 1.0D);
      tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
      tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 0.0D, 0.0D);
      tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 1.0D, 0.0D);
    }
    
    tessellator.draw();
    
    if (metadata > 14)
    {
      bindTextureByName("/rgbmod/WindmillNacelleLogo.png");
      tessellator.startDrawingQuads();
      

      tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0D, 0.0D);
      tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 0.0D, 0.0D);
      tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
      
      tessellator.draw();
    }
    
    if (metadata == -1)
    {
      bindTextureByName("/rgbmod/windmill2.png");
      tessellator.startDrawingQuads();
      
      tessellator.addVertexWithUV(pixel * 13.0F, pixel * 16.0F + 0.1D, pixel * 13.0F, 1.0D, 1.0D);
      tessellator.addVertexWithUV(pixel * 13.0F, pixel * 16.0F + 0.1D, pixel * 3.0F, 1.0D, 0.0D);
      tessellator.addVertexWithUV(pixel * 3.0F, pixel * 16.0F + 0.1D, pixel * 3.0F, 0.0D, 0.0D);
      tessellator.addVertexWithUV(pixel * 3.0F, pixel * 16.0F + 0.1D, pixel * 13.0F, 0.0D, 1.0D);
      
      tessellator.addVertexWithUV(pixel * 13.0F, pixel * 14.0F + 0.1D, pixel * 13.0F, 1.0D, 0.20000000298023224D);
      tessellator.addVertexWithUV(pixel * 13.0F, pixel * 16.0F + 0.1D, pixel * 13.0F, 1.0D, 0.0D);
      tessellator.addVertexWithUV(pixel * 3.0F, pixel * 16.0F + 0.1D, pixel * 13.0F, 0.0D, 0.0D);
      tessellator.addVertexWithUV(pixel * 3.0F, pixel * 14.0F + 0.1D, pixel * 13.0F, 0.0D, 0.20000000298023224D);
      
      tessellator.addVertexWithUV(pixel * 3.0F, pixel * 14.0F + 0.1D, pixel * 3.0F, 1.0D, 0.20000000298023224D);
      tessellator.addVertexWithUV(pixel * 3.0F, pixel * 16.0F + 0.1D, pixel * 3.0F, 1.0D, 0.0D);
      tessellator.addVertexWithUV(pixel * 13.0F, pixel * 16.0F + 0.1D, pixel * 3.0F, 0.0D, 0.0D);
      tessellator.addVertexWithUV(pixel * 13.0F, pixel * 14.0F + 0.1D, pixel * 3.0F, 0.0D, 0.20000000298023224D);
      
      tessellator.addVertexWithUV(pixel * 13.0F, pixel * 14.0F + 0.1D, pixel * 3.0F, 1.0D, 0.20000000298023224D);
      tessellator.addVertexWithUV(pixel * 13.0F, pixel * 16.0F + 0.1D, pixel * 3.0F, 1.0D, 0.0D);
      tessellator.addVertexWithUV(pixel * 13.0F, pixel * 16.0F + 0.1D, pixel * 13.0F, 0.0D, 0.0D);
      tessellator.addVertexWithUV(pixel * 13.0F, pixel * 14.0F + 0.1D, pixel * 13.0F, 0.0D, 0.20000000298023224D);
      
      tessellator.addVertexWithUV(pixel * 3.0F, pixel * 14.0F + 0.1D, pixel * 13.0F, 1.0D, 0.20000000298023224D);
      tessellator.addVertexWithUV(pixel * 3.0F, pixel * 16.0F + 0.1D, pixel * 13.0F, 1.0D, 0.0D);
      tessellator.addVertexWithUV(pixel * 3.0F, pixel * 16.0F + 0.1D, pixel * 3.0F, 0.0D, 0.0D);
      tessellator.addVertexWithUV(pixel * 3.0F, pixel * 14.0F + 0.1D, pixel * 3.0F, 0.0D, 0.20000000298023224D);
      
      tessellator.draw();
    }
    
    if (metadata == 15) drawRotor(tileentity);
    GL11.glEnable(2896);
    GL11.glPopMatrix();
  }
  
  private void drawRotor(TileEntity tileentity)
  {
    WindmillTileEntity windmill = (WindmillTileEntity)tileentity.getWorldObj().getBlockTileEntity(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
    
    GL11.glTranslatef(0.0F, 0.5F, 0.5F);
    GL11.glRotatef(windmill.rotation, 1.0F, 0.0F, 0.0F);
    GL11.glTranslatef(0.0F, -0.5F, -0.5F);
    
    GL11.glColor3f(247.0F, 247.0F, 247.0F);
    
    Tessellator tessellator = new Tessellator();
    bindTextureByName("/rgbmod/windmill.png");
    tessellator.startDrawingQuads();
    
    tessellator.addVertexWithUV(-2.0F * pixel, 0.5F + 1.0F * pixel, 2.5D * pixel + 0.5D, 10.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, 6.0D, 1.0F * pixel + 0.5F, 10.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, 6.0D, -1.0F * pixel + 0.5F, 9.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, 0.5F + 1.0F * pixel, -2.5D * pixel + 0.5D, 9.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
    
    tessellator.addVertexWithUV(-2.0F * pixel, -5.0D, 1.0F * pixel + 0.5F, 10.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, 0.5F - 1.0F * pixel, 2.5F * pixel + 0.5F, 10.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, 0.5F - 1.0F * pixel, -2.5F * pixel + 0.5F, 9.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, -5.0D, -1.0F * pixel + 0.5F, 9.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
    










    tessellator.addVertexWithUV(-2.0F * pixel, 0.5F + 1.0F * pixel, -2.5D * pixel + 0.5D, 9.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, 6.0D, -1.0F * pixel + 0.5F, 9.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, 6.0D, 1.0F * pixel + 0.5F, 10.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, 0.5F + 1.0F * pixel, 2.5D * pixel + 0.5D, 10.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
    
    tessellator.addVertexWithUV(-2.0F * pixel, -5.0D, -1.0F * pixel + 0.5F, 9.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, 0.5F - 1.0F * pixel, -2.5F * pixel + 0.5F, 9.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, 0.5F - 1.0F * pixel, 2.5F * pixel + 0.5F, 10.0F * (1.0F / textureWidth), 0.0F * (1.0F / textureHeight));
    tessellator.addVertexWithUV(-2.0F * pixel, -5.0D, 1.0F * pixel + 0.5F, 10.0F * (1.0F / textureWidth), 1.0F * (1.0F / textureHeight));
    















    tessellator.draw();
    
    bindTextureByName("/rgbmod/windmill2.png");
    tessellator.startDrawingQuads();
    
    tessellator.addVertexWithUV(-2.0F * pixel, 7.0F * pixel, 9.0F * pixel, 0.6000000238418579D, 0.6000000238418579D);
    tessellator.addVertexWithUV(-2.0F * pixel, 9.0F * pixel, 9.0F * pixel, 0.6000000238418579D, 0.4000000059604645D);
    tessellator.addVertexWithUV(-2.0F * pixel, 9.0F * pixel, 7.0F * pixel, 0.4000000059604645D, 0.4000000059604645D);
    tessellator.addVertexWithUV(-2.0F * pixel, 7.0F * pixel, 7.0F * pixel, 0.4000000059604645D, 0.6000000238418579D);
    
    tessellator.addVertexWithUV(-2.0F * pixel, 7.0F * pixel, 7.0F * pixel, 0.6000000238418579D, 0.6000000238418579D);
    tessellator.addVertexWithUV(-2.0F * pixel, 9.0F * pixel, 7.0F * pixel, 0.6000000238418579D, 0.4000000059604645D);
    tessellator.addVertexWithUV(0.0F * pixel, 9.0F * pixel, 7.0F * pixel, 0.4000000059604645D, 0.4000000059604645D);
    tessellator.addVertexWithUV(0.0F * pixel, 7.0F * pixel, 7.0F * pixel, 0.4000000059604645D, 0.6000000238418579D);
    
    tessellator.addVertexWithUV(0.0F * pixel, 7.0F * pixel, 9.0F * pixel, 0.6000000238418579D, 0.4000000059604645D);
    tessellator.addVertexWithUV(0.0F * pixel, 9.0F * pixel, 9.0F * pixel, 0.6000000238418579D, 0.6000000238418579D);
    tessellator.addVertexWithUV(-2.0F * pixel, 9.0F * pixel, 9.0F * pixel, 0.4000000059604645D, 0.6000000238418579D);
    tessellator.addVertexWithUV(-2.0F * pixel, 7.0F * pixel, 9.0F * pixel, 0.4000000059604645D, 0.4000000059604645D);
    
    tessellator.addVertexWithUV(0.0F * pixel, 9.0F * pixel, 9.0F * pixel, 0.6000000238418579D, 0.6000000238418579D);
    tessellator.addVertexWithUV(0.0F * pixel, 9.0F * pixel, 7.0F * pixel, 0.6000000238418579D, 0.4000000059604645D);
    tessellator.addVertexWithUV(-2.0F * pixel, 9.0F * pixel, 7.0F * pixel, 0.4000000059604645D, 0.4000000059604645D);
    tessellator.addVertexWithUV(-2.0F * pixel, 9.0F * pixel, 9.0F * pixel, 0.4000000059604645D, 0.6000000238418579D);
    
    tessellator.addVertexWithUV(-2.0F * pixel, 7.0F * pixel, 9.0F * pixel, 0.4000000059604645D, 0.4000000059604645D);
    tessellator.addVertexWithUV(-2.0F * pixel, 7.0F * pixel, 7.0F * pixel, 0.4000000059604645D, 0.6000000238418579D);
    tessellator.addVertexWithUV(0.0F * pixel, 7.0F * pixel, 7.0F * pixel, 0.6000000238418579D, 0.6000000238418579D);
    tessellator.addVertexWithUV(0.0F * pixel, 7.0F * pixel, 9.0F * pixel, 0.6000000238418579D, 0.4000000059604645D);
    

    tessellator.draw();
  }
}
