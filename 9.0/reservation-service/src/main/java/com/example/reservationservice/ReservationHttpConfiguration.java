package com.example.reservationservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
class ReservationHttpConfiguration {

  @Bean
  RouterFunction<ServerResponse> routes(ReservationRepository rr) {
    return route()
        .GET("/reservations", request -> ok().body(rr.findAll(), Reservation.class))
        .build();
  }
}
