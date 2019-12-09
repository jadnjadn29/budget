package com.okta.springbootvue.Repository;

import com.okta.springbootvue.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    
}