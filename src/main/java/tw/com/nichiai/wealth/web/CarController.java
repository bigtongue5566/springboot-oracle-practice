package tw.com.nichiai.wealth.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.nichiai.wealth.domain.Car;
import tw.com.nichiai.wealth.domain.CarRepository;

@RestController
public class CarController {
	private final CarRepository repository;

	public CarController(CarRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}
}
