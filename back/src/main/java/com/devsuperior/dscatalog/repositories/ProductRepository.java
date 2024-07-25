package com.devsuperior.dscatalog.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.projections.ProductProjection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true, value = """
			SELECT DISTINCT pd.id, pd.name
			FROM tb_product pd
			INNER JOIN tb_product_category  pc ON pd.id = pc.product_id
			WHERE (:categoryIds IS NULL OR pc.category_id IN :categoryIds)
			AND LOWER(pd.name) LIKE LOWER(CONCAT('%',:name,'%'))
			ORDER BY pd.name
			""", countQuery = """
			SELECT COUNT(*) FROM (
			SELECT DISTINCT pd.id, pd.name
			FROM tb_product pd
			INNER JOIN tb_product_category  pc ON pd.id = pc.product_id
			WHERE (:categoryIds IS NULL OR pc.category_id IN :categoryIds)
			AND LOWER(pd.name) LIKE LOWER(CONCAT('%',:name,'%'))
			ORDER BY pd.name
			) AS tb_result
			""")
	Page<ProductProjection> searchProducts(List<Long> categoryIds, String name, Pageable pageable);

	@Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj.id IN :productIds ORDER BY obj.name")
	List<Product> searchProductsWithCategories(List<Long> productIds);

}
