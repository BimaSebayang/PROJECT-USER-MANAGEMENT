package id.co.roxas.management.ui.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.roxas.common.lib.dto.TestingDto;

@RestController
@RequestMapping
public class TestingController {

	
	@GetMapping("/test")
	public ResponseEntity<TestingDto> getTestingDto(){
		TestingDto dto = new TestingDto();
		dto.setNama("bima");
		dto.setPassword("password");
		return new ResponseEntity<TestingDto>(dto, HttpStatus.OK);
		
	}
}
