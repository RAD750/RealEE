package it.lor54.rgb.models;

import it.lor54.rgb.cables.AATCableTileEntity;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class RenderTableAATCable
  extends TileEntitySpecialRenderer
{
  boolean drawInside = true;
  float pixel = 0.0625F;
  float texturePixel = 0.03125F;
  
  public RenderTableAATCable() {}
  
  public void renderTileEntityAt(TileEntity tileentity, double translationX, double translationY, double translationZ, float f)
  {
    GL11.glTranslated(translationX, translationY, translationZ);
    GL11.glDisable(2896);
    bindTextureByName("/rgbmod/aatcable.png");
    
    AATCableTileEntity cable = (AATCableTileEntity)tileentity;
    
    if (!cable.onlyOneOpposite(cable.connections))
    {
      drawCore(tileentity);
      
      for (int i = 0; i < cable.connections.length; i++)
      {
        if (cable.connections[i] != null)
        {
          drawConnection(cable.connections[i]);
        }
      }
    }
    else
    {
      for (int i = 0; i < cable.connections.length; i++)
      {
        if (cable.connections[i] != null)
        {
          drawStraight(cable.connections[i]);
          break;
        }
      }
    }
    
    GL11.glEnable(2896);
    GL11.glTranslated(-translationX, -translationY, -translationZ);
  }
  
  public void drawStraight(ForgeDirection direction)
  {
    Tessellator tessellator = new Tessellator();
    tessellator.startDrawingQuads();
    
    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    if ((direction.equals(ForgeDirection.SOUTH)) || (direction.equals(ForgeDirection.NORTH)))
    {
      GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
    }
    else if ((direction.equals(ForgeDirection.WEST)) || (direction.equals(ForgeDirection.EAST)))
    {
      GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
    }
    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
    

    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 0.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 26.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 26.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 0.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
    
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 0.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 26.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 26.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 0.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
    
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 0.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 26.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 26.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 0.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
    
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 0.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 26.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 26.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 0.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
    
    if (drawInside)
    {
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 0.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 26.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 26.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 0.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 0.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 26.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 26.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 0.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 0.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 26.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 26.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 0.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 0.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 26.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 26.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 0.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
    }
    

    tessellator.draw();
    
    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    if ((direction.equals(ForgeDirection.SOUTH)) || (direction.equals(ForgeDirection.NORTH)))
    {
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
    }
    else if ((direction.equals(ForgeDirection.WEST)) || (direction.equals(ForgeDirection.EAST)))
    {
      GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
    }
    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
  }
  
  public void drawConnection(ForgeDirection direction)
  {
    Tessellator tessellator = new Tessellator();
    tessellator.startDrawingQuads();
    
    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    if (!direction.equals(ForgeDirection.UP))
    {


      if (direction.equals(ForgeDirection.DOWN))
      {
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      }
      else if (direction.equals(ForgeDirection.SOUTH))
      {
        GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      }
      else if (direction.equals(ForgeDirection.NORTH))
      {
        GL11.glRotatef(270.0F, 1.0F, 0.0F, 0.0F);
      }
      else if (direction.equals(ForgeDirection.WEST))
      {
        GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
      }
      else if (direction.equals(ForgeDirection.EAST))
      {
        GL11.glRotatef(270.0F, 0.0F, 0.0F, 1.0F); }
    }
    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
    

    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
    
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
    
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
    
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
    
    if (drawInside)
    {
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 11.0F * pixel / 2.0F, 10.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0D, 1.0F - 11.0F * pixel / 2.0F, 10.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    }
    


    tessellator.draw();
    
    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    if (!direction.equals(ForgeDirection.UP))
    {


      if (direction.equals(ForgeDirection.DOWN))
      {
        GL11.glRotatef(-180.0F, 1.0F, 0.0F, 0.0F);
      }
      else if (direction.equals(ForgeDirection.SOUTH))
      {
        GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      }
      else if (direction.equals(ForgeDirection.NORTH))
      {
        GL11.glRotatef(-270.0F, 1.0F, 0.0F, 0.0F);
      }
      else if (direction.equals(ForgeDirection.WEST))
      {
        GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
      }
      else if (direction.equals(ForgeDirection.EAST))
      {
        GL11.glRotatef(-270.0F, 0.0F, 0.0F, 1.0F); }
    }
    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
  }
  

  public void drawCore(TileEntity tileentity)
  {
    Tessellator tessellator = new Tessellator();
    tessellator.startDrawingQuads();
    
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
    
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
    
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
    
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
    
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
    
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
    tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
    
    if (drawInside)
    {
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
      
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 0.0F * texturePixel, 5.0F * texturePixel);
      tessellator.addVertexWithUV(1.0F - 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 0.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 5.0F * texturePixel, 0.0F * texturePixel);
      tessellator.addVertexWithUV(11.0F * pixel / 2.0F, 11.0F * pixel / 2.0F, 1.0F - 11.0F * pixel / 2.0F, 5.0F * texturePixel, 5.0F * texturePixel);
    }
    

    tessellator.draw();
  }
}
