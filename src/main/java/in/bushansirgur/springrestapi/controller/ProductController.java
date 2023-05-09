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
import in.bushansirgur.springrestapi.model.Product;
import in.bushansirgur.springrestapi.service.ProductService;


@RestController
public class ProductController {
	
	//localhost:8080/api/v1//
	
	@Autowired
	private ProductService pService;
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping ("/products")
	 public ResponseEntity<List<Product>> getProduct(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
	     return new ResponseEntity<List<Product>>(pService.getProducts(pageNumber, pageSize),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		return new ResponseEntity<Product>(pService.getSingleProducts(id),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/products/{categoryId}")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, @PathVariable Long categoryId) {
        Product createdProduct = pService.saveProducts(product, categoryId);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping ("/products/{id}")
	public ResponseEntity<Product> updateProduct (@PathVariable Long id, @RequestBody Product product) {
		 product.setId(id);
	     return new ResponseEntity<Product>(pService.updateProducts(product),HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/products")
	public ResponseEntity<HttpStatus>  deleteProduct(@RequestParam Long id) {
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping ("/products/filterByName")
	 public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name){
	     return new ResponseEntity<List<Product>>(pService.getProductsByName(name), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping ("/products/filterByNameAndBrand")
	public ResponseEntity<List<Product>> getProductsByNameAndBrand (@RequestParam String name, @RequestParam long brand){
	     return new ResponseEntity<List<Product>> (pService.getProductsByNameAndBrand (name, brand), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping ("/products/filterByKeyword")
	public ResponseEntity<List<Product>> getProductsByKeyword(@RequestParam String keyword){
		System.out.println(keyword);
	     return new ResponseEntity<List<Product>> (pService.getProductsByKeyword(keyword),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products/{name}/{brand}")
	public ResponseEntity<List<Product>> getProductsByNameORBrand(@PathVariable String name, @PathVariable long brand){
	     return new ResponseEntity<List<Product>> (pService.getProductsByNameORBrand(name, brand),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/products/delete/{name}")
	public ResponseEntity<String> deleteByProductName(@PathVariable String name){
	     return new ResponseEntity<String> (pService.deleteByProductName(name) + " No. of records deleted", HttpStatus.OK);
	}
	
	
}
	
































