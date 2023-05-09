package in.bushansirgur.springrestapi.service;

import in.bushansirgur.springrestapi.model.Product;
import java.util.List;

public interface ProductService {
	
	List<Product> getProducts(int pageNumber, int pageSize);
	
	Product saveProducts(Product product, long Idcategoria);
	
	Product getSingleProducts (Long id);
	
	void deleteProducts (Long id);
	
	Product updateProducts (Product product);
	
	List<Product> getProductsByName (String name);

	List<Product> getProductsByNameAndBrand(String name, long brand);
	
	List<Product> getProductsByKeyword(String keyword);
	
	List<Product> getProductsByNameORBrand(String name, long brand);
	
	Integer deleteByProductName (String name);
	
}	