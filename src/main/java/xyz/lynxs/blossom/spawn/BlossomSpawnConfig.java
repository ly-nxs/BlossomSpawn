package xyz.lynxs.blossom.spawn;


import dev.codedsakura.blossom.lib.teleport.TeleportConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;


public class BlossomSpawnConfig {
    static class TeleportProps {
        boolean enabled = true;

        TeleportConfig teleportation = null;

        int standStill = 5;
        int cooldown = 120;

        boolean usePlayerRotation = true;

        float yaw = 0f;
        float pitch = 0f;

        Vec3d spawnPos = new Vec3d(0.0, 64.0, 0.0);
        Identifier world = Identifier.of("minecraft", "overworld");

        TeleportProps() {
            // For default values in GSON serialization
        }

        public TeleportProps(boolean enabled, int standStill, int cooldown) {
            this.enabled = enabled;
            this.standStill = standStill;
            this.cooldown = cooldown;
        }

    }

    TeleportProps spawn = new TeleportProps(true, 5, 120);

}
