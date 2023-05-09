package in.bushansirgur.springrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import in.bushansirgur.springrestapi.model.Comment;
import in.bushansirgur.springrestapi.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository cRepository;
	
	@Override
	public List<Comment> getComment(int pageNumber, int pageSize) {
		Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC, "id");
		return cRepository.findAll(pages).getContent();
	}

	@Override
	public Comment saveComment(Comment comment) {
		return cRepository.save(comment);
	}

	@Override
	public Comment getSingleComment(Long id) {
		Optional<Comment> employee = cRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Comment is not found for the id "+id);
	}

	@Override
	public void deleteComment(Long id) {
		cRepository.deleteById(id);
	}

	@Override
	public Comment updateComment(Comment comment) {
		return cRepository.save(comment);
	}

	@Override
	public List<Comment> getCommentByName(String name) {
		return cRepository.findByName(name);
	}

	@Override
	public List<Comment> getCommentByNameAndcodeEAN(String name, long codeEAN) {
		return cRepository.findByNameAndCodeEAN(name, codeEAN);
	}

	@Override
	public List<Comment> getCommentByKeyword(String name) {
		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		return cRepository.findByNameContaining(name, sort);
	}

	@Override
	public List<Comment> getCommentByNameORcodeEAN(String name, long codeEAN) {
		return cRepository.getCommentByNameAndBrand(name, codeEAN);
	}

	@Override
	public Integer deleteByCommentName(String name) {
		return cRepository.deleteCommentByName(name);
	}

}
