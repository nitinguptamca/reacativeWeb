package com.nitin.gupta.reacative.web.service;

import com.nitin.gupta.reacative.web.domain.*;
import org.springframework.data.repository.*;

public interface CityRepository extends CrudRepository<City, Long> {
	City findByNameAndCountryAllIgnoringCase(String name, String country);
}
