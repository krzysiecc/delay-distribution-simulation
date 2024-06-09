package org.dds.framework;

import org.dds.objects.Delay.AL;
import org.dds.objects.Delay.ASRK;
import org.dds.objects.Delay.WCZ;
import org.dds.objects.Delay.ZWA;
import org.dds.objects.Route;
import org.dds.objects.Station;
import org.dds.objects.Train.PassengerTrain;

public class Initialization {

    private static void initializeObjects() {

        AL ALInitialize = new AL(0.05F, 0.1F, 0, true, 401, "Awaria lokomotywy");
        ASRK ASRKInitialize = new ASRK(0.3F, 0.35F,0, 402, "Awaria urządzeń sterowania ruchem kolejowym");
        WCZ WCZInitialize = new WCZ(0.01F, 0.05F, true,501, "Wypadek z udziałem człowieka");
        ZWA ZWAInitilize = new ZWA(0.2F, 0.3F, false, 512, "Złe warunki atmosferyczne");

        PassengerTrain IC1 = new PassengerTrain(50101, 160, 250, 350);
        PassengerTrain IC2 = new PassengerTrain(60101, 120, 125,230);

        Station S1 = new Station(1, "STACJA A", 20, 30, 6, 5);
        Station S2 = new Station(2, "STACJA B", 10, -10, 2, 3);

        Route R001 = new Route(true, 160, S1, S2);

    }

}
