package jaz.lab06.demo.service;

import jaz.lab06.demo.location.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationsDataRepository extends CrudRepository<Location, Integer> {
    Location findById(int id);
}