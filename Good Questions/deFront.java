/*
Given a string, return a version without the first 2 chars. Except keep the first char if it is 'a' and keep the second char if it is 'b'. The string may be any length. Harder than it looks.

deFront("Hello") → "llo"
deFront("java") → "va"
deFront("away") → "aay"
*/

public String deFront(String str) {
    if (str.length() < 2){
        return str.equals("a") ? "a" : "";
    }

    char[] chars = str.toCharArray();
    StringBuilder result = new StringBuilder();

    if (chars[0] == 'a') {
        result.append(chars[0]);
    }

    if (chars[1] == 'b') {
        result.append(chars[1]);
    }

    result.append(str.substring(2));

    return result.toString();
}