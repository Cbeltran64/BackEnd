package in.bushansirgur.springrestapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import in.bushansirgur.springrestapi.model.Product;
import in.bushansirgur.springrestapi.exception.ResourceNotFoundException;
import in.bushansirgur.springrestapi.model.Category;
import in.bushansirgur.springrestapi.repository.CategoryRepository;
import in.bushansirgur.springrestapi.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository pRepository;
	
	@Autowired
	private CategoryRepository caRepository;
	
	@Override
	public List<Product> getProducts(int pageNumber, int pageSize) {
		Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC, "id");
		return pRepository.findAll(pages).getContent();
	}

	

	@Override
	public Product getSingleProducts(Long id) {
		Optional<Product> employee = pRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Product is not found for the id "+id);
	}

	@Override
	public void deleteProducts(Long id) {
		pRepository.deleteById(id);
	}

	@Override
	public Product updateProducts(Product product) {
		return pRepository.save(product);
	}

	@Override
	public List<Product> getProductsByName(String name) {
		return pRepository.findByName(name);
	}

	@Override
	public List<Product> getProductsByNameAndBrand(String name, long brand) {
		return pRepository.findByNameAndBrand(name, brand);
	}

	@Override
	public List<Product> getProductsByKeyword(String keyword) {
		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		return pRepository.searchProduct(keyword,sort);
	}

	@Override
	public List<Product> getProductsByNameORBrand(String name, long brand) {
		return pRepository.getProductByNameAndBrand(name, brand);
	}

	@Override
	public Integer deleteByProductName(String name) {
		return pRepository.deleteProductByName(name);
	}



	@Override
	public Product saveProducts(Product product, long categoryId) {
		Category category = caRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));
        product.pushCategory(category);
        return pRepository.save(product);
	}
}




































