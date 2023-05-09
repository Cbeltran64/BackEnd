package in.bushansirgur.springrestapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import in.bushansirgur.springrestapi.model.Comment;


public interface CommentRepository extends PagingAndSortingRepository<Comment , Long> {
	
	List<Comment> findByName (String name);
	
	//SELECT * FROM table WHERE name="bushan." AND location="INdia"
	List<Comment> findByNameAndCodeEAN(String name, long codeEAN);
	
	@Query("SELECT c FROM Comment c WHERE LOWER(c.name) LIKE %:name%")
	List<Comment> findByNameContaining (@Param("name") String name, Sort sort);
	
	@Query("FROM Comment WHERE name = :name OR codeEAN = :codeEAN")
	List<Comment> getCommentByNameAndBrand(String name, long codeEAN);
	
	@Transactional
	@Modifying
	@Query( "DELETE FROM Comment WHERE name = :name")
	Integer deleteCommentByName (String name);
	
		
}