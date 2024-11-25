package org.lettsn.lag_detector.V7.Variables;

import mindustry.net.*;
import mindustry.net.Administration.*;

public class Configs{
    public static Administration.Config minimumTPS;

    public static void load() {
        minimumTPS = new Config("minimumTPS", "The minimum TPS before the server is restarted.", 5);
    }
}
