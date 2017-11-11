package com.ruby.codegolf;

/**
 * The "prime frog" is a strange animal that jumps between integers, until it arrives on 3 or 19...
 *
 * Your program should accept an integer n as input and output the result of the below algorithm (3 or 19).

 For a given integer n >= 2:

 1. Let f be the position of the frog. It is initially set to n
 2. if f = 3 or f = 19 : the frog stops jumping - halt the program and output f.
 3. if f is prime : the frog jumps to the position 2×f-1. Go back to step 2.
 4. if f is composite : let d be f's biggest prime divisor. The frog jumps to the position f-d. Go back to step 2.
 *
 *
 * Examples:

 An example with n = 5:

 5 > 9 > 6 > 3 stop
 The program should output 3.

 Another example with n = 23:

 23 > 45 > 40 > 35 > 28 > 21 > 14 > 7 > 13 > 25 > 20 > 15 > 10 > 5 > 9 > 6 > 3 stop
 Again, the program should output 3.

 Test cases:

 10 => 3
 74 => 19
 94 => 3
 417 => 3
 991 => 19
 9983 => 19

 Trivia
 3 loop is [3 5 9 6 3] and 19 loop is [19 37 73 145 116 87 58 29 57 38 19]
 
 */
public class PrimeFrog {

    private int jumpingFrog(int n){
/*        n->{                  // Method with integer as both parameter and return-type
            for(int f,          //  Flag-integer
                t,          //  Temp-integer
                m=1;        //  Max prime factor integer, starting at 0
                57%n>0;         //  Loop (1) as long as `n` is not 3, not 19 and not 57:
                n=f>n?
                        2*n-1        //     Change `n` to `2*n-1`
                        :             //    Else:
                        n-m)         //     Change `n` to `n-m`
                for(t=n,          //   Reset `t` to `n`
                            f=1;          //   Reset `f` to 1
                    f++<t;)       //   Inner loop (2) from 2 to `t` (inclusive)
                    for(;t%f<1;     //    Inner loop (3) as long as `t` is divisible by `f`
                        t/=m=f;       //     Set `m` to `f`, and set `t` to `t/f`
      );              //    End of inner loop (3)
            //   End of inner loop (2) (implicit / single-line body)
            //  End of loop (1) (implicit / single-line body)
            return n%38;        //  Return `n%38`, which is now either 3 or 19
        }*/
        return 0;
    }

    private int oldPrimeFrog(int n , boolean shouldPrintLog){
        // f is Flag-integer , t is  Temp-integer , m is   Max prime factor integer, starting at 0
        //Loop (1) as long as `n` is not 3, not 19 and not 57:
        //    After every iteration: if `f` is larger than `n`:  Change `n` to `2*n-1` Else:   Change `n` to `n-m`
          for(int f=0,t, m=1; 57%n>0;   n=f>n?2*n-1 :n-m){
              if(shouldPrintLog) {
                  System.out.printf("Inside first loop value of flag f is %d , value of max prime factor m is %d , value of n is %d %n", f, m, n);
              }
              //   Reset `t` to `n`  ,  Reset `f` to 1
              //   Inner loop (2) from 2 to `t` (inclusive)
              for(t=n, f=1; f++<t;){
                  if(shouldPrintLog){
                      System.out.printf("Inside second loop value of temp t is %d %n" ,t);
                  }
                  //    Inner loop (3) as long as `t` is divisible by `f`
                  for( ;t%f<1;){
                      t/=m=f;  //     Set `m` to `f`, and set `t` to `t/f`
                      if(shouldPrintLog) {
                          System.out.printf("Inside third loop value of temp t is %d and value of m is %d and value of f is%d %n", t, m, f);
                      }
                  }
              }
          }
        return n%38;      //  Return `n%38`, which is now either 3 or 19
    }

    public static void main(String[] args) {
        PrimeFrog primeFrog = new PrimeFrog();
        int[] inputs = new int[] {10, 74,94,417, 991,9983};
        for (int i: inputs) {
            System.out.printf("For the input %d the final answer is %d %n" ,    i ,   primeFrog.oldPrimeFrog(i , false));
        }

    }

}

