package com.yee.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.yee.entities.Hospede;

@DataJpaTest
class HospedeRepositoryTest {


	@Autowired
	private HospedeRepository HospedeRepository;
	
	@DisplayName("Tenstando Save")
	@Test
	void testSalvarRepositry() {
		
		//given / Arrange
		Hospede Hospede1 = new Hospede(null, "Joao","joao@gmail.com");
		
		//when / act
		Hospede saveHospede = HospedeRepository.save(Hospede1);
		
		//Then / Assert
		assertNotNull(saveHospede);
		assertTrue(saveHospede.getId() > 0);
		
	}
	
	@DisplayName("Tenstando Save")
	@Test
	void testGetAllRepository() {
		
		//given / Arrange
		Hospede Hospede1 = new Hospede(null, "Joao","joao@gmail.com");
		Hospede Hospede2 = new Hospede(null, "Joao","joao@gmail.com");
		
		//when / act
		HospedeRepository.save(Hospede1);
		HospedeRepository.save(Hospede2);
		
		List<Hospede> HospedeList = HospedeRepository.findAll();
		
		//Then / Assert
		assertNotNull(HospedeList);
		assertEquals(2, HospedeList.size());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testGetById() {
		
		//given / Arrange
		Hospede Hospede1 = new Hospede(null, "Joao","joao@gmail.com");
				
		//when / act
		HospedeRepository.save(Hospede1);
		
		Hospede saveHospede = HospedeRepository.findById(Hospede1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveHospede);
		assertEquals(Hospede1.getId(),saveHospede.getId());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testUpdateHospede() {
		
		//given / Arrange
		Hospede Hospede1 = new Hospede(null, "Joao","joao@gmail.com");
				
		//when / act
		HospedeRepository.save(Hospede1);
		
		Hospede saveHospede = HospedeRepository.findById(Hospede1.getId()).get();
		Hospede1.setName("2D");
		Hospede1.setEmail("15");
		
		Hospede updateHospede = HospedeRepository.save(saveHospede);
		//Then / Assert
		assertNotNull(updateHospede);
		assertEquals("2D", updateHospede.getName());
		assertEquals("15", updateHospede.getEmail());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testDeleteHospede() {
		
		//given / Arrange
		Hospede Hospede1 = new Hospede(null, "Joao","joao@gmail.com");
				
		//when / act
		HospedeRepository.save(Hospede1);
		
		HospedeRepository.deleteById(Hospede1.getId());
		
		Optional<Hospede> HospedeOptional = HospedeRepository.findById(Hospede1.getId());
		//Then / Assert
		assertNotNull(HospedeOptional);

	}
	
	
	
	

}
