package org.dds.framework;

import org.dds.objects.Delay.AL;
import org.dds.objects.Delay.ASRK;
import org.dds.objects.Delay.WCZ;
import org.dds.objects.Delay.ZWA;
import org.dds.objects.Route;
import org.dds.objects.Station;
import org.dds.objects.Train.PassengerTrain;
import org.dds.objects.Train.Train;

import java.util.ArrayList;

public class Initialization {

    private static double mapWidth;
    private static double mapHeight;
    private static ArrayList<Train> trainsOnMap;
    private static ArrayList<Station> stations;
    private static ArrayList<Route> routes;

    public Initialization() {

        // edits only manual
        mapWidth  = 1200;
        mapHeight = 650;

        initializeObjects();
    }

    private static void initializeObjects() {

        AL ALInitialize = new AL(0.05F, 0.1F, 0, true, 401, "Awaria lokomotywy");
        ASRK ASRKInitialize = new ASRK(0.3F, 0.35F,0, 402, "Awaria urządzeń sterowania ruchem kolejowym");
        WCZ WCZInitialize = new WCZ(0.01F, 0.05F, true,501, "Wypadek z udziałem człowieka");
        ZWA ZWAInitilize = new ZWA(0.2F, 0.3F, false, 512, "Złe warunki atmosferyczne");

        // stations
        stations = new ArrayList<>();
        stations.add(new Station("POZNAŃ", 0.1 * mapWidth, 0.1 * mapHeight, 6, 5));
        stations.add(new Station("ŁÓDŹ", 0.5 * mapWidth, 0.4 * mapHeight, 6, 5));
        stations.add(new Station("WARSZAWA", 0.9 * mapWidth, 0.1 * mapHeight, 2, 3));
        stations.add(new Station("WROCŁAW", 0.1 * mapWidth, 0.8 * mapHeight, 2, 3));
        stations.add(new Station("OPOLE", 0.5 * mapWidth, 0.8 * mapHeight, 2, 3));
        stations.add(new Station("KATOWICE", 0.9 * mapWidth, 0.8 * mapHeight, 2, 3));

        // routes
        routes = new ArrayList<>();
        routes.add(new Route(true, 160, stations.get(0), stations.get(1)));
        routes.add(new Route(true, 160, stations.get(1), stations.get(2)));
        routes.add(new Route(true, 160, stations.get(0), stations.get(2)));

        routes.add(new Route(true, 160, stations.get(3), stations.get(4)));
        routes.add(new Route(true, 160, stations.get(4), stations.get(5)));

        routes.add(new Route(true, 160, stations.get(0), stations.get(3)));
        routes.add(new Route(false, 100, stations.get(1), stations.get(4)));

        // trains
        trainsOnMap = new ArrayList<>();
        trainsOnMap.add(new PassengerTrain(50101, 160, stations.get(0), stations.get(1), 200,350));
        trainsOnMap.add(new PassengerTrain(60101, 120, stations.get(3), stations.get(4),125,230));
    }

    public static ArrayList<Train> getTrainsOnMap() throws NullPointerException {
        return trainsOnMap;
    }
    public static ArrayList<Station> getStations() throws NullPointerException {
        return stations;
    }

    public static ArrayList<Route> getRoutes() throws NullPointerException {
        return routes;
    }
}
