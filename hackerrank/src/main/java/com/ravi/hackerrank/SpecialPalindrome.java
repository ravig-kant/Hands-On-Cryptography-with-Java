/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravi.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ravi
 */
public class SpecialPalindrome {

    public class Letter {

        private char _char;
        private Letter _left = null;
        private Letter _right = null;

        public Letter(char[] str) {
            _char = str[0];
            _right = (str.length > 1) ? new Letter(Arrays.copyOfRange(str, 1, str.length), this) : null;
        }

        private Letter(char[] right, Letter left) {
            this(right);
            this._left = left;
        }
        
        private void findSameAlphabetStrings( String lastMatch, List<String> results, Letter remaining){
            StringBuffer sb = new StringBuffer();
            
            if(lastMatch != null)
                sb.append(lastMatch);
            
            Letter right = _right;
            if(right!=null){
                if(right._char == _char){
                    results.add(sb.append(_char).toString());
                    right.findSameAlphabetStrings(sb.toString(), results, remaining);
                }    
            }else{
                remaining = right;
            }
            
        }
        

    }

}
