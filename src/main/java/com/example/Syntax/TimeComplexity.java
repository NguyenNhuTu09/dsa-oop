package com.example.Syntax;

public class TimeComplexity {
    public static int solutionJump(int X, int Y, int D){
        int countJump = 0;
        do { 
            X += D;
            countJump++;
        } while (X < Y);
        return countJump;
    }
    public static void main(String[] args) {
        int X = 10;
        int Y = 85;
        int D = 30;
        System.err.println(solutionJump(X, Y, D));
    }
}
