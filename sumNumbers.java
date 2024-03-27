/*
Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)

sumNumbers("abc123xyz") → 123
sumNumbers("aa11b33") → 44
sumNumbers("7 11") → 18
*/

public int sumNumbers(String str) {
    int sum = 0;
      StringBuilder numStr = new StringBuilder();
  
      for (int i = 0; i < str.length(); i++) {
          char c = str.charAt(i);
          if (Character.isDigit(c)) {
              numStr.append(c);
          } else {
              if (numStr.length() > 0) {
                  sum += Integer.parseInt(numStr.toString());
                  numStr.setLength(0);
              }
          }
      }
  
      // Add the last number if the string ends with a digit sequence
      if (numStr.length() > 0) {
          sum += Integer.parseInt(numStr.toString());
      }
  
      return sum;
  }