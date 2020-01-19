package com.infinitescrollboard.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.infinitescrollboard.springboot.model.Board;
import com.infinitescrollboard.springboot.model.BoardCategory;

public interface BoardService {
	Page<Board> getBaordList(List<BoardCategory> boardcategory, Pageable pageable);
}
