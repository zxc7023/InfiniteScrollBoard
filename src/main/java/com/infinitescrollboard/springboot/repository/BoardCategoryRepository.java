package com.infinitescrollboard.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinitescrollboard.springboot.model.BoardCategory;

@Repository
public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Integer> {

}
