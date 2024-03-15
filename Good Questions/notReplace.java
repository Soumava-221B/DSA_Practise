/*
Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not". The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does not count. (Note: Character.isLetter(char) tests if a char is a letter.)

notReplace("is test") → "is not test"
notReplace("is-is") → "is not-is not"
notReplace("This is right") → "This is not right"
*/

public String notReplace(String str) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while(i < str.length()) {
      if(isValid(i, str)) {
        sb.append("is not");
        i += 2;
      }else {
        sb.append(str.charAt(i));
        i++;
      }
    }
    return sb.toString();
  }
  public boolean isValid(int idx, String str) {
    return (idx + 1 < str.length() && str.substring(idx, idx + 2).equals("is") && (idx - 1 == -1 || idx - 1 >= 0 && !Character.isLetter(str.charAt(idx - 1))) && (idx + 2 == str.length() || !Character.isLetter(str.charAt(idx + 2))));
  } 
  /*
  1. we are comparing 2 characters -> (idx, idx + 1) => idx + 1 < str.length();
  2. str.substring(idx, idx + 2).equals("is");
  3. There should not be a letter before "is"
    - first "is" => for character 'i' the index = 0, index - 1 == -1
    - (idx - 1 >= 0 && !Character.isLetter(str.charAt(idx - 1)))
  4. There should not be a letter after "is"
    - last "is" => for character 'i' the , index + 2 == len of string
    - (idx + 1 < str.length() && !Character.isLetter(str.charAt(idx + 1)))
  */