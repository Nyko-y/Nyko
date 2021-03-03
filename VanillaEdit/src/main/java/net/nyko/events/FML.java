package net.nyko.events;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.nyko.Nyko;
import net.nyko.client.ModBeaconScreen;
import net.nyko.client.ModBeaconTileEntityRender;

@Mod.EventBusSubscriber(modid=Nyko.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FML {
	
	@SubscribeEvent
	public static void doCommonSetup(FMLCommonSetupEvent event) {
		
		event.enqueueWork(() -> ScreenManager.registerFactory(Nyko.Registry.BEACON_CONTAINER.get(), ModBeaconScreen::new));
		ClientRegistry.bindTileEntityRenderer(Nyko.Registry.BEACON_TILE_ENTITY.get(), ModBeaconTileEntityRender::new);
		
	}
	
}

