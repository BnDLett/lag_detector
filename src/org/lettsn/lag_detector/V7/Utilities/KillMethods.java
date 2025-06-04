package org.lettsn.lag_detector.V7.Utilities;

import arc.struct.*;
import mindustry.content.*;
import mindustry.gen.*;
import mindustry.world.meta.BlockGroup;

public class KillMethods{
    // based on
    // https://github.com/mindustry-ddns-net/MapUtils/blob/master/src/main/java/xyz/semetrix/maputils/Commands/KillUnits/KillUnitsCommand.java
    // thanks, semetrix
    // (sorry to any randoms that have no access to that repository)
    static void runAll() {
        removeAllTurrets();
        removeAllPayloadSources();
        killAllUnits();
    }

    static void killAllUnits() {
        Seq<Unit> units = Groups.unit.copy(new Seq<>()).select(Unitc::isAI);

        units.forEach(Unitc::kill);
    }

    static void removeAllPayloadSources() {
        // weird java black magic. just know that it creates a sequence of all payload sources.
        Seq<Building> buildings = Groups.build.copy(new Seq<>()).select(building -> building.block == Blocks.payloadSource);

        buildings.forEach(Building::kill);
    }

    static void removeAllTurrets() {
        Seq<Building> turrets = Groups.build.copy(new Seq<>()).select(building ->
                building.block.group == BlockGroup.turrets);

        turrets.forEach(Building::kill);
    }
}
