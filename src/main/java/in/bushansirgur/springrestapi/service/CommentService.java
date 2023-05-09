package in.bushansirgur.springrestapi.service;

import in.bushansirgur.springrestapi.model.Comment;
import java.util.List;

public interface CommentService {
	
	List<Comment> getComment(int pageNumber, int pageSize);
	
	Comment saveComment(Comment comment);
	
	Comment getSingleComment (Long id);
	
	void deleteComment (Long id);
	
	Comment updateComment (Comment comment);
	
	List<Comment> getCommentByName (String name);

	List<Comment> getCommentByNameAndcodeEAN(String name, long codeEAN);
	
	List<Comment> getCommentByKeyword(String name);
	
	List<Comment> getCommentByNameORcodeEAN(String name, long codeEAN);
	
	Integer deleteByCommentName (String name);
	
}