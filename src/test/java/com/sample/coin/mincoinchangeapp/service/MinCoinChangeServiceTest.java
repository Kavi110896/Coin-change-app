package com.sample.coin.mincoinchangeapp.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class MinCoinChangeServiceTest {

    @InjectMocks
    MinCoinChangeService minCoinChangeService;

    @Before
    public void setUp(){
        minCoinChangeService = new MinCoinChangeService();
    }

//    @Test
//    public void findMinCoinsTest(){
//         Map<Integer, Integer> result = minCoinChangeService.findMinCoins(20);
//         assertNotNull(result);
//        assertEquals(80, result);
//    }
//
//    @Test
//    public void findMinCoinsTest2(){
//    	Map<Integer, Integer> result = minCoinChangeService.findMinCoins(50);
//    	assertNotNull(result);
//        assertEquals(400, result);
//    }

//    @Test
//    public void minCountTest(){
//        int[] counts = new int[]{100, 100, 100, 100};
//        int[] coins = new int[]{25, 10, 5, 1};
//        int[] nums = minCoinChangeService.combine(coins, counts);
//        int result = minCoinChangeService.minCount(nums, 2000, 0, 0 , 0);
//        assertEquals(120, result);
//    }

//    @Test
//    public void minCountTest1(){
//        int[] counts = new int[]{100, 100, 100, 100};
//        int[] coins = new int[]{25, 10, 5, 1};
//        int[] nums = minCoinChangeService.combine(coins, counts);
//        assertNotNull(nums);
//        int result = minCoinChangeService.minCount(nums, 1000, 0, 0 , 0);
//        assertEquals(240, result);
//    }

//    @Test
//    public void combineTest(){
//        int[] counts = new int[]{100, 50, 35, 0};
//        int[] coins = new int[]{25, 10, 5, 1};
//        int[] result = minCoinChangeService.combine(coins, counts);
//        assertNotNull(result);
//        assertEquals(185, result.length);
//        assertEquals(100, Arrays.stream(result).filter(coin -> coin == 25).count());
//        assertEquals(50, Arrays.stream(result).filter(coin -> coin == 10).count());
//        assertEquals(35, Arrays.stream(result).filter(coin -> coin == 5).count());
//        assertEquals(0, Arrays.stream(result).filter(coin -> coin == 1).count());
//    }

//    @Test
//    public void combineTest2(){
//        int[] counts = new int[]{80, 60, 15, 20};
//        int[] coins = new int[]{25, 10, 5, 1};
//        int[] result = minCoinChangeService.combine(coins, counts);
//        assertNotNull(result);
//        assertEquals(175, result.length);
//        assertEquals(80, Arrays.stream(result).filter(coin -> coin == 25).count());
//        assertEquals(15, Arrays.stream(result).filter(coin -> coin == 5).count());
//        assertEquals(20, Arrays.stream(result).filter(coin -> coin == 1).count());
//        assertEquals(60, Arrays.stream(result).filter(coin -> coin == 10).count());
//    }
}