package com.sparta.week04.controller;

import com.sparta.week04.models.ItemDto;
import com.sparta.week04.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchRequestController {
    //NaverShopSearch component로 등록했기 때문에 사용할 수 있음
    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    //RequestParam -> /api/search뒤에 ?query="query" 들어가게!
    public List<ItemDto> searchItem(@RequestParam String query){
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }

}
