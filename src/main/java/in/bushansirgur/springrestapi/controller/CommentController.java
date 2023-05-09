package in.bushansirgur.springrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import in.bushansirgur.springrestapi.model.Comment;
import in.bushansirgur.springrestapi.service.CommentService;


@RestController
public class CommentController {
	
	//localhost:8080/api/v1//
	
	@Autowired
	private CommentService cService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping ("/comments")
	 public ResponseEntity<List<Comment>> getCommet(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
	     return new ResponseEntity<List<Comment>>(cService.getComment(pageNumber, pageSize),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/comments/{id}")
	public ResponseEntity<Comment> getCommet(@PathVariable Long id) {
		return new ResponseEntity<Comment>(cService.getSingleComment(id),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/comments")
	public ResponseEntity<Comment> saveCommet(@Valid @RequestBody Comment comment) {
		return new ResponseEntity<Comment>(cService.saveComment(comment),HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping ("/comments/{id}")
	public ResponseEntity<Comment> updateCommet (@PathVariable Long id, @RequestBody Comment comment) {
		comment.setId(id);
	     return new ResponseEntity<Comment>(cService.updateComment(comment),HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/comments")
	public ResponseEntity<HttpStatus>  deleteComment(@RequestParam Long id) {
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping ("/comments/filterByName")
	 public ResponseEntity<List<Comment>> getCommentByName(@RequestParam String name){
	     return new ResponseEntity<List<Comment>>(cService.getCommentByName(name), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping ("/comments/filterByNameAndBrand")
	public ResponseEntity<List<Comment>> getCommentByNameAndBrand (@RequestParam String name, @RequestParam long codeEAN){
	     return new ResponseEntity<List<Comment>> (cService.getCommentByNameAndcodeEAN(name, codeEAN), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping ("/comments/filterByKeyword")
	public ResponseEntity<List<Comment>> getProductByKeyword(@RequestParam String name){
	     return new ResponseEntity<List<Comment>> (cService.getCommentByKeyword(name),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/comments/{name}/{brand}")
	public ResponseEntity<List<Comment>> getCommentByNameORBrand(@PathVariable String name, @PathVariable long codeEAN){
	     return new ResponseEntity<List<Comment>> (cService.getCommentByNameORcodeEAN(name, codeEAN),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/comments/delete/{name}")
	public ResponseEntity<String> deleteByCommentName(@PathVariable String name){
	     return new ResponseEntity<String> (cService.deleteByCommentName(name) + " No. of records deleted", HttpStatus.OK);
	}
	
	
}