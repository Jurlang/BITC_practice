package org.bitcprac.boot05.controller;

import lombok.RequiredArgsConstructor;
import org.bitcprac.boot05.mapper.ProductMapper;
import org.bitcprac.boot05.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductMapper pMapper;

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		Product product = pMapper.selectProduct(id);
		return product;
	}
	@GetMapping
	public List<Product> getProducts() {
		List<Product> pList = pMapper.selectAllProduct();
		return pList;
	}
	@PostMapping
	public void addProduct(@RequestParam String name, @RequestParam int price) {
		Product p = new Product();
		p.setProdName(name);
		p.setProdPrice(price);
		pMapper.insertProduct(p);
	}
	@PutMapping("/{id}")
	public void updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam int price) {
		Product p = pMapper.selectProduct(id);
		p.setProdName(name);
		p.setProdPrice(price);
		pMapper.updateProduct(p);
	}
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		pMapper.deleteProduct(id);
	}

}
