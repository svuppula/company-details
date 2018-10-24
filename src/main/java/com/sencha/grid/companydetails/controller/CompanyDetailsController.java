package com.sencha.grid.companydetails.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sencha.grid.companydetails.entity.CompanyDetails;
import com.sencha.grid.companydetails.repository.CompanyRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/gain")
public class CompanyDetailsController {
	
	private CompanyRepository companyRepository;
	
	List<CompanyDetails> companyDetails = new ArrayList<CompanyDetails>();
	
	public CompanyDetailsController(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	@GetMapping("/all")
	public List<CompanyDetails> getCompanyDetails(){
		companyDetails.clear();
		companyRepository.findAll().forEach(details -> {
		if(details.isActive() == true) {companyDetails.add(details);}});
		return companyDetails;
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/add")
	public CompanyDetails addCompany(@RequestBody final CompanyDetails companyDetails) {		 
		return companyRepository.save(companyDetails);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping("/update")
	public CompanyDetails updateCompany(@RequestBody final CompanyDetails companyDetails) {
		return companyRepository.save(companyDetails);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/remove/{id}")
	public void deleteCompany(@PathVariable int id) {
		CompanyDetails companyDetails = new CompanyDetails();
		companyDetails =companyRepository.findById(id).get();
		companyDetails.setActive(false);
		companyRepository.save(companyDetails);
	}
}
