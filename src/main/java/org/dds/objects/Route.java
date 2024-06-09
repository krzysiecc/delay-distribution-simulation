package org.dds.objects;

public class Route {
    private int _ID;
    private boolean secondTrack;
    private int VMax;
    private Station start;
    private Station end;

    public Route() {
		/* Dlaczego default second track jest "False"
		 * nie ustaliliśmy, że to ma być norma do ułatwienia zarządzaniem
		 * jazdy pociągów bo uznajemy je jako auta?
		 */
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

		/*
		 *_ID ma duży potencjał do problemów w takim stanie ponieważ
		 * stacje 7 i 3 nadadzą taką samą wartość co stacje 6 i 2,
		 * niezależnie od tego która to start a która to end.
		 * Lepiej się tego pozbyć i nie liczyć na szczęście, bo
		 * stworzy to ostre bugi.
		 */
        _ID = Math.abs(this.start.get_stationID() - this.end.get_stationID());

        System.out.print("Utworzono szlak nr " + _ID + " ");
        System.out.print(secondTrack ? "dwutorowy " : "jednotorowy ");
        System.out.print("o prędkości maksymalnej " + VMax + " km/h. ");
        // Również do poprawy
        System.out.print("TRASA: " + this.start.getStationName() + " - " + this.end.getStationName());
    }
}
