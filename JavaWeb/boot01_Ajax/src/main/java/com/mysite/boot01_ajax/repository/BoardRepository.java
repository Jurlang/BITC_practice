package com.mysite.boot01_ajax.repository;

import com.mysite.boot01_ajax.domain.Board;
import com.mysite.boot01_ajax.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// JpaRepository 상속 후 <TableClassName, IDtype>
public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
// 	CRUD 자동 상속
// 	Custom Method
//	@Query("select b from Board b where b.title like concat('%',:keyword,'%')")
//	Page<Board> findKeyword(String keyword, Pageable pageable);
    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select b from Board b where b.bno = :bno")
    Optional<Board> findByIdWithImages(Long bno);
}
