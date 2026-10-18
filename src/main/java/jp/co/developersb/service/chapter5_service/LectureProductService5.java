package jp.co.developersb.service.chapter5_service;

import jp.co.developersb.dto.chapter5_dto.ProductRequest5;
import jp.co.developersb.dto.chapter5_dto.ProductResponse5;
import jp.co.developersb.entity.chapter5_entity.ProductEntity5;
import jp.co.developersb.repository.chapter5_repository.ProductRepository5;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureProductService5 {

    private final ProductRepository5 productRepository;

    public LectureProductService5(ProductRepository5 productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse5 createProduct(ProductRequest5 request) {
        ProductEntity5 product = new ProductEntity5(
                request.name(),
                request.category(),
                request.quantity(),
                request.expiryDate(),
                request.memo()
        );
        ProductEntity5 savedProduct = productRepository.save(product);
        return toResponse(savedProduct);
    }


    public ProductResponse5 updateProduct(Long id, ProductRequest5 request) {
        ProductEntity5 product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("データが見つかりません"));

        product.update(
                request.name(),
                request.category(),
                request.quantity(),
                request.expiryDate(),
                request.memo()
        );

        ProductEntity5 updatedProduct = productRepository.save(product);

        return toResponse(updatedProduct);
    }

    public void deleteProduct(Long id) {
        ProductEntity5 product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("データが見つかりません"));

        productRepository.delete(product);
    }

    public List<ProductResponse5> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private ProductResponse5 toResponse(ProductEntity5 product) {
        return new ProductResponse5(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getQuantity(),
                product.getExpiryDate(),
                product.getMemo()
        );
    }
}