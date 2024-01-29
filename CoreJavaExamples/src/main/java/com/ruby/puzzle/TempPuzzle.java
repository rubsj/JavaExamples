package com.ruby.puzzle;

import java.util.ArrayList;
import java.util.List;

public class TempPuzzle {


        public static boolean isPrime(long num){
            if(num <=1){
                return false;
            }

            for(long i=2; i< num; i++){
                if(num%2 ==0){
                    return false;
                }
            }

            return true;
        }

        public static long[] solution(long n) {
            if(n<2){
                return new long[0];
            }
            // Type your solution here
            long m = n+1;
            Long[] fibSeq = new Long[(int) m];
            List<Long> result = new ArrayList<>();

            fibSeq[0]= 0L;
            fibSeq[1]= 1L;
            // create fib sequence for n numbers
                for(int i=2; i<m; i++){
                    fibSeq[i] = fibSeq[i-1] + fibSeq[i-2];
                }


            // create array for prime for the created sequence

            for(int i=0; i<m;i++){
                if(isPrime(fibSeq[i])){
                    result.add(fibSeq[i]);
                }
            }

            long[] ret = new long[result.size()];
            for(int i=0; i< ret.length;i++){
                ret[i] = result.get(i);
            }

            return ret;

        }



    public static void main(String[] args) {
        //TempPuzzle puzzle = new TempPuzzle();
        long[] result = solution(4);
        System.out.println(result.toString());
    }
}
