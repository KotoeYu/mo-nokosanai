package jp.co.developersb.service.chapter4_service;

import jp.co.developersb.dto.chapter4_dto.ProductRequest4;
import jp.co.developersb.dto.chapter4_dto.ProductResponse4;
import jp.co.developersb.exception.ProductAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectureProductService4 {
    private final List<ProductResponse4> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductResponse4 createProduct(ProductRequest4 request) {
        boolean exists = products.stream()
                .anyMatch(product -> product.name().equals(request.name()));

        if (exists) {
            throw new ProductAlreadyExistsException("同じ商品名の商品は登録できません");
        }

        ProductResponse4 product = new ProductResponse4(
                nextId,
                request.name(),
                request.price(),
                request.stock()
        );
        products.add(product);
        nextId++;
        return product;
    }
    public List<ProductResponse4> findAllProducts() {
        return products;
    }
}