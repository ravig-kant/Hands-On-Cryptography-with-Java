/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ravi.hackerrank.SpecialPalindrome;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ravigu
 */
public class TestSpecialPalindrome {
    
    public TestSpecialPalindrome() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testMirrors() {
         SpecialPalindrome.Letter sp = new SpecialPalindrome.Letter("abcdcba".toCharArray());
         
         String[] res = {"cdc","bcdcb","abcdcba"};
         
         List<String> results = Arrays.asList(res);
         
         List<String> testResults = new ArrayList<>();
         while(sp.next() != null){
            sp = sp.next();
            sp.findMirrorAlphabetStrings(null, testResults);
         }    
         
         Assert.assertArrayEquals(results.toArray(), testResults.toArray());
         
         
         sp = new SpecialPalindrome.Letter("abcdcbae".toCharArray());
         testResults = new ArrayList<>();
         while(sp.next() != null){
            sp = sp.next();
            sp.findMirrorAlphabetStrings(null, testResults);
         }    
         Assert.assertArrayEquals(results.toArray(), testResults.toArray());
         
        sp = new SpecialPalindrome.Letter("eabcdcba".toCharArray());
         testResults = new ArrayList<>();
         while(sp.next() != null){
            sp = sp.next();
            sp.findMirrorAlphabetStrings(null, testResults);
         }    
         Assert.assertArrayEquals(results.toArray(), testResults.toArray());
         
     }
     
     @Test
     public void testSymmetery() {
         SpecialPalindrome.Letter sp = new SpecialPalindrome.Letter("abcccda".toCharArray());
         
         String[] res = {"a","b","c","cc","ccc","d","a"};
         
         List<String> results = Arrays.asList(res);
         
         List<String> testResults = new ArrayList<>();
         sp = sp.findSameAlphabetStrings(null, testResults);
         while(sp != null){
            sp = sp.findSameAlphabetStrings(null, testResults);
         }    
         
         Assert.assertArrayEquals(results.toArray(), testResults.toArray());        
     }
}
