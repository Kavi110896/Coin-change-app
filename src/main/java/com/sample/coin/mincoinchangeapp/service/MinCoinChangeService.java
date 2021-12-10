package com.sample.coin.mincoinchangeapp.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MinCoinChangeService {
	
	List<Integer> coinDenominations = new ArrayList<>();
    public Map<Integer, Integer> findMinCoins(int bill, Map<Integer, Integer> updatedCoins, Object[] coins, Object[] counts) {
        bill = bill * 100;
        int ans = minCount(updatedCoins, bill, 0, 0, 0);
        System.out.println("Coins Denomination: " + coinDenominations);
        Map<Integer, Integer> mp = findCoinsDenoMap(ans, coins, counts);
        return mp;
    }
    
    public Map<Integer, Integer> findCoinsDenoMap(int minCountVal, Object[] coins, Object[] counts) {
    	Map<Integer, Integer> coinDenoMap = new HashMap<>();
    	if(minCountVal < (Integer) counts[0]) {
    		coinDenoMap.put((Integer) coins[0], minCountVal);
    	}
    	else if(minCountVal - (Integer) counts[0] >= 0) {
    		coinDenoMap.put((Integer) coins[0], (Integer) counts[0]);
    		minCountVal = minCountVal - (Integer) counts[0];
	    	if(minCountVal - (Integer) counts[1] < 0) {
	    		coinDenoMap.put((Integer) coins[1], minCountVal);
	    	}
	    	else if(minCountVal - (Integer) counts[1] >= 0) {
	    		coinDenoMap.put((Integer) coins[1], (Integer) counts[1]);
	    		minCountVal = minCountVal - (Integer) counts[1];
		    	if(minCountVal - (Integer) counts[2] < 0) {
		    		coinDenoMap.put((Integer) coins[2], minCountVal);
		    	}
		    	else if(minCountVal - (Integer) counts[2] >= 0) {
		    		coinDenoMap.put((Integer) coins[2], (Integer) counts[2]);
		    		minCountVal = minCountVal - (Integer) counts[2];
			    	if(minCountVal - (Integer) counts[3] <= 0) {
			    		coinDenoMap.put((Integer) coins[3], minCountVal);
			    	}
			    	else if(minCountVal - (Integer) counts[3] >= 0) {
			    		coinDenoMap.put((Integer) coins[3], (Integer) counts[3]);
			    	}
		    	}
	    	}
    	}
    	System.out.println("Coin Map: " + coinDenoMap);
    	return coinDenoMap;
    }

    public int minCount(Map<Integer, Integer> updatedCoins, int target, int sum, int current, int count) {
        if(current > updatedCoins.size()) return -1;
        if(sum == target) {
        	coinDenominations.add(current);
        	current-=1;
        	return count;
        }
        if(sum + updatedCoins.get(current) <= target){
            return minCount(updatedCoins, target, sum+updatedCoins.get(current), current+1, count+1);
        } else {
            return minCount(updatedCoins, target, sum, current+1, count);
        }
    }

    public Map<Integer, Integer> combine(Object[] objects, Object[] objects2) {
        int sum = 0;
        for (Object count : objects2) {
            sum += (int)count;
        }
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        int[] returnArray = new int[sum];
        int returnArrayIndex = 0;
        for (int i = 0; i < objects.length; i++) {
            int count = (int) objects2[i];
            while (count != 0) {
            	resultMap.put(returnArrayIndex, (Integer) objects[i]);
                returnArrayIndex++;
                count--;
            }
        }
        for(int coin : resultMap.keySet())
        System.out.println(resultMap.get(coin));
        return resultMap;
    }
    
}