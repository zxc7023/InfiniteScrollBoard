package com.infinitescrollboard.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infinitescrollboard.springboot.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}
