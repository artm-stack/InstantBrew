package artm.instantbrew.mixin;

import artm.instantbrew.InstantBrew;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingStandBlockEntity.class)
public class BrewingStandBlockEntityMixin {

    @Inject(
            method = "serverTick",
            at = @At("HEAD")
    )
    private static void instantbrew$finishBrewing(
            Level level,
            BlockPos pos,
            BlockState state,
            BrewingStandBlockEntity entity,
            CallbackInfo ci
    ) {
        if (!InstantBrew.CONFIG.enabled) {
            return;
        }
        BrewingStandBlockEntityAccessor accessor =
                (BrewingStandBlockEntityAccessor) entity;

        int currentTime = accessor.instantbrew$getBrewTime();
        int customTime = InstantBrew.CONFIG.brewTime;

        if (currentTime > customTime) {
            accessor.instantbrew$setBrewTime(customTime);
        }
    }
}