package jp.co.developersb.controller.chapter4_controller;

import jp.co.developersb.dto.chapter4_dto.ProductRequest4;
import jp.co.developersb.dto.chapter4_dto.ProductResponse4;
import jp.co.developersb.service.chapter4_service.LectureProductService4;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapter4-lecture")
public class LectureController4 {

    private final LectureProductService4 lectureProductService;

    public LectureController4(LectureProductService4 lectureProductService) {
        this.lectureProductService = lectureProductService;
    }

    @PostMapping("/product")
    public ProductResponse4 createProduct(@Valid @RequestBody ProductRequest4 request) {
        return lectureProductService.createProduct(request);
    }

    @GetMapping("/product")
    public List<ProductResponse4> findAllProducts() {
        return lectureProductService.findAllProducts();
    }
}