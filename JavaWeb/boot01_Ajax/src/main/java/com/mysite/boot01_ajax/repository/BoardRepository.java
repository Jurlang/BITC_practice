package com.mysite.boot01_ajax.repository;

import com.mysite.boot01_ajax.domain.Board;
import com.mysite.boot01_ajax.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 상속 후 <TableClassName, IDtype>
public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
// 	CRUD 자동 상속
// 	Custom Method
//	@Query("select b from Board b where b.title like concat('%',:keyword,'%')")
//	Page<Board> findKeyword(String keyword, Pageable pageable);
}
