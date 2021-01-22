package com.sparta.week04.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Product extends Timestamped{

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    //사용자가 설정한 가격
    @Column(nullable = false)
    private int myprice;

    //관심상품 등록을 위한 생성자 만들기
    public Product(ProductRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.link=requestDto.getLink();
        this.image = requestDto.getImage();
        this.lprice = requestDto.getLprice();
        //최저가 딱지는 사용자가 설정한 가격보다 작을때만 뜨게
        this.myprice=0;
        //0으로 함으로써 일단 최저가딱지 안뜨게
    }

    public void update(ProductMypriceDto mypriceDto){
        this.myprice = mypriceDto.getMyprice();
    }

    public void updateByDto(ItemDto itemDto){
        this.lprice = itemDto.getLprice();
    }
}