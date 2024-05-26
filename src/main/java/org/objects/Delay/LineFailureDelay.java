package org.objects.Delay;

import org.objects.BaseDelay;

public class LineFailureDelay implements BaseDelay {
    @Override
    public int calculateDelay(int totalRouteTime) {
        return 0;
    }

    @Override
    public void lookForOtherTrain(int codeA, int codeB) {
        return;
    }
}
