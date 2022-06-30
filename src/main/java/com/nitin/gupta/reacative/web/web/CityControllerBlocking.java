package com.nitin.gupta.reacative.web.web;

import com.nitin.gupta.reacative.web.domain.*;
import com.nitin.gupta.reacative.web.service.*;
import net.bytebuddy.utility.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class CityControllerBlocking {
	@Autowired
	private CityRepository cityRepository;

	@GetMapping("/one")
	@ResponseBody
	public City searchOne() {
		return cityRepository.findByNameAndCountryAllIgnoringCase("Bath", "UK");
	}

	@GetMapping("/")
	@ResponseBody
	public Iterable<City> list() {
		return cityRepository.findAll();
	}

	@GetMapping("/add")
	@ResponseBody
	@Transactional
	public Long add() {
		// To keep the sample simple, we just create a city with a random name.
		String name = RandomString.make(10);
		String country = "USA";

		City city = new City(name, country);
		City savedCity = cityRepository.save(city);

		return savedCity.getId();
	}
}
