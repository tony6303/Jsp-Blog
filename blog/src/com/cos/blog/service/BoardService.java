package com.cos.blog.service;

import java.util.List;

import com.cos.blog.domain.board.Board;
import com.cos.blog.domain.board.BoardDao;
import com.cos.blog.domain.board.dto.SaveReqDto;

public class BoardService {
	private BoardDao boardDao;

	public BoardService() {
		boardDao = new BoardDao();
	}

	public int 글쓰기(SaveReqDto dto) {
		return boardDao.save(dto);
	}
	public List<Board> 목록보기(){
		return boardDao.findAll();
	}
	public Board 상세보기(int id) {
		return boardDao.detail(id);
	}
}
