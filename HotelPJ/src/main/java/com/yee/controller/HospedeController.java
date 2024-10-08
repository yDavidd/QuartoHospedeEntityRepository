package com.yee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yee.entities.Hospede;
import com.yee.services.HospedeService;

@RestController
@RequestMapping("/hospede")
public class HospedeController {

	private final HospedeService hospedeService;
	@Autowired
	public HospedeController(HospedeService hospedeService) {
		this.hospedeService = hospedeService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hospede> getHospedeById(@PathVariable Long id) {
		Hospede hospede = hospedeService.getHospedeById(id);
		if (hospede != null) {
			return ResponseEntity.ok(hospede);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Hospede>> getAllHospede() {
		List<Hospede> hospede = hospedeService.getAllHospede();
		return ResponseEntity.ok(hospede);
	}
	
	//@GetMapping("/data/{data}")
	//public ResponseEntity<List<Hospede>> getPorData(@PathVariable String data){
		//List<Hospede> hospede = hospedeService.getPorData(data);
		//return ResponseEntity.ok(hospede);
	//}
	
	
	@PostMapping("/")
	public ResponseEntity<Hospede> criarHospede(@RequestBody Hospede hospede) {
		Hospede criarHospede = hospedeService.salvarHospede(hospede);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarHospede);
	}
	


	@PutMapping("/{id}")
	public ResponseEntity<Hospede> updateHospede(@PathVariable Long id,@RequestBody Hospede hospede) {
		Hospede updatedHospede = hospedeService.updateHospede(id, hospede);
		if (updatedHospede != null) {
			return ResponseEntity.ok(updatedHospede);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHospede(@PathVariable Long id) {
		boolean deleted = hospedeService.deleteHospede(id);
		if (deleted) {
			return ResponseEntity.ok().body("O hospede foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}






