package com.nitin.gupta.reacative.web.web;

import com.nitin.gupta.reacative.web.domain.*;
import com.nitin.gupta.reacative.web.service.*;
import net.bytebuddy.utility.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

@Controller
@RequestMapping("/rx")
public class CityControllerRx {
	@Autowired
	private CityService cityService;

	@GetMapping("/one")
	@ResponseBody
	public Mono<City> searchOne() {
		return this.cityService.getCity("Bath", "UK");
	}

	@GetMapping("/")
	@ResponseBody
	public Flux<City> list() {
		return this.cityService.findAll();
	}

	@GetMapping("/add")
	@ResponseBody
	public Mono<Long> add() {
		// To keep the sample simple, we just create a city with a random name.
		String name = RandomString.make(10);
		String country = "USA";
		return this.cityService.add(name, country).map(city -> city.getId());
	}
}
