package com.gans.snips.java;

/*
 * a = (a[0], a[1], a[2]) = [5, 6, 7]
 * b = (b[0], b[1], b[2]) = [3, 6, 10]
 * a[0] > b[0], a gets 1 point
 * b[0] > a[0], b gets 1 point
 * a[1] = b[1], nobody gets a point
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;

public class IterateTwoLists {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        
    	Iterator<Integer> i1 = a.iterator();
    	Iterator<Integer> i2 = b.iterator();

    	Integer result1 = 0;
    	Integer result2 = 0;
    	
    	while(i1.hasNext() && i2.hasNext()) {
    		Integer v1 = i1.next();
    		Integer v2 = i2.next();
    		if (v1 > v2) {
    			result1 += 1;
    		} else if (v2 > v1) {
    			result2 += 1;
    		}
    	}
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	result.add(result1);
    	result.add(result2);
        return result;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> r = new ArrayList<Integer>();

        a.add(5);
        a.add(6);
        a.add(7);

        b.add(3);
        b.add(6);
        b.add(10);
        
        r.add(1);
        r.add(1);

        List<Integer> result = compareTriplets(a, b);
        assertArrayEquals(result.toArray(), r.toArray());
        System.out.println(result);
    }
}
