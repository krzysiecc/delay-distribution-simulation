package org.dds.framework;

import org.dds.objects.DelayTypes.AL;
import org.dds.objects.DelayTypes.ASRK;
import org.dds.objects.DelayTypes.WCZ;
import org.dds.objects.DelayTypes.ZWA;
import org.dds.objects.Track;
import org.dds.objects.Station;
import org.dds.objects.Train;

import java.util.*;

import static org.dds.framework.Clock.ANIMATION_FRAME;

public class Initialization {

    /*
        The delay-triggers are initialized once as finals - changes aren't possible.
        All types are pre-stated and described in the official documentation (!)
    */
    public final static WCZ WCZInitialize = new WCZ(0.01F, 0.05F, 501, "Wypadek z udzialem czlowieka", new int[] {4, 8}, new double[]{0.08333333333333333333, 0.04166666666666666667});
    public final static ZWA ZWAInitilize = new ZWA(0.2F, 0.3F, 512, "Zle warunki atmosferyczne", new int[]{3}, new double[]{1});
    public final static AL ALInitialize = new AL(0.03F, 0.1F, 401, "Awaria lokomotywy", new int[]{3, 6}, new double[]{0.14285714285714285714, 0.07142857142857142857});

    public final static ASRK ASRKInitialize = new ASRK(0.05F, 0.1F, 402, "Awaria urzadzen sterowania ruchem kolejowym", new int[]{1, 3}, new double[]{1, 0});

    private static ArrayList<Station> stations;
    private static ArrayList<Track> tracks;
    private static ArrayList<Train> trains;

    public static int independentEventsRate;

    public static void initializeObjects() {

        // here you can choose all simulation settings
        independentEventsRate = 500;

        /*
            Each station is initialized separately and uniquely.
            Consequently, further extended to FrameAdvance function and added to station list (then sent as UI information).

            1000 x 500 px
        */

        stations = new ArrayList<>();

        Station WRO = new Station("Wroclaw",500,250);               processStation(WRO);
        Station KWR = new Station("Katy Wroclawskie",400,280);      processStation(KWR);
        Station JSL = new Station("Jaworzyna Slaska",270,300);      processStation(JSL);
        Station SWI = new Station("Swiebodzice",200,380);           processStation(SWI);
        Station WALB = new Station("Walbrzych",180,450);            processStation(WALB);

        Station KOB = new Station("Kobierzyce",460,330);            processStation(KOB);
        Station SOB = new Station("Sobotka",370,340);               processStation(SOB);
        Station SWD = new Station("Swidnica",310,390);              processStation(SWD);
        Station DSL = new Station("Dzierzoniow Slaski",330,450);    processStation(DSL);

        Station SRS = new Station("Sroda Slaska",360,220);          processStation(SRS);
        Station MAL = new Station("Malczyce",270,180);              processStation(MAL);
        Station LEG = new Station("Legnica",100,180);               processStation(LEG);

        Station OBR = new Station("Oborniki",490,200);              processStation(OBR);
        Station ZMI = new Station("Zmigrod",470,100);               processStation(ZMI);
        Station RAW = new Station("Rawicz",460,30);                 processStation(RAW);

        Station OLW = new Station("Olawa",590,340);                 processStation(OLW);
        Station BRZ = new Station("Brzeg",700,400);                 processStation(BRZ);
        Station OPL = new Station("Opole",900,450);                 processStation(OPL);

        /*
            Tracks (Track objects) are not guarded by anything except trains themselves.
            They are used to construct routes which all assigned trains can run on.

            A track itself marks the connection between two stations and the parameters of it, eg.
            max speed, double-tracked trail etc.

            The Tracks are then arranged in a LinkedList to create a finite route for any type of trains,
        */

        tracks = new ArrayList<>();

        Track WRO_KWR = new Track(160, WRO, KWR, true); tracks.add(WRO_KWR);
        Track KWR_JSL = new Track(120, KWR, JSL, true); tracks.add(KWR_JSL);
        Track JSL_SWI = new Track(120, JSL, SWI, true); tracks.add(JSL_SWI);
        Track SWI_WALB = new Track(120, SWI, WALB, true); tracks.add(SWI_WALB);

        // WROCŁAW - WAŁBRZYCH p/KĄTY WROCŁAWSKIE
        LinkedList<Track> WRO_WALB = new LinkedList<>();
        WRO_WALB.add(WRO_KWR);
        WRO_WALB.add(KWR_JSL);
        WRO_WALB.add(JSL_SWI);
        WRO_WALB.add(SWI_WALB);

        // -----------------------------------------------------------------------------------
        Track WRO_KOB = new Track(120, WRO, KOB, false); tracks.add(WRO_KOB);
        Track KOB_SOB = new Track(100, KOB, SOB, false); tracks.add(KOB_SOB);
        Track SOB_SWD = new Track(100, SOB, SWD, false); tracks.add(SOB_SWD);
        Track SWD_DSL = new Track(80, SWD, DSL, false); tracks.add(SWD_DSL);
        Track SWD_JSL = new Track(80, SWD, JSL, false); tracks.add(SWD_JSL);

        // WROCŁAW - DZIERŻONIÓW ŚL. p/ŚWIDNICA
        LinkedList<Track> WRO_DSL = new LinkedList<>();
        WRO_DSL.add(WRO_KOB);
        WRO_DSL.add(KOB_SOB);
        WRO_DSL.add(SOB_SWD);
        WRO_DSL.add(SWD_DSL);

        // DZIERŻONIÓW ŚL. - JAWORZYNA ŚL. p/ŚWIDNICA
        LinkedList<Track> DSL_JSL= new LinkedList<>();
        DSL_JSL.add(SWD_DSL);
        DSL_JSL.add(SWD_JSL);

        // -----------------------------------------------------------------------------------
        Track WRO_SRS = new Track(160, WRO, SRS, true); tracks.add(WRO_SRS);
        Track SRS_MAL = new Track(160, SRS, MAL, true); tracks.add(SRS_MAL);
        Track MAL_LEG = new Track(160, MAL, LEG, true); tracks.add(MAL_LEG);

        // WROCŁAW - LEGNICA - WROCŁAW p/MALCZYCE
        LinkedList<Track> WRO_LEG = new LinkedList<>();
        WRO_LEG.add(WRO_SRS);
        WRO_LEG.add(SRS_MAL);
        WRO_LEG.add(MAL_LEG);

        // -----------------------------------------------------------------------------------
        Track WRO_OBR = new Track(160, WRO, OBR, true); tracks.add(WRO_OBR);
        Track OBR_ZMI = new Track(160, OBR, ZMI, true); tracks.add(OBR_ZMI);
        Track ZMI_RAW = new Track(160, ZMI, RAW, true); tracks.add(ZMI_RAW);

        // WROCŁAW - LEGNICA p/ŻMIGRÓD
        LinkedList<Track> WRO_RAW = new LinkedList<>();
        WRO_RAW.add(WRO_OBR);
        WRO_RAW.add(OBR_ZMI);
        WRO_RAW.add(ZMI_RAW);

        // -----------------------------------------------------------------------------------
        Track WRO_OLW = new Track(160, WRO, OLW, true); tracks.add(WRO_OLW);
        Track OLW_BRZ = new Track(160, OLW, BRZ, true); tracks.add(OLW_BRZ);
        Track BRZ_OPL = new Track(160, BRZ, OPL, true); tracks.add(BRZ_OPL);

        // WROCŁAW - OPOLE p/OŁAWA, BRZEG
        LinkedList<Track> WRO_OPL = new LinkedList<>();
        WRO_OPL.add(WRO_OLW);
        WRO_OPL.add(OLW_BRZ);
        WRO_OPL.add(BRZ_OPL);

        /*
            At the moment, all trains are being generated at the same time of the simulation (limitations of the FrameAdvance parent-function)
            The parameters needed to create a Train object are:
                a starting point,
                a route which they are going through.
            If the start-station isn't included in the given route, the train will cease to generate.
            Selecting a center station is not expected.
            You need to select one of the end stations.
        */

        trains = new ArrayList<>();

        // altogether 35-70 trains

        // WROCŁAW - WAŁBRZYCH - WROCŁAW - 16
        Train KD69265 = new Train(69265, WRO, WRO_WALB, 1, 0); processTrains(KD69265);
        Train KD69228 = new Train(69228, WALB, WRO_WALB, 11, 1); processTrains(KD69228);

        Train KD69267 = new Train(69267, WRO, WRO_WALB, 57, 1); processTrains(KD69267);
        Train KD69230 = new Train(69230, WALB, WRO_WALB, 66, 0); processTrains(KD69230);
        Train KD69232 = new Train(69232, WALB, WRO_WALB, 132, 1); processTrains(KD69232);

        Train KD69234 = new Train(69234, WALB, WRO_WALB, 258, 0); processTrains(KD69234);
        Train KD69273 = new Train(69273, WRO, WRO_WALB, 404, 1); processTrains(KD69273);

        Train KD69277 = new Train(69277, WRO, WRO_WALB, 477, 1); processTrains(KD69277);
        Train KD69238 = new Train(69238, WALB, WRO_WALB, 360, 1); processTrains(KD69238);

        Train KD69285 = new Train(69285, WRO, WRO_WALB, 620, 0); processTrains(KD69285);
        Train KD69252 = new Train(69252, WALB, WRO_WALB, 701, 1); processTrains(KD69252);
        Train KD69289 = new Train(69289, WRO, WRO_WALB, 740, 1); processTrains(KD69289);

        Train KD69116 = new Train(69116, WALB, WRO_WALB, 745, 0); processTrains(KD69116);
        Train KD69113 = new Train(69113, WRO, WRO_WALB, 820, 0); processTrains(KD69113);

        Train KD69254 = new Train(69254, WALB, WRO_WALB, 827, 0); processTrains(KD69254);
        Train KD69295 = new Train(69295, WRO, WRO_WALB, 990, 0); processTrains(KD69295);

        // WROCŁAW - DZIERŻONIÓW - WROCŁAW - 6
        Train KD69211 = new Train(69211 , DSL, WRO_DSL, 70, 1); processTrains(KD69211);
        Train KD69215 = new Train(69215 , DSL, WRO_DSL, 700, 1); processTrains(KD69215);
        Train KD69201 = new Train(69201, WRO, WRO_DSL, 100, 1); processTrains(KD69201);

        Train KD60259 = new Train(60259, DSL, WRO_DSL, 490, 1); processTrains(KD60259);
        Train KD60213 = new Train(60213, WRO, WRO_DSL, 500, 1); processTrains(KD60213);
        Train KD60217 = new Train(60217, WRO, WRO_DSL, 800, 0); processTrains(KD60217);

        // WROCŁAW - LEGNICA - WROCŁAW - 12
        Train KD66537 = new Train(66537, WRO, WRO_LEG, 5, 1); processTrains(KD66537);
        Train KD66570 = new Train(66570, LEG, WRO_LEG, 9, 1); processTrains(KD66570);
        Train KD66539 = new Train(66539, WRO, WRO_LEG, 75, 1); processTrains(KD66539);
        Train KD66572 = new Train(66572, LEG, WRO_LEG, 90, 1); processTrains(KD66572);

        Train KD66549 = new Train(66549, WRO, WRO_LEG, 310, 1); processTrains(KD66549);
        Train KD66582 = new Train(66582, LEG, WRO_LEG, 310, 1); processTrains(KD66582);
        Train KD66551 = new Train(66551, WRO, WRO_LEG, 390, 1); processTrains(KD66551);
        Train KD66586 = new Train(66586, LEG, WRO_LEG, 410, 1); processTrains(KD66586);

        Train KD66559 = new Train(66559, WRO, WRO_LEG, 630, 1); processTrains(KD66559);
        Train KD66592 = new Train(66592, LEG, WRO_LEG, 630, 1); processTrains(KD66592);
        Train KD66561 = new Train(66561, WRO, WRO_LEG, 740, 1); processTrains(KD66561);
        Train KD66594 = new Train(66594, LEG, WRO_LEG, 710, 1); processTrains(KD66594);

        // DZIERŻONIÓW - JAWORZYNA - DZIERŻONIÓW - 6
        Train KD66803 = new Train(66803, DSL, DSL_JSL, 70, 1); processTrains(KD66803);
        Train KD66811 = new Train(66803, DSL, DSL_JSL, 361, 1); processTrains(KD66811);
        Train KD66819 = new Train(66803, DSL, DSL_JSL, 640, 1); processTrains(KD66819);

        Train KD69828 = new Train(69828, JSL, DSL_JSL, 110, 1); processTrains(KD69828);
        Train KD69836 = new Train(69836, JSL, DSL_JSL, 380, 1); processTrains(KD69836);
        Train KD69844 = new Train(69844, JSL, DSL_JSL, 655, 1); processTrains(KD69844);

        // WROCŁAW - OPOLE - WROCŁAW - 16
        Train R66400 = new Train(66400, WRO, WRO_OPL, 5, 1); processTrains(R66400);
        Train R66402 = new Train(66402, WRO, WRO_OPL, 55, 1); processTrains(R66402);
        Train R66404 = new Train(66404, WRO, WRO_OPL, 105, 1); processTrains(R66404);

        Train R46215 = new Train(46215, OPL, WRO_OPL, 11, 1); processTrains(R46215);
        Train R66217 = new Train(66217, OPL, WRO_OPL, 66, 1); processTrains(R66217);
        Train R66219 = new Train(66219, OPL, WRO_OPL, 110, 0); processTrains(R66219);

        Train R66410 = new Train(66410, WRO, WRO_OPL, 360, 1); processTrains(R66410);
        Train R66412 = new Train(66412, WRO, WRO_OPL, 450, 1); processTrains(R66412);
        Train R66414 = new Train(66414, WRO, WRO_OPL, 500, 1); processTrains(R66414);
        Train R66418 = new Train(66418, WRO, WRO_OPL, 630, 0); processTrains(R66418);
        Train R66422 = new Train(66422, WRO, WRO_OPL, 820, 0); processTrains(R66422);

        Train R66227 = new Train(66227, OPL, WRO_OPL, 375, 1); processTrains(R66227);
        Train R66229 = new Train(66229, OPL, WRO_OPL, 540, 1); processTrains(R66229);
        Train R66231 = new Train(66231, OPL, WRO_OPL, 600, 0); processTrains(R66231);
        Train R66237 = new Train(66237, OPL, WRO_OPL, 730, 0); processTrains(R66237);
        Train R66239 = new Train(66239, OPL, WRO_OPL, 900, 0); processTrains(R66239);

        // WROCŁAW - RAWICZ - WROCŁAW - 16
        Train KD67201 = new Train(67201, WRO, WRO_RAW, 3, 1); processTrains(KD67201);
        Train KD67203 = new Train(67203, WRO, WRO_RAW, 55, 1); processTrains(KD67203);
        Train KD67207 = new Train(67207, WRO, WRO_RAW, 190, 1); processTrains(KD67207);
        Train KD67209 = new Train(67209, WRO, WRO_RAW, 240, 1); processTrains(KD67209);
        Train KD67291 = new Train(67291, WRO, WRO_RAW, 400, 1); processTrains(KD67291);
        Train KD67213 = new Train(67213, WRO, WRO_RAW, 450, 1); processTrains(KD67213);
        Train KD67217 = new Train(67217, WRO, WRO_RAW, 550, 1); processTrains(KD67217);
        Train KD67219 = new Train(67219, WRO, WRO_RAW, 630, 1); processTrains(KD67219);
        Train KD67293 = new Train(67293, WRO, WRO_RAW, 745, 0); processTrains(KD67293);
        Train KD67223 = new Train(67223, WRO, WRO_RAW, 630, 0); processTrains(KD67223);

        Train KD76228 = new Train(76228, RAW, WRO_RAW, 11, 1); processTrains(KD76228);
        Train KD76230 = new Train(76230, RAW, WRO_RAW, 66, 0); processTrains(KD76230);
        Train KD76236 = new Train(76236, RAW, WRO_RAW, 240, 1); processTrains(KD76236);
        Train KD76288 = new Train(76288, RAW, WRO_RAW, 410, 1); processTrains(KD76288);
        Train KD76244 = new Train(76244, RAW, WRO_RAW, 600, 1); processTrains(KD76244);
        Train KD76254 = new Train(76254, RAW, WRO_RAW, 800, 0); processTrains(KD76254);
    }

    public static void processStation(Station station) {
        FrameAdvance.addStation(station);
        stations.add(station);
    }

    public static void processTrains(Train train) {
        trains.add(train);
    }

    public static ArrayList<Station> getStations() {
        return stations;
    }

    public static ArrayList<Track> getTracks() {
        return tracks;
    }

    public static ArrayList<Train> getTrains() {
        return trains;
    }
}
