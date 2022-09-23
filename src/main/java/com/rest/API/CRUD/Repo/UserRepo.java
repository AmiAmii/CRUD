package com.rest.API.CRUD.Repo;
import com.rest.API.CRUD.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
}
