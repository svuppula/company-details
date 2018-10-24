package com.sencha.grid.companydetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sencha.grid.companydetails.entity.CompanyDetails;

public interface CompanyRepository extends JpaRepository<CompanyDetails, Integer> {

}
