package xyz.lynxs.blossom.spawn;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.codedsakura.blossom.lib.BlossomLib;
import dev.codedsakura.blossom.lib.config.ConfigManager;
import dev.codedsakura.blossom.lib.permissions.Permissions;
import dev.codedsakura.blossom.lib.teleport.TeleportUtils;
import dev.codedsakura.blossom.lib.utils.CustomLogger;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.apache.logging.log4j.core.Logger;

import static net.minecraft.server.command.CommandManager.literal;

public class BlossomSpawn implements ModInitializer {
    static BlossomSpawnConfig CONFIG = ConfigManager.register(BlossomSpawnConfig.class, "BlossomSpawn.json", newConfig -> CONFIG = newConfig);
    public static final Logger LOGGER = CustomLogger.createLogger("BlossomSpawn");

    @Override
    public void onInitialize() {



        BlossomLib.addCommand(literal("spawn")
                .requires(Permissions.require("blossom.spawn", true)
                        .and(p -> CONFIG.spawn.enabled))
                .executes(this::runSpawn));
    }

    private int runSpawn(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        ServerPlayerEntity player = ctx.getSource().getPlayerOrThrow();

        var destination = new TeleportUtils.TeleportDestination(player.getServer().getWorld(RegistryKey.of(RegistryKeys.WORLD, CONFIG.spawn.world)),
                CONFIG.spawn.spawnPos,
                CONFIG.spawn.usePlayerRotation ? player.lastYaw : CONFIG.spawn.yaw,
                CONFIG.spawn.usePlayerRotation ? player.lastPitch : CONFIG.spawn.pitch
        );

        LOGGER.info("spawn {} ({}) to {}", player.getName(), player.getUuid(), destination);

        TeleportUtils.teleport(
                CONFIG.spawn.teleportation,
                CONFIG.spawn.standStill,
                CONFIG.spawn.cooldown,
                BlossomSpawn.class,
                player,
                () -> destination
        );

        return Command.SINGLE_SUCCESS;
    }

}
