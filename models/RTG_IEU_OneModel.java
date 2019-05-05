package it.lor54.rgb.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RTG_IEU_OneModel extends ModelBase
{
    ModelRenderer RTGBioShield;
    ModelRenderer RTGCentro;
    ModelRenderer RTGDissi1;
    ModelRenderer RTGDissi2;
    ModelRenderer RTGDissi4;
    ModelRenderer RTGDissi5;
    ModelRenderer RTGDissi6A;
    ModelRenderer RTGDissi7A;
    ModelRenderer RTGDissi8A;
    ModelRenderer RTGDissi10A;
    ModelRenderer RTGDissi2A;
    ModelRenderer RTGDissi3A;
    ModelRenderer RTGDissi11A;
    ModelRenderer RTGDissi12A;
    ModelRenderer RTGDissi13A;
    ModelRenderer RTGDissi14A;
    ModelRenderer RTGDissi15A;
    ModelRenderer RTGDissi16A;
    ModelRenderer RTGDissi17A;
  
  public RTG_IEU_OneModel()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      RTGBioShield = new ModelRenderer(this, 0, 0);
      RTGBioShield.addBox(0F, 0F, 0F, 8, 16, 8);
      RTGBioShield.setRotationPoint(-4F, 8F, -4F);
      RTGBioShield.setTextureSize(64, 32);
      RTGBioShield.mirror = true;
      setRotation(RTGBioShield, 0F, 0F, 0F);
      RTGCentro = new ModelRenderer(this, 0, 0);
      RTGCentro.addBox(-5F, 1F, -5F, 10, 13, 14);
      RTGCentro.setRotationPoint(0F, 10F, -2F);
      RTGCentro.setTextureSize(64, 32);
      RTGCentro.mirror = true;
      setRotation(RTGCentro, 0F, 0F, 0F);
      RTGDissi1 = new ModelRenderer(this, 0, 0);
      RTGDissi1.addBox(0F, 0F, 0F, 1, 13, 16);
      RTGDissi1.setRotationPoint(4F, 11F, -8F);
      RTGDissi1.setTextureSize(64, 32);
      RTGDissi1.mirror = true;
      setRotation(RTGDissi1, 0F, 0F, 0F);
      RTGDissi2 = new ModelRenderer(this, 0, 0);
      RTGDissi2.addBox(0F, 0F, 0F, 1, 13, 16);
      RTGDissi2.setRotationPoint(2F, 11F, -8F);
      RTGDissi2.setTextureSize(64, 32);
      RTGDissi2.mirror = true;
      setRotation(RTGDissi2, 0F, 0F, 0F);
      RTGDissi4 = new ModelRenderer(this, 0, 0);
      RTGDissi4.addBox(0F, 0F, 0F, 1, 13, 16);
      RTGDissi4.setRotationPoint(-3F, 11F, -8F);
      RTGDissi4.setTextureSize(64, 32);
      RTGDissi4.mirror = true;
      setRotation(RTGDissi4, 0F, 0F, 0F);
      RTGDissi5 = new ModelRenderer(this, 0, 0);
      RTGDissi5.addBox(0F, 1F, 0F, 1, 13, 16);
      RTGDissi5.setRotationPoint(-5F, 10F, -8F);
      RTGDissi5.setTextureSize(64, 32);
      RTGDissi5.mirror = true;
      setRotation(RTGDissi5, 0F, 0F, 0F);
      RTGDissi6A = new ModelRenderer(this, 0, 0);
      RTGDissi6A.addBox(0F, 0F, 0F, 3, 15, 1);
      RTGDissi6A.setRotationPoint(5F, 9F, -5F);
      RTGDissi6A.setTextureSize(64, 32);
      RTGDissi6A.mirror = true;
      setRotation(RTGDissi6A, 0F, 0F, 0F);
      RTGDissi7A = new ModelRenderer(this, 0, 0);
      RTGDissi7A.addBox(0F, 0F, 0F, 3, 15, 2);
      RTGDissi7A.setRotationPoint(-8F, 9F, -1F);
      RTGDissi7A.setTextureSize(64, 32);
      RTGDissi7A.mirror = true;
      setRotation(RTGDissi7A, 0F, 0F, 0F);
      RTGDissi8A = new ModelRenderer(this, 0, 0);
      RTGDissi8A.addBox(0F, 0F, 0F, 3, 15, 1);
      RTGDissi8A.setRotationPoint(5F, 9F, -3F);
      RTGDissi8A.setTextureSize(64, 32);
      RTGDissi8A.mirror = true;
      setRotation(RTGDissi8A, 0F, 0F, 0F);
      RTGDissi10A = new ModelRenderer(this, 0, 0);
      RTGDissi10A.addBox(0F, 0F, 0F, 3, 15, 1);
      RTGDissi10A.setRotationPoint(5F, 9F, 4F);
      RTGDissi10A.setTextureSize(64, 32);
      RTGDissi10A.mirror = true;
      setRotation(RTGDissi10A, 0F, 0F, 0F);
      RTGDissi2A = new ModelRenderer(this, 0, 0);
      RTGDissi2A.addBox(0F, 0F, 0F, 3, 15, 1);
      RTGDissi2A.setRotationPoint(5F, 9F, 2F);
      RTGDissi2A.setTextureSize(64, 32);
      RTGDissi2A.mirror = true;
      setRotation(RTGDissi2A, 0F, 0F, 0F);
      RTGDissi3A = new ModelRenderer(this, 0, 0);
      RTGDissi3A.addBox(0F, 0F, 0F, 2, 13, 16);
      RTGDissi3A.setRotationPoint(-1F, 11F, -8F);
      RTGDissi3A.setTextureSize(64, 32);
      RTGDissi3A.mirror = true;
      setRotation(RTGDissi3A, 0F, 0F, 0F);
      RTGDissi11A = new ModelRenderer(this, 0, 0);
      RTGDissi11A.addBox(0F, 0F, 0F, 3, 15, 1);
      RTGDissi11A.setRotationPoint(-8F, 9F, -7F);
      RTGDissi11A.setTextureSize(64, 32);
      RTGDissi11A.mirror = true;
      setRotation(RTGDissi11A, 0F, 0F, 0F);
      RTGDissi12A = new ModelRenderer(this, 0, 0);
      RTGDissi12A.addBox(0F, 0F, 0F, 3, 15, 1);
      RTGDissi12A.setRotationPoint(-8F, 9F, 6F);
      RTGDissi12A.setTextureSize(64, 32);
      RTGDissi12A.mirror = true;
      setRotation(RTGDissi12A, 0F, 0F, 0F);
      RTGDissi13A = new ModelRenderer(this, 0, 0);
      RTGDissi13A.addBox(0F, 0F, 0F, 3, 15, 1);
      RTGDissi13A.setRotationPoint(-8F, 9F, -5F);
      RTGDissi13A.setTextureSize(64, 32);
      RTGDissi13A.mirror = true;
      setRotation(RTGDissi13A, 0F, 0F, 0F);
      RTGDissi14A = new ModelRenderer(this, 0, 0);
      RTGDissi14A.addBox(0F, 0F, 0F, 3, 15, 1);
      RTGDissi14A.setRotationPoint(-8F, 9F, -3F);
      RTGDissi14A.setTextureSize(64, 32);
      RTGDissi14A.mirror = true;
      setRotation(RTGDissi14A, 0F, 0F, 0F);
      RTGDissi15A = new ModelRenderer(this, 0, 0);
      RTGDissi15A.addBox(0F, 0F, 0F, 3, 15, 1);
      RTGDissi15A.setRotationPoint(-8F, 9F, 2F);
      RTGDissi15A.setTextureSize(64, 32);
      RTGDissi15A.mirror = true;
      setRotation(RTGDissi15A, 0F, 0F, 0F);
      RTGDissi16A = new ModelRenderer(this, 0, 0);
      RTGDissi16A.addBox(0F, 0F, 0F, 3, 15, 1);
      RTGDissi16A.setRotationPoint(-8F, 9F, 4F);
      RTGDissi16A.setTextureSize(64, 32);
      RTGDissi16A.mirror = true;
      setRotation(RTGDissi16A, 0F, 0F, 0F);
      RTGDissi17A = new ModelRenderer(this, 0, 0);
      RTGDissi17A.addBox(0F, 0F, 0F, 3, 15, 2);
      RTGDissi17A.setRotationPoint(5F, 9F, -1F);
      RTGDissi17A.setTextureSize(64, 32);
      RTGDissi17A.mirror = true;
      setRotation(RTGDissi17A, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    RTGBioShield.render(f5);
    RTGCentro.render(f5);
    RTGDissi1.render(f5);
    RTGDissi2.render(f5);
    RTGDissi4.render(f5);
    RTGDissi5.render(f5);
    RTGDissi6A.render(f5);
    RTGDissi7A.render(f5);
    RTGDissi8A.render(f5);
    RTGDissi10A.render(f5);
    RTGDissi2A.render(f5);
    RTGDissi3A.render(f5);
    RTGDissi11A.render(f5);
    RTGDissi12A.render(f5);
    RTGDissi13A.render(f5);
    RTGDissi14A.render(f5);
    RTGDissi15A.render(f5);
    RTGDissi16A.render(f5);
    RTGDissi17A.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
}
