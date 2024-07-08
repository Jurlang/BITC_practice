package bitc.prac.boot01.repository.search;

import bitc.prac.boot01.domain.Board;
import bitc.prac.boot01.domain.QBoard;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {
        QBoard board = QBoard.board;                // Model

        JPQLQuery<Board> query = from(board);       // select ... from board
        query.where(board.title.contains("1"));     // where title like "1"

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return null;
    }

}
