package com.example.issuemanagement.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public class TPage<T> {
    //bunlar mapping için
    private int number; //kaçıncı sayfa
    private int size; //kayıtları kaçarlı gösterecek
    private Sort sort;//springin sortu kolunun sıralaması
    private int totalPages;//toplam kaç sayfa
    private Long totalElements;//toplam kaç kayıt var
    private List<T> content; //dönecek data

    public void setStat(Page page,List<T> list){ //springin nesnelerini kendi nesnemize dolduruyoruz
        this.number=page.getNumber();
        this.size=page.getSize();
        this.sort=page.getSort();
        this.totalPages=page.getTotalPages();
        this.totalElements=page.getTotalElements();
        this.content=list;

    }

}
