package com.example.restaurant.wishlist.repository;

import com.example.restaurant.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class wishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create(){
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("readAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);

        return wishList;
    }


    @Test
    public void saveTest(){
        WishListEntity wishListEntity = create();
        WishListEntity expected = wishListRepository.save(wishListEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1,expected.getIndex());

    }

    @Test
    public void findByIdTest(){
        WishListEntity wishListEntity = create();
        wishListRepository.save(wishListEntity);

        Optional<WishListEntity> expected = wishListRepository.findById(1);

        Assertions.assertEquals(true,expected.isPresent());
        Assertions.assertEquals(1,expected.get().getIndex());


    }

    @Test
    public void deleteTest(){
        WishListEntity wishListEntity = create();
        wishListRepository.save(wishListEntity);

        wishListRepository.deleteById(1);

        int count = wishListRepository.listAll().size();

        Assertions.assertEquals(0,count);

    }

    @Test
    public void listAllTest(){
        WishListEntity wishListEntity1 = create();
        wishListRepository.save(wishListEntity1);

        WishListEntity wishListEntity2 = create();
        wishListRepository.save(wishListEntity2);

        int count = wishListRepository.listAll().size();

        Assertions.assertEquals(2,count);






    }





}