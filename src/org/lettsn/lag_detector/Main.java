package org.lettsn.lag_detector;

import arc.*;
import arc.util.*;
import mindustry.game.*;
import mindustry.gen.Player;
import mindustry.mod.*;
import org.lettsn.lag_detector.V7.Variables.*;

import static org.lettsn.lag_detector.V7.Variables.Configs.minimumTPS;
import static org.lettsn.lag_detector.V7.Variables.Constants.TPSError;
import static org.lettsn.lag_detector.V7.Utilities.CheckTPS.checkTPS;
import static org.lettsn.lag_detector.V7.Utilities.KillMethods.runAll;

@SuppressWarnings("unused")
public class Main extends Plugin{
    @Override
    public void init() {
        Configs.load();

        if (!minimumTPS.isNum()) {
            Log.err(TPSError);
        }

        Events.on(EventType.PlayerConnect.class, ignored -> checkTPS());
    }

    @Override
    public void registerClientCommands(CommandHandler handler) {
        handler.register("check-tps", "Checks the server TPS. If it is below a threshold, then it will" +
        " kill all units and payload sources.", (args, player) -> checkTPS());

        handler.<Player>register("force-clean", "Removes all units, turrets, and payload sources. Do NOT run " +
                "this command unless absolutely necessary.", (args, player) -> {
            if (!player.admin()) {
                player.sendMessage("[scarlet]You do not have permission to run this command!");
                return;
            }

            runAll();
        });
    }
}
