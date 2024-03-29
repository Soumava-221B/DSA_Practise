/*
Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values, it does not count towards the sum.

loneSum(1, 2, 3) → 6
loneSum(3, 2, 3) → 2
loneSum(3, 3, 3) → 0
*/

public int loneSum(int a, int b, int c) {
    if(a == 0 && b == 0){
        return 0;
    }
    else if(a == b){
        return b;
    }
    else if(a == c) {
        return b;
    }
    else if(b == c) {
        return a;
    }
    return a + b + c;
}