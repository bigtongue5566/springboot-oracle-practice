package tw.com.nichiai.wealth;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;

import tw.com.nichiai.wealth.domain.Car;
import tw.com.nichiai.wealth.domain.CarRepository;
import tw.com.nichiai.wealth.domain.Owner;
import tw.com.nichiai.wealth.domain.OwnerRepository;

@SpringBootApplication
public class WealthApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(
			WealthApplication.class);

	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;

	public WealthApplication(CarRepository carRepository, OwnerRepository ownerRepository) {
		this.carRepository = carRepository;
		this.ownerRepository = ownerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(WealthApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		// Add owner objects and save these to db
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		carRepository.save(new Car("Ford", "Mustang", "Red",
				"ADF-1121", 2023, 59000, owner1));
		carRepository.save(new Car("Nissan", "Leaf", "White",
				"SSJ-3002", 2020, 29000, owner2));
		carRepository.save(new Car("Toyota", "Prius", "Silver",
				"KKO-0212", 2022, 39000, owner2));
		// Fetch all cars and log to console
		for (Car car : carRepository.findAll()) {
			logger.info("brand: {}, model: {}", car.getBrand(),
					car.getModel());
		}
	}

}
