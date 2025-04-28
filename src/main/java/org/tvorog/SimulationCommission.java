package org.tvorog;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;

public class SimulationCommission extends Simulation {
    /*
    intensity - нужная интенсивность
     */
    double intensity = 3.0;
    /*
    durationStep - длительность ступени нагрузки
     */
    Duration durationStep = Duration.ofMinutes(10);
    /*
    minuteRampUp - длительность разгона нагрузки(можно не менять)
    */
    Duration minuteRampUp = Duration.ofMinutes(1);
    private ChainBuidersCommission2195 commission2195 = new ChainBuidersCommission2195();
    private final ScenarioBuilder commissionScenario = scenario("commisson").exec(commission2195.comission());

    {
        setUp(
                commissionScenario.injectOpen(rampUsersPerSec(0).to(intensity).during(minuteRampUp),
                        constantUsersPerSec(intensity).during(durationStep))
        );
    }
}
