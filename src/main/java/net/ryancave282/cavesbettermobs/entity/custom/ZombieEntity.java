package net.ryancave282.cavesbettermobs.entity.custom;


import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.ryancave282.cavesbettermobs.CavesBetterMobs;

public class ZombieEntity extends Zombie {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private final Level level;



    public ZombieEntity(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
        this.level = level;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D);
    }



    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level.isClientSide) {
            this.setupAnimationStates();
        }
    }


}
