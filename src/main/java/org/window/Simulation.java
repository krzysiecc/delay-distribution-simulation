package org.window;

import org.objects.Delay.*;
import org.objects.Route;
import org.objects.Station;
import org.objects.Train.PassengerTrain;

public class Simulation {
    public static void main(String[] args) {

		/*
		 * AL i ASRK są identyczne poza posiadaniem flagi stopsTrain,
		 * a WCZ i ZWA są dosłownie identyczne. Nie widzę potrzeby aby
		 * obydwa istniały kiedy można by stworzyć ogólny szablon dla
		 * podobnych sobie awarii. W końcu mamy tylko dwa rodzaje opóźnień:
		 * Losowe Awaryjne oraz Losowe wypadkowe.
		 * Z tego też, co pamiętam ASRK jest elementem niezakwalizfikowanym
		 * na początek symulacji, więc nie widzę potrzeby implementacji
		 * na tak wczesnym etapie.
		 */
        AL ALInitialize = new AL(0.05F, 0.1F, 0, true, 401, "Awaria lokomotywy");
        ASRK ASRKInitialize = new ASRK(0.3F, 0.35F,0, 402, "Awaria urządzeń sterowania ruchem kolejowym");
        WCZ WCZInitialize = new WCZ(0.01F, 0.05F, true,501, "Wypadek z udziałem człowieka");
        ZWA ZWAInitilize = new ZWA(0.2F, 0.3F, false, 512,"Złe warunki atmosferyczne");

        PassengerTrain IC1 = new PassengerTrain(50101, 160, 250, 350);
        PassengerTrain IC2 = new PassengerTrain(60101, 120, 125,230);

        Station S1 = new Station(1, "STACJA A", 20, 30, 6, 5);
        Station S2 = new Station(2, "STACJA B", 10, -10, 2, 3);

        Route R001 = new Route(true, 160, S1, S2);

    }
}
