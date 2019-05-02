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

    public static class Letter {

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
        
        private Letter(char a, Letter left, Letter right){
            _char = a;
            _left = left;
            _right = right;
        }
        
        public Letter next(){
            return this._right;
        }
        
        public Letter findSameAlphabetStrings( String lastMatch, List<String> results){
            StringBuffer sb = new StringBuffer();
            
            if(lastMatch != null)
                sb.append(lastMatch);
            
            Letter right = _right;
            if(right!=null){
                if(right._char == _char){
                    results.add(sb.append(_char).toString());
                    return right.findSameAlphabetStrings(sb.toString(), results);
                }    
                else{
                    results.add(sb.append(_char).toString());
                    return right;
                }
            }    
            
            results.add(sb.append(_char).toString());
            return null;
        }
        
        public void findMirrorAlphabetStrings( String lastMatch, List<String> results){

            if(this._left == null || this._right == null)
                return;
            
            StringBuffer sb = new StringBuffer();
            if( this._left._char == this._right._char  && this._char != this._left._char){
                sb.append(this._left._char);
                
                if(lastMatch != null)
                    sb.append(lastMatch);
                else
                    sb.append(_char);
                
                sb.append(this._right._char);
                
                results.add(sb.toString());
                
                Letter trimmed = new Letter(this._char , this._left._left, this._right._right);
                trimmed.findMirrorAlphabetStrings(sb.toString(), results);
            }
        }

    }
}
