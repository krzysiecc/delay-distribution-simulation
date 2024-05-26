package org.window;

import org.objects.Delay.AL;
import org.objects.Delay.ASRK;
import org.objects.Delay.WCZ;
import org.objects.Delay.ZWA;
import org.objects.Station;
import org.objects.Train.PassengerTrain;

public class Simulation {
    public static void main(String[] args) {

        AL ALInitialize = new AL(0.05F, 0.1F, 0, true, "Awaria lokomotywy");
        ASRK ASRKInitialize = new ASRK(0.3F, 0.35F,0, "Awaria urządzeń sterowania ruchem kolejowym");
        WCZ WCZInitialize = new WCZ(0.01F, 0.05F, true, "Wypadek z udziałem człowieka");
        ZWA ZWAInitilize = new ZWA(0.2F, 0.3F, false, "Złe warunki atmosferyczne");

        PassengerTrain IC1 = new PassengerTrain(50101, 160, 250, 350);
        PassengerTrain IC2 = new PassengerTrain(60101, 120, 125,230);
        Station S1 = new Station(1, 20, 30, 6, 5);
    }
}
