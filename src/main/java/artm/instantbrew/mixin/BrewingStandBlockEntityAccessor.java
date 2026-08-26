package artm.instantbrew.mixin;

import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BrewingStandBlockEntity.class)
public interface BrewingStandBlockEntityAccessor {

    @Accessor("brewTime")
    int instantbrew$getBrewTime();

    @Accessor("brewTime")
    void instantbrew$setBrewTime(int brewTime);
}