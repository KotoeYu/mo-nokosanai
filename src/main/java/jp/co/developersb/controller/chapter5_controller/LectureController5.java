package jp.co.developersb.controller.chapter5_controller;

import jakarta.validation.Valid;
import jp.co.developersb.dto.chapter5_dto.ProductRequest5;
import jp.co.developersb.dto.chapter5_dto.ProductResponse5;
import jp.co.developersb.service.chapter5_service.LectureProductService5;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/chapter5-lecture")
public class LectureController5 {

    private final LectureProductService5 lectureProductService;

    public LectureController5(LectureProductService5 lectureProductService) {
        this.lectureProductService = lectureProductService;
    }

    @PostMapping("/product")
    public ProductResponse5 createProduct(@Valid @RequestBody ProductRequest5 request) {
        return lectureProductService.createProduct(request);
    }

    @GetMapping("/product")
    public List<ProductResponse5> findAllProducts() {
        return lectureProductService.findAllProducts();
    }
    @PutMapping("/product/{id}")
    public ProductResponse5 updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest5 request) {
        return lectureProductService.updateProduct(id, request);
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        lectureProductService.deleteProduct(id);
    }
    }
