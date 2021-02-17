package com.opeyemi.datapersistence;

import com.opeyemi.datapersistence.data.Delivery;
import com.opeyemi.datapersistence.data.Plant;
import com.opeyemi.datapersistence.repository.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@DataJpaTest
class DataPersistenceApplicationTests {

	@Autowired
	TestEntityManager testEntityManager;

	@Autowired
	PlantRepository plantRepository;


	@Test
	public void priceLessThan(){

		Plant plant = testEntityManager.persist(new Plant("Foo Leaf", 4.99));
		testEntityManager.persist(new Plant("jargons", 5.78));

		List<Plant> byPriceLessThan = plantRepository.findByPriceLessThan(BigDecimal.valueOf(5));
		Assertions.assertEquals(1, byPriceLessThan.size(), "Size");
		Assertions.assertEquals(plant.getId(), byPriceLessThan.get(0).getId(), "Id");
	}

	@Test
	public void testDeliveryCompleted(){
		Plant plant = testEntityManager.persist(new Plant("growing", 8.99));
		Delivery delivery = testEntityManager.persist(new Delivery("Opeyemi", "!2, Odusoga close", LocalDateTime.now(), Lists.newArrayList(plant)));

		plant.setDelivery(delivery);

		Assertions.assertNull(plantRepository.deliveryCompleted(plant.getId()));
		delivery.setCompleted(true);
		Assertions.assertTrue(plantRepository.deliveryCompleted(plant.getId()));
	}



}
