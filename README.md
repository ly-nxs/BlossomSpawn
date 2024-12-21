# Fabric /Spawn

Fabric /spawn is a Server-Side Minecraft Fabric mod using Blossom-Lib that provides /spawn command and utilities

## Table of contents

- [Dependencies](#dependencies)
- [Config](#config)


## Dependencies

* [BlossomLib](https://github.com/BlossomMods/BlossomLib)
* [fabric-permissions-api](https://github.com/lucko/fabric-permissions-api) / [LuckPerms](https://luckperms.net/) /
  etc. (Optional)

## Config

This mod's config file can be found at `config/BlossomMods/BlossomSpawn.json`, after running the server with
the mod at least once.

`teleportation`: [TeleportationConfig](https://github.com/BlossomMods/BlossomLib/blob/main/README.md#teleportationconfig) -
teleportation settings  
`standStill`: int - (seconds), how long the player has to stand still before being teleported  
`cooldown`: int - (seconds), how long the player has to wait after teleporting using this command, before
being able to teleport again  
`spawnPos`: X: double X coordinate etc...
`world`: String - world  registry key - like overworld, or the_nether
`dimensionBlacklist`: String[] - a list of dimension ids (like `minecraft:the_end`) in which a player can't set a home
`useBlacklistAsWhitelist`: boolean - invert blacklist to function as a whitelist  
`fallbackToPlayerSpawnPoint`: boolean - use player spawn point if no default home set

