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
        
        private void findUsingFirstRule( String lastMatch, List<String> results){
            StringBuffer sb = new StringBuffer();
            sb.append(lastMatch);
            Letter left = _left;
            sb.append(_char);
            if(left!=null){
                if(left._char == _char){
                    results.add(sb.append(_char).toString());
                    left.findUsingFirstRule(sb.toString(), results);
                }    
            }
            
        }
        

    }

}
