package com.sparta.week04.service;

import com.sparta.week04.models.ItemDto;
import com.sparta.week04.models.Product;
import com.sparta.week04.models.ProductMypriceDto;
import com.sparta.week04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    //db정보까지 update -> Transactional
    @Transactional
    //update하는 메소드
    public Long update(Long id, ProductMypriceDto mypriceDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("아이디가 존재하지 않습니다")
        );
        product.update(mypriceDto);
        return id;
    }

    @Transactional
    public Long updateBySearch(Long id, ItemDto itemDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        product.updateByDto(itemDto);
        return id;
    }
}
