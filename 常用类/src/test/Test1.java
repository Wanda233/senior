package test;

import sun.security.util.Length;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
//        String s = "   kjkihi jihi  ";
//        String trim = s.trim();
//        String trim1 = trim1(s);
//        System.out.println(trim);
//        System.out.println(trim1);
//
//        String tran = revers(trim,1,4);
//        System.out.println(tran);

        String s1 = "abkkcadkabkebfkabkskab";
        String s2 = "ab";
        System.out.println(prac3(s1,s2));
//        String str1 = "abcwerthelloyuiodef";
//        String str2 = "thelloyuio";
//        System.out.println(prac4(str1,str2));
//        System.out.println(prac5(str2));
    }

    public static String trim1(String s){
        boolean flag = true;
        int indexStart = 0;
        int indexEnd = s.length()-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                if(flag){
                    indexStart = i;
                    flag = false;
                }
                indexEnd = i;
            }
        }
        return s.substring(indexStart,indexEnd+1);
    }

    public static String revers(String s, int start,int end){
        char[] charArray = s.toCharArray();
        char temp;
        for(int i = start;i< (int)((end-start+1)/2) + start;i++){
            temp = charArray[i];
            charArray[i] = charArray[start+end-i];
            charArray[start+end-i] = temp;
        }

        return new String(charArray);
    }

    public static int prac3(String s,String sub){
        int j=0;
        int num=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==sub.charAt(j)){
                j++;
                if(j==sub.length())
                {
                    j=0;
                    num++;
                }
            }
        }
        return num;
    }

    public static String prac4(String s1,String s2){
        int s1Length = s1.length();
        int s2Length = s2.length();
        String sShort = s1Length >= s2Length ? s2 : s1;
        String sLong = s1Length > s2Length ? s1 : s2;
        for(int len=sShort.length();len>0;len--){
            for(int shortStart = 0;shortStart<sShort.length()-len+1;shortStart++){
                for(int lstart = 0;lstart<sLong.length()-len+1;lstart++){
                    String sub1 = sShort.substring(shortStart,shortStart+len);
                    String sub2 = sLong.substring(lstart,lstart+len);
                    if(sub1.equals(sub2))
                        return sShort.substring(shortStart,shortStart+len);

                }
            }
        }
        return null;
    }
    public static String prac5(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
