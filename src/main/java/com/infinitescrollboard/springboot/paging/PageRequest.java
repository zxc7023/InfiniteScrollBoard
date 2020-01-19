package com.infinitescrollboard.springboot.paging;

import org.springframework.data.domain.Sort.Direction;

/**
 * 악의의 사용자가 가져올 컬럼을 제한 없이 한다면 큰 비용을 발생시킴
 * 따라서, http request를 받은 후에 springframework.data.domin.pageRequest를 of를 통해 새로 만듭니다.
 * 또한, page가 0부터 시작하는 이상한점도 고치기위해 getter,setter를 사용하여 조작.
 * 
 * @author Junki
 */
public class PageRequest {

	private int page;
	private int size;
	private Direction direction;

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page <= 0 ? 1 : page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		int DEFAULT_SIZE = 10;
		int MAX_SIZE = 50;
		this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
	}

	public org.springframework.data.domain.PageRequest of() {
		return org.springframework.data.domain.PageRequest.of(page - 1, size, direction, "boardNo");
	}

	@Override
	public String toString() {
		return "PageRequest [page=" + page + ", size=" + size + ", direction=" + direction + "]";
	}

}
