package net.nyko;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.nyko.common.ModBeaconContainer;
import net.nyko.common.ModBeaconTileEntity;

@Mod(Nyko.Mod_Id)
public class Nyko {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String Mod_Id = "nyko";
	public static final String Minecraft_Id = "minecraft";
	
	public Nyko() {
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		Registry.BLOCKS.register(modEventBus);
		Registry.ITEMS.register(modEventBus);
		Registry.CONTAINERS.register(modEventBus);
		Registry.TILE_ENTITIES.register(modEventBus);
		
	}
	
	private void setup(FMLCommonSetupEvent event) {
		
	}
	
	private void doClientStuff(FMLClientSetupEvent event) {
		
	}
	
	public static class Registry {
		
		public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Nyko.Minecraft_Id);
		public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nyko.Minecraft_Id);
		public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Nyko.Mod_Id);
		public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Nyko.Mod_Id);
		
		public static final RegistryObject<Block> BEACON_BLOCK = BLOCKS.register("beacon", 
				() -> new net.nyko.common.ModBeacon(AbstractBlock.Properties.from(Blocks.BEACON)));
		
		public static final RegistryObject<Item> BEACON_ITEM = ITEMS.register("beacon", 
				() -> new BlockItem(Registry.BEACON_BLOCK.get(), new Item.Properties().group(ItemGroup.MISC)));
		
		public static final RegistryObject<ContainerType<ModBeaconContainer>> BEACON_CONTAINER = CONTAINERS.register("beacon", 
				() -> IForgeContainerType.create(ModBeaconContainer::new));
		
		public static final RegistryObject<TileEntityType<ModBeaconTileEntity>> BEACON_TILE_ENTITY = TILE_ENTITIES.register("beacon", 
				() -> TileEntityType.Builder.create(ModBeaconTileEntity::new, Registry.BEACON_BLOCK.get()).build(null));
		
	}

}

