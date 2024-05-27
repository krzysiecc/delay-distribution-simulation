package org.objects;

public class Route {
    private int _ID;
    private boolean secondTrack;
    private int VMax;
    private Station start;
    private Station end;

    public Route() {
        secondTrack = false;
        VMax        = 100;
        start       = new Station();
        end         = new Station();
    }

    public Route(boolean secondTrack, int VMax, Station start, Station end) {
        this.secondTrack = secondTrack;
        this.VMax        = VMax;
        this.start       = start;
        this.end         = end;

        _ID = Math.abs(this.start.get_stationID() - this.end.get_stationID());

        System.out.print("Utworzono szlak nr " + _ID + " ");
        System.out.print(secondTrack ? "dwutorowy " : "jednotorowy ");
        System.out.print("o prędkości maksymalnej " + VMax + " km/h. ");
        System.out.print("TRASA: " + this.start.getStationName() + " - " + this.end.getStationName());
    }
}
