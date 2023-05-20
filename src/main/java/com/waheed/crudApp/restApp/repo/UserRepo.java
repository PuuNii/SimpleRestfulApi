package com.waheed.crudApp.restApp.repo;

import com.waheed.crudApp.restApp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepo extends JpaRepository<User, Long> {


}
