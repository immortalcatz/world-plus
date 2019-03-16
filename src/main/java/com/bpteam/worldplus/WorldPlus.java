package com.bpteam.worldplus;

import com.bpteam.worldplus.init.ModBlocks;
import com.bpteam.worldplus.init.ModItems;
import com.bpteam.worldplus.proxy.CommonProxy;
import com.bpteam.worldplus.util.Reference;
import com.bpteam.worldplus.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = WorldPlus.MODID, name = WorldPlus.NAME, version = WorldPlus.VERSION,dependencies = WorldPlus.DEPENDENCIES, updateJSON = WorldPlus.UPDATEURL)
public class WorldPlus
{
    public static final String MODID = "worldplus";
    public static final String NAME = "World Plus";
    public static final String VERSION = "1.3";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.2.2638,)";
    public static final String UPDATEURL = "https://raw.githubusercontent.com/bpteammc/world-plus/master/update.json";

    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static CommonProxy proxy;

    public static CreativeTabs aitems = new CreativeTabs("aitems")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.WEAKER_ICE_BALL);
        }
    };

    public static CreativeTabs ablocks = new CreativeTabs("ablocks")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.RED_ICE);
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        RegistryHandler.PreInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}