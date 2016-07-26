package com.china.gavin.javabase.timer;

import java.io.IOException;
import java.util.Timer;
import org.junit.Test;

public class HeartbeatTimingTaskTest {

    public void testHeartbeatTimingTask() {
        Timer timer = new Timer();
        HeartbeatTimingTask heartbeatTask = new HeartbeatTimingTask();
        // timer.schedule(heartbeatTask, 1000, 2000);
        timer.scheduleAtFixedRate(heartbeatTask, 1000, 2000);
        while (true) {
            try {
                int ch = System.in.read();
                if (ch - 'c' == 0) {
                    timer.cancel();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
