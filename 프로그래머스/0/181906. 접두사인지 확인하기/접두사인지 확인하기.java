class Solution {
    public int solution(String my_string, String is_prefix) {
        int size = is_prefix.length() > my_string.length() ? my_string.length() : is_prefix.length();
        
        System.out.println(my_string.substring(0, size));
        if (my_string.substring(0, size).equals(is_prefix))
            return 1;
        else return 0;
        
    }
}