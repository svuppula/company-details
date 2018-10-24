package com.sencha.grid.companydetails.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sencha.grid.companydetails.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByName(String username);

}
