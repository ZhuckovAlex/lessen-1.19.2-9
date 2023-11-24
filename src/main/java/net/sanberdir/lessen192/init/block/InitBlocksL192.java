package net.sanberdir.lessen192.init.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.lessen192.Lessen192;
import net.sanberdir.lessen192.init.ModCreativeModeTab;
import net.sanberdir.lessen192.init.block.custom.BurningBlock;
import net.sanberdir.lessen192.init.block.custom.BurningLeaves;
import net.sanberdir.lessen192.init.block.custom.FlameBlockRotate;
import net.sanberdir.lessen192.init.item.InitItems;
import net.sanberdir.lessen192.init.trees.CustomTree;

import java.util.function.Supplier;

public class InitBlocksL192 {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Lessen192.MOD_ID);

    public static final RegistryObject<Block> BLOCK_LESSEN = registerBlock("block_lessen",
            () -> new Block(BlockBehaviour.Properties.of(Material.BAMBOO)
                    .strength(1, 1).sound(SoundType.BAMBOO)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CUSTOM_PLANKS = registerBlock("custom_planks",
            () -> new BurningBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f, 15).sound(SoundType.WOOD)), ModCreativeModeTab.ITEMS_LESSEN);
    public static final RegistryObject<Block> CUSTOM_SAPLING = registerBlockWithoutBlockItem("custom_sapling",
            () -> new SaplingBlock(new CustomTree(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CUSTOM_LEAVES = registerBlockWithoutBlockItem("custom_leaves",
            () -> new BurningLeaves(BlockBehaviour.Properties.of(Material.PLANT)
                    .strength(0.1f, 2).sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> CUSTOM_LOG = registerBlock("custom_log",
            () -> new FlameBlockRotate(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.ITEMS_LESSEN);
    public static final RegistryObject<Block> CUSTOM_WOOD = registerBlock("custom_wood",
            () -> new FlameBlockRotate(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.ITEMS_LESSEN);

    public static final RegistryObject<Block> STRIPPED_CUSTOM_LOG = registerBlock("stripped_custom_log",
            () -> new FlameBlockRotate(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.ITEMS_LESSEN);
    public static final RegistryObject<Block> STRIPPED_CUSTOM_WOOD = registerBlock("stripped_custom_wood",
            () -> new FlameBlockRotate(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.ITEMS_LESSEN);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return InitItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
