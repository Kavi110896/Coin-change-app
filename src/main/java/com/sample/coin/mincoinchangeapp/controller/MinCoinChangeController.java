package com.sample.coin.mincoinchangeapp.controller;

import com.sample.coin.mincoinchangeapp.exception.CoinsInsufficientException;
import com.sample.coin.mincoinchangeapp.exception.InvalidBillException;
import com.sample.coin.mincoinchangeapp.service.MinCoinChangeService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/min-coin-change")
public class MinCoinChangeController {
	
	private static boolean restart = true;
	
    private final MinCoinChangeService minCoinChangeService;

	private static LinkedHashMap<Integer, Integer> updatedCount = new LinkedHashMap<Integer, Integer>(){
		{
			put(25, 100);
			put(10, 100);
			put(5, 100);
			put(1, 100);
			
		}
	};

    @Autowired
    public MinCoinChangeController(MinCoinChangeService minCoinChangeService) {
        this.minCoinChangeService = minCoinChangeService;
    }

    @GetMapping("/get-change/{bill}")
    public ResponseEntity<?> findMinCoins(@PathVariable("bill") int bill) {
    	Map<Integer, Integer> result = new HashMap<Integer, Integer>();
    	Map<Integer, Integer> updatedCoins = new HashMap<Integer, Integer>();
    	
        if(bill < 1 || bill > 100) {
            throw new InvalidBillException("Bill value not in range!");
        }
        if(bill != 1 && bill != 2 && bill != 5 && bill != 10 && bill != 20 && bill != 50 && bill != 100)
        {
        	throw new InvalidBillException("Bad input of the bill!");
        }
//        int res = minCoinChangeService.findMinCoins(bill);
//        if(res == -1) {
//            throw new CoinsInsufficientException("Coins not sufficient to make the change!");
//        }
        if(!restart) {
        	updatedCoins = minCoinChangeService.combine(updatedCount.keySet().toArray(), updatedCount.values().toArray());
        	result = minCoinChangeService.findMinCoins(bill, updatedCoins, updatedCount.keySet().toArray(), updatedCount.values().toArray());
        	getUpdatedCoins(result);
        }
        else
        {
            result = minCoinChangeService.combine(updatedCount.keySet().toArray(), updatedCount.values().toArray());
        	result = minCoinChangeService.findMinCoins(bill, result, updatedCount.keySet().toArray(), updatedCount.values().toArray());
        	getUpdatedCoins(result);
        	restart = false;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    private void getUpdatedCoins(Map<Integer, Integer> result){
    	for(int coin : result.keySet()) {
    		if(coin == 25)
    			updatedCount.put(coin, updatedCount.get(coin) - result.get(coin));
    		else if(coin == 10)
    			updatedCount.put(coin, updatedCount.get(coin) - result.get(coin));
    		else if(coin == 5)
    			updatedCount.put(coin, updatedCount.get(coin) - result.get(coin));
    		else
    			updatedCount.put(coin, updatedCount.get(coin) - result.get(coin));
    	}
    }
}
