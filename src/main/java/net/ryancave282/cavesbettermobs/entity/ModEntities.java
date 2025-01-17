package net.ryancave282.cavesbettermobs.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ryancave282.cavesbettermobs.CavesBetterMobs;
import net.ryancave282.cavesbettermobs.entity.custom.ZombieEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CavesBetterMobs.MODID);

    public static final Supplier<EntityType<ZombieEntity>> ZOMBIE =
            ENTITY_TYPES.register("zombie", () -> EntityType.Builder.of(ZombieEntity::new, MobCategory.MONSTER)
                    .sized(1f,1f).build("zombie"));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
