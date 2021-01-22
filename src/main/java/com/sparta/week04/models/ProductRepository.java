package com.sparta.week04.models;

import org.springframework.data.jpa.repository.JpaRepository;

//<어떤대상으로 jpa를 할건지,id 형태>
public interface ProductRepository extends JpaRepository<Product,Long> {

}
