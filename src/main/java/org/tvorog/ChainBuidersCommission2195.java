package org.tvorog;

import io.gatling.javaapi.core.ChainBuilder;

import java.util.Map;
import java.util.UUID;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class ChainBuidersCommission2195 {
    private final String loro_address = "http://localhost:8080/api";

    public final ChainBuilder comission() {
        return exec(session -> {
            String paymId = UUID.randomUUID().toString();
            return session.set("paymId", paymId);
        })
                .exec(
                        http("comisson")
                                .post(loro_address)
                                .check(
                                        status().is(200)
                                )
                                .headers(Map.ofEntries(
                                                Map.entry("accept", "application/json"),
                                                Map.entry("Content-Type", "application/json")
                                        )
                                )
                                .body(
                                        StringBody("""
                                                {
                                                  "paymId": "#{paymId}",
                                                  "summa": 10,
                                                  "currency": "RUB",
                                                  "typeDoc": "MT103",
                                                  "expenseDet": "OUR",
                                                  "accPayer": "30303810000000000001",
                                                  "accReceiver": "30303810000000000001",
                                                  "payerBank": "банк",
                                                  "receiverBank": "банк",
                                                  "receiver": "кто-то ",
                                                  "reason": "платеж за что - то",
                                                  "route": "CORP",
                                                  "urgency": 0,
                                                  "accDebit": "30109810123456789456",
                                                  "accCredit": "30303810000000000000"
                                                
                                                }
                                                """)
                                )
                );
    }
}
