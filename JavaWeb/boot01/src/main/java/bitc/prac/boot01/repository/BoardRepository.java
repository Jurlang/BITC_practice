package bitc.prac.boot01.repository;

import bitc.prac.boot01.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 상속 후 <TableClassName, IDtype>
public interface BoardRepository extends JpaRepository<Board, Long> {
	// CRUD 자동 상속
}
