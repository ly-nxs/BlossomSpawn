package xyz.lynxs.blossom.spawn;


import dev.codedsakura.blossom.lib.teleport.TeleportConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;


public class BlossomSpawnConfig {
        public boolean enabled = true;

        public TeleportConfig teleportation = null;

        public int standStill = 5;
        public int cooldown = 120;

        public boolean usePlayerRotation = true;

        public float yaw = 0f;
        public float pitch = 0f;
        //world spawn if set to 0.0 0.0 0.0
        public Vec3d spawnPos = new Vec3d(0.0, 0.0, 0.0);
        public Identifier world = Identifier.of("minecraft", "overworld");
}
