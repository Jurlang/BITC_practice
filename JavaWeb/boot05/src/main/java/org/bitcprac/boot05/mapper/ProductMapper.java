package org.bitcprac.boot05.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bitcprac.boot05.model.Product;
import org.bitcprac.boot05.model.ProductSize;
import org.bitcprac.boot05.model.productColor;

import java.util.List;

@Mapper
public interface ProductMapper {
	Product selectProduct(Long id);
	List<Product> selectAllProduct();
	void insertProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Long id);
	void hehehehehe(productColor productColor);
}
