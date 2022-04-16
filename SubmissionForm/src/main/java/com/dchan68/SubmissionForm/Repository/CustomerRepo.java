package com.dchan68.SubmissionForm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dchan68.SubmissionForm.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
}
