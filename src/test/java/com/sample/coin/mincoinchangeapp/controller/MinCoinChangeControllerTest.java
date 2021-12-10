package com.sample.coin.mincoinchangeapp.controller;

import com.sample.coin.mincoinchangeapp.exception.CoinsInsufficientException;
import com.sample.coin.mincoinchangeapp.exception.InvalidBillException;
import com.sample.coin.mincoinchangeapp.service.MinCoinChangeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class MinCoinChangeControllerTest {

    @Mock
    MinCoinChangeService minCoinChangeService;

    @Resource
    @InjectMocks
    MinCoinChangeController minCoinChangeController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        minCoinChangeController = new MinCoinChangeController(minCoinChangeService);
    }

    @Test(expected = InvalidBillException.class)
    public void findMinCoinsTest(){
        ResponseEntity result = minCoinChangeController.findMinCoins(200);
        assertNotNull(result);
    }

    @Test
    public void findMinCoinsTest1(){
        ResponseEntity result = minCoinChangeController.findMinCoins(40);
        assertNotNull(result);
        assertEquals(200, result.getStatusCodeValue());
    }

}