package com.nitin.gupta.reacative.web.service;


import com.nitin.gupta.reacative.web.domain.*;
import reactor.core.publisher.*;

public interface CityService {
	Mono<City> getCity(String name, String country);

	Flux<City> findAll();

	Mono<City> add(String name, String country);
}
