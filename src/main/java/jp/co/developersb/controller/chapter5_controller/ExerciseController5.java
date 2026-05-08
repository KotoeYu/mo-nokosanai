package jp.co.developersb.controller.chapter5_controller;

import jakarta.validation.Valid;
import jp.co.developersb.dto.chapter5_dto.ProductRequest5;
import jp.co.developersb.dto.chapter5_dto.ProductResponse5;
import jp.co.developersb.service.chapter5_service.ExerciseProductService5;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chapter5-exercise")
public class ExerciseController5 {

    private final ExerciseProductService5 exerciseProductService;

    public ExerciseController5(ExerciseProductService5 exerciseProductService) {
        this.exerciseProductService = exerciseProductService;
    }

    @PostMapping("/product")
    public ProductResponse5 createProduct(@Valid @RequestBody ProductRequest5 request) {
        // TODO: 5.exerciseProductServiceのcreateProductメソッドを呼び出してください
        return exerciseProductService.createProduct(request);
    }

    @GetMapping("/product")
    public List<ProductResponse5> findAllProducts() {
        // TODO: 7.exerciseProductServiceのfindAllProductsメソッドを呼び出してください
        return exerciseProductService.findAllProducts();
    }
}
