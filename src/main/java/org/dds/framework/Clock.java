package org.dds.framework;

import static org.dds.framework.FrameAdvance.adv;

public class Clock {
    public static int ANIMATION_FRAME = 0;

    public static void simulate() {
        adv();
        ANIMATION_FRAME++;
    }

    public static boolean disposeGraphic() {
        return true;
    }

}
