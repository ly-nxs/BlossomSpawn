package dev.codedsakura.blossom.spawn;


import dev.codedsakura.blossom.lib.BlossomLib;
import dev.codedsakura.blossom.lib.config.ConfigManager;
import dev.codedsakura.blossom.lib.permissions.Permissions;
import dev.codedsakura.blossom.lib.teleport.TeleportUtils;
import dev.codedsakura.blossom.lib.utils.CustomLogger;
import net.fabricmc.api.ModInitializer;

import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;

import net.minecraft.util.Identifier;
import org.apache.logging.log4j.core.Logger;

import java.util.Set;

import static net.minecraft.server.command.CommandManager.literal;

public class BlossomSpawn implements ModInitializer {
    static BlossomSpawnConfig CONFIG = ConfigManager.register(BlossomSpawnConfig.class, "BlossomSpawn.json", newConfig -> CONFIG = newConfig);
    public static final Logger LOGGER = CustomLogger.createLogger("BlossomSpawn");


    @Override
    public void onInitialize() {


        BlossomLib.addCommand(literal("spawn")
                .requires(Permissions.require("blossom.spawn", true))
                .executes(commandContext -> {
                    Set<PositionFlag> flags = Set.of(PositionFlag.X_ROT);
                    ServerCommandSource player = commandContext.getSource();
                    float yaw = CONFIG.playerYaw;
                    float pitch = CONFIG.playerPitch;

                    if(CONFIG.usePlayerRotation){
                        yaw = player.getPlayer().prevYaw;
                        pitch = player.getPlayer().prevPitch;
                    }
                    MinecraftServer server = player.getServer();
                    TeleportUtils.TeleportDestination dest = new TeleportUtils.TeleportDestination(server.getWorld(RegistryKey.of(RegistryKeys.WORLD, Identifier.of(CONFIG.world))), CONFIG.playerPos, yaw, pitch);
                    TeleportUtils.teleport(CONFIG.teleportation, CONFIG.standStill, player.getPlayer(), () -> dest);
                    return 1;
                }));
    }
}
