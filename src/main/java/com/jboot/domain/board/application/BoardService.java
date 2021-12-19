package com.jboot.domain.board.application;

import com.jboot.domain.board.dao.BoardRepository;
import com.jboot.domain.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    // TODO: 2021-12-19 행위기반/적절한 크기로 나누기

     private final BoardRepository boardRepository;

     public Page<Board> findAll(Pageable pageable){
         return boardRepository.findAll(pageable);
     }

     public Board findBoardById(long id){
         return boardRepository.findById(id).orElse(new Board());
     }

     public Board save(Board board){
         return boardRepository.save(board);
     }

     public void deleteById(long id){
         boardRepository.deleteById(id);
     }

}
