package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.product.model.Product;
import com.product.repository.ProductRepository;

@Service
public class ProdService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}

	public Product saveContact(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(int id, Product product) {
		Product updatedProduct = productRepository.findById(id).orElse(null);
		updatedProduct.setId(product.getId());
		updatedProduct.setVersion(product.getVersion());
		updatedProduct.setName(product.getName());
		updatedProduct.setPrice(product.getPrice());
		return productRepository.save(updatedProduct);
	}

	public void deleteById(int id) {
		productRepository.deleteById(id);
	}

}
