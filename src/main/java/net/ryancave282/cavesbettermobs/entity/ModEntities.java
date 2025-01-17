package net.ryancave282.cavesbettermobs.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ryancave282.cavesbettermobs.CavesBetterMobs;
import net.ryancave282.cavesbettermobs.entity.custom.ZombieEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static ResourceKey<? extends Registry<EntityType<?>>> zombieResourceKey =
        ResourceKey.createRegistryKey(resourceLocation("zombie"));

    public static ResourceLocation resourceLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(CavesBetterMobs.MODID,path);
    }

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CavesBetterMobs.MODID);


    public static ResourceKey<EntityType<?>> zombie =
            ResourceKey.create(zombieResourceKey, resourceLocation("zombie"));

    public static final Supplier<EntityType<ZombieEntity>> ZOMBIE =
        ENTITY_TYPES.register("zombie", () -> EntityType.Builder.of(ZombieEntity::new, MobCategory.MONSTER)
                .sized(0.75f, 0.35f).build(zombie));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
