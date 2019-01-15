package it.lor54.rgb.entities;

import java.util.Random;

import it.lor54.rgb.blocks.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class WindmillTileEntity extends TileEntity 
{
	private boolean enabled = true;
	public float rotation = 0;
	private boolean checkBiome = true, first = true;
	private String biome;
	public int maxPower = 100;
	int countMedio = 0, countBasso = 0, countAlto = 0, old = 1;
	int tick = 100;
	private boolean cambia = false, day = true;
	public double var = 0, vento = 1;
	private int random = 3;
	
	public void updateEntity()
	{	
		//if(this.getWorldObj().getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord).getBlockMetadata() == 15)
		
		if(enabled)
		{
			if(this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord + 1, this.zCoord) == null)
			{
				if(startDay() && day) 
				{
					random = randomInteger(1, 5);
					day = false;
				}
				if(endDay())
				{
					day = true;
				}
				
				if(checkBiome) 
				{
					biome = this.worldObj.getBiomeGenForCoordsBody(xCoord, zCoord).biomeName;
					checkBiome = false;
				}
				
				if(biome == "Forest" || biome == "ForestHills")
				{
					if(!thermalInversion())
					{
						if(isRaining())
						{
							vento = randomInt(5, 6, "medium");
						}
						else
						{
							if(isThundering())
							{
								vento = randomInt(5, 6, "medium");
							}
							else
							{
								if(!isNight())
								{
									vento = randomInt(1, 3, "medium");
								}
								else
								{
									vento = randomInt(0, 2, "medium");
								}
							}
						}
					}
					else
					{
						if(isRaining())
						{
							vento = randomInt(5, 6, "medium");
						}
						else
						{
							if(isThundering())
							{
								vento = randomInt(5, 6, "medium");
							}
							else
							{
								vento = randomInt(0, 1, "low");
							}
						}
					}
				}
				else
				{
					if(biome == "Desert" || biome == "DesertHills")
					{
						if(!thermalInversion())
						{
							if(isRaining())
							{
								vento = randomInt(6, 7, "low");
							}
							else
							{
								if(isThundering())
								{
									vento = randomInt(6, 7, "low");
								}
								else
								{
									if(!isNight())
									{
										vento = randomInt(0, 1, "low");
									}
									else
									{
										vento = randomInt(0, 1, "low");
									}
								}
							}
						}
						else
						{
							if(isRaining())
							{
								vento = randomInt(6, 7, "low");
							}
							else
							{
								if(isThundering())
								{
									vento = randomInt(6, 7, "low");
								}
								else
								{
									vento = randomInt(0, 1, "low");
								}
							}
						}
					}
					else
					{
						if(biome == "Plains" || biome == "River")
						{
							if(!thermalInversion())
							{
								if(isRaining())
								{
									vento = randomInt(2, 4, "low");
								}
								else
								{
									if(isThundering())
									{
										vento = randomInt(3, 5, "low");
									}
									else
									{
										if(!isNight())
										{
											vento = randomInt(0, 2, "low");
										}
										else
										{
											vento = randomInt(0, 2, "low");
										}
									}
								}
							}
							else
							{
								if(isRaining())
								{
									vento = randomInt(2, 4, "low");
								}
								else
								{
									if(isThundering())
									{
										vento = randomInt(3, 5, "low");
									}
									else
									{
										vento = randomInt(0, 1, "low");
									}
								}
							}
						}
						else
						{
							if(biome == "Swampland")
							{
								vento = randomInt(0, 1, "low");
							}
							else
							{
								if(biome == "Jungle" || biome == "JungleHills")
								{
									if(!thermalInversion())
									{
										if(isRaining())
										{
											vento = randomInt(7, 9, "low");
										}
										else
										{
											if(isThundering())
											{
												vento = randomInt(7, 9, "low");
											}
											else
											{
												if(!isNight())
												{
													vento = randomInt(0, 1, "low");
												}
												else
												{
													vento = randomInt(0, 1, "low");
												}
											}
										}
									}
									else
									{
										if(isRaining())
										{
											vento = randomInt(7, 9, "low");
										}
										else
										{
											if(isThundering())
											{
												vento = randomInt(7, 9, "low");
											}
											else
											{
												vento = randomInt(0, 1, "low");
											}
										}
									}
								}
								else
								{
									if(biome == "Tundra" || biome == "Ice Mountains" || biome == "Ice Plains" || biome == "FrozenOcean" || biome == "FrozenRiver")
									{
										if(isRaining())
										{
											vento = randomInt(6, 7, "medium");
										}
										else
										{
											if(isThundering())
											{
												vento = randomInt(8, 10, "medium");
											}
											else
											{
												if(!isNight())
												{
													vento = randomInt(4, 5, "medium");
												}
												else
												{
													vento = randomInt(4, 5, "medium");
												}
											}
										}
									}
									else
									{
										if(biome == "Taiga" || biome == "TaigaHills")
										{
											if(!thermalInversion())
											{
												if(isRaining())
												{
													vento = randomInt(5, 6, "medium");
												}
												else
												{
													if(isThundering())
													{
														vento = randomInt(5, 6, "medium");
													}
													else
													{
														if(!isNight())
														{
															vento = randomInt(1, 3, "medium");
														}
														else
														{
															vento = randomInt(0, 2, "medium");
														}
													}
												}
											}
											else
											{
												if(isRaining())
												{
													vento = randomInt(5, 6, "medium");
												}
												else
												{
													if(isThundering())
													{
														vento = randomInt(5, 6, "medium");
													}
													else
													{
														vento = randomInt(0, 1, "low");
													}
												}
											}
										}
										else
										{
											if(biome == "Extreme Hills" || biome == "Extreme Hills Edge")
											{
												if(!thermalInversion())
												{
													if(isRaining())
													{
														vento = randomInt(4, 6, "medium");
													}
													else
													{
														if(isThundering())
														{
															vento = randomInt(4, 6, "medium");
														}
														else
														{
															if(!isNight())
															{
																vento = randomInt(3, 4, "medium");
															}
															else
															{
																vento = randomInt(3, 4, "medium");
															}
														}
													}
												}
												else
												{
													if(isRaining())
													{
														vento = randomInt(4, 6, "medium");
													}
													else
													{
														if(isThundering())
														{
															vento = randomInt(4, 6, "medium");
														}
														else
														{
															vento = randomInt(0, 1, "low");
														}
													}
												}
											}
											else
											{
												if(biome == "Ocean" || biome == "Olive Plains" || biome == "OlivePlains")
												{
													if(isRaining())
													{
														vento = randomInt(6, 8, "low");
													}
													else
													{
														if(isThundering())
														{
														vento = randomInt(8, 11, "low");
														}
														else
														{
															if(!isNight())
															{
																vento = randomInt(4, 6, "low");
															}
															else
															{
																vento = randomInt(4, 6, "low");
															}
														}
													}
												}
												else
												{
													if(biome == "MushroomIsland" || biome == "MushroomIslandShore")
													{
														if(isRaining())
														{
															vento = randomInt(6, 8, "low");
														}
														else
														{
															if(isThundering())
															{
																vento = randomInt(8, 11, "low");
															}
															else
															{
																if(!isNight())
																{
																	vento = randomInt(4, 6, "low");
																}
																else
																{
																	vento = randomInt(4, 6, "low");
																}
															}
														}
													}
													else
													{
														if(biome == "Beach")
														{
															if(!thermalInversion())
															{
																if(isRaining())
																{
																	vento = randomInt(6, 7, "high");
																}
																else
																{
																	if(isThundering())
																	{
																		vento = randomInt(7, 10, "high");
																	}
																	else
																	{
																		if(!isNight())
																		{
																			vento = randomInt(2, 4, "high");
																		}
																		else
																		{
																			vento = randomInt(1, 3, "high");
																		}
																	}
																}
															}
															else
															{
																if(isRaining())
																{
																	vento = randomInt(6, 7, "high");
																}
																else
																{
																	if(isThundering())
																	{
																		vento = randomInt(7, 10, "high");
																	}
																	else
																	{
																		vento = randomInt(0, 1, "low");
																	}
																}
															}
														}
													}
												}	
											}
										}
									}
								}
							}
						}
					}
				}
				
				if(random == 1)
				{
					var = (vento/100)*15;
					vento -= var;
					rotation += vento;
				}
				else
				{
					if(random == 2)
					{
						var = (vento/100)*7;
						vento -= var;
						rotation += vento;
					}
					else
					{
						if(random == 3)
						{
							rotation += vento;
						}
						else
						{
							if(random == 4)
							{
								var = (vento/100)*7;
								vento += var;
								rotation += vento;
							}
							else
							{
								var = (vento/100)*15;
								vento += var;
								rotation += vento;
							}
						}
					}
				}
			}
		}
		
		//System.out.println("random: " + random + " " + (vento));
	}
	
	private int randomInt(int min, int max, String variation)
	{
		//old = randomInteger(min, max);
		
		int vento = randomInteger(min, max);
		if(first) 
		{
			old = vento;
			first = false;
		}
		
		if(variation == "high")
		{
			if(countAlto < 60)
			{
				vento = old;
				countAlto++;
			}
			else
			{
				vento = randomInteger(min, max);
				old = vento;
				countAlto = 0;
			}
		}
		else
		{
			if(variation == "medium")
			{
				if(countMedio < 170)
				{
					vento = old;
					countMedio++;
				}
				else
				{
					vento = randomInteger(min, max);
					old = vento;
					countMedio = 0;
				}
			}
			else
			{
				if(countBasso < 300)
				{
					vento = old;
					countBasso++;	
				}
				else
				{
					vento = randomInteger(min, max);
					old = vento;
					countBasso = 0;
				}
			}
		}
		
		
		//System.out.println("countBasso: " + countBasso + "countAlto: " + countAlto +"countMedio: " + countMedio + "vento: " + vento + "old: " + old + " inversione: " + thermalInversion() + "time: " + this.worldObj.getWorldTime());
		return vento;
	}
	
	private int randomInteger(int min, int max)
	{
		Random rand = new Random();
	    return rand.nextInt((max - min) + 1) + min;
	}
	
	private boolean isNight(){
		long time = this.worldObj.getWorldTime();
		if(time > 12500)
		{
			return true;
		}
		return false;
	}
	
	private boolean isRaining()
	{
		if(this.worldObj.isRaining())
		{
			return true;
		}
		return false;
	}
	
	public void setInactive()
	{
		this.enabled = false;
		this.worldObj.removeBlockTileEntity(this.xCoord, this.yCoord, this.zCoord);
		invalidate();
	}

	private boolean isThundering()
	{
		if(this.worldObj.isThundering())
		{
			return true;
		}
		return false;
	}
	
	private boolean thermalInversion()
	{
		long time = this.worldObj.getWorldTime();
		if((time >= 23500 && time <= 24500) || (time <= 500))
			return true;
		return false;
	}
	
	private boolean startDay()
	{
		long time = this.worldObj.getWorldTime();
		if(time == 0 || time == 24000)
		{
			return true;
		}
		return false;
	}
	
	private boolean endDay()
	{
		long time = this.worldObj.getWorldTime();
		if(time == 23999)
		{
			return true;
		}
		return false;
	}
}
