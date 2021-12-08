package tn.esprit.devops.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.devops.entity.User;

@Repository
public interface UserRepository extends  CrudRepository<User, Long> { 
	 
}
