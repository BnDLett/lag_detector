package org.lettsn.lag_detector.V7.Utilities;

import arc.*;
import arc.util.*;
import mindustry.gen.*;

import static org.lettsn.lag_detector.V7.Variables.Configs.minimumTPS;
import static org.lettsn.lag_detector.V7.Variables.Constants.*;
import static org.lettsn.lag_detector.V7.Utilities.KillMethods.*;

public class CheckTPS{
    public static void checkTPS(){
        int tps = Math.min(Core.graphics.getFramesPerSecond(), 255);

        if (!minimumTPS.isNum()) {
            Log.err(TPSError);
            return;
        }

        if (minimumTPS.num() <= 0) {
            Log.warn(String.format("The minimum TPS provided (%d) is below or equal to zero. " +
            "The plugin may not function as intended.", minimumTPS.num()));
            return;
        }

        if (tps > minimumTPS.num()) {
            return;
        }

        Call.sendMessage(String.format("%s: Killing all potential lag sources due to low TPS.", pluginMessageName));
        runAll();
    }
}
