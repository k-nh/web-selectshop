package com.sparta.week04.controller;

import com.sparta.week04.models.Product;
import com.sparta.week04.models.ProductMypriceDto;
import com.sparta.week04.models.ProductRepository;
import com.sparta.week04.models.ProductRequestDto;
import com.sparta.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//ProductRestController을 사용할때는 반드시 ProductRepository가 있어야함을 표시
@RequiredArgsConstructor
@RestController
public class ProductRestController {

    //원할때마다 자동적으로 생성->final(꼭 필요한것일때 붙임)
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto){
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{id}")
    public Long editMyprice(@PathVariable Long id, @RequestBody ProductMypriceDto productMypriceDto){
        return productService.update(id, productMypriceDto);
    }

}
