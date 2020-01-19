package com.infinitescrollboard.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infinitescrollboard.springboot.model.Board;
import com.infinitescrollboard.springboot.model.BoardCategory;
import com.infinitescrollboard.springboot.paging.PageRequest;
import com.infinitescrollboard.springboot.service.BoardCategoryService;
import com.infinitescrollboard.springboot.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardCategoryService boardCategoryService; 

	/**
	 * 게시글 목록을 가져와 JSON 형식으로 반환</br>
	 * Spring Data API에서 Pageable 인터페이스를 구현하여 만든 AbstractPageRequest 클래스로 부터 상속받은 PageRequest를 사용하여 페이징 처리.</br>
	 * @param boardCategories 사용자가 선택한 카테고리
	 * @param pageable page, size, direction(정렬 순서) 맴버필드를 가지고 있는 객체. method of 를 통해 PageRequest 타입의 객체로 생성 
	 * @return 여러 게시글(Board)들과 페이지 정보(현재 페이지, 라스트 페이지인지 등)를 리턴 한다.
	 */
	@ResponseBody
	@RequestMapping(path = "/boardlist", method = RequestMethod.GET)
	public Page<Board> boardList(PageRequest pageable,
			@RequestParam(name = "categoryNo",required=true) List<BoardCategory> boardCategories) {

		System.out.println(pageable);
		Page<Board> boardPage = null;
		boardPage = boardService.getBaordList(boardCategories, pageable.of());
		return boardPage;
	}
	
	/**
	 * 게시글의 카테고리를 가져와 JSON 형식으로 반환
	 * @return List<Category> 형태를 반환
	 */
	@ResponseBody
	@RequestMapping(path = "/category", method = RequestMethod.GET)
	public List<BoardCategory> categoryList() {
		List<BoardCategory> categories = null;
		categories = boardCategoryService.getCategories();
		return categories;
	}
	
}
