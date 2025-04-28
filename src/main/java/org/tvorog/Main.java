package org.tvorog;

import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;

public class Main {
    public static void main(String[] args) {
        GatlingPropertiesBuilder builder = new GatlingPropertiesBuilder().simulationClass(SimulationCommission.class.getName());
        Gatling.fromMap(builder.build());
    }


}
