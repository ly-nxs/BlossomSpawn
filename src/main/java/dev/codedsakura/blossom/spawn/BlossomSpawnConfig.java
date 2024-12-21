package dev.codedsakura.blossom.spawn;


import dev.codedsakura.blossom.lib.teleport.TeleportConfig;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


import java.util.List;

public class BlossomSpawnConfig {
    TeleportConfig teleportation = null;

    int standStill = 3;
    int cooldown = 30;
    String world = "overworld";

    Vec3d playerPos = new Vec3d(0, 64, 0);

    boolean usePlayerRotation = true;

    float playerYaw = 0f;

    float playerPitch = 0f;

    List<String> dimensionBlacklist = List.of();
    boolean useBlacklistAsWhitelist = false;


}
