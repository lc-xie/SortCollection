package shuaTi.others;

/**
 * Created by stephen on 18-5-28.
 * 匹配字符串
 * 实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符
 * 可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class MyMatcher {

    public static void main(String[] args){
        System.out.print(match("assccdhhhjn".toCharArray(),"a*s*.hh*jn".toCharArray()));
    }

    public static boolean match(char[] str, char[] pattern)
    {
        if(str==null&&pattern==null)return true;
        if(str!=null&&pattern==null)return false;
        return match2(str,0,pattern,0);
    }

    public static boolean match2(char[] str, int s1, char[] pattern, int s2){
        if (str==null||(s1==str.length&&s2<pattern.length)){
            while (s2<pattern.length){
                if (pattern[s2]!='*'&&(s2+1>=pattern.length||pattern[s2+1]!='*'))return false;
            }
            return true;
        }
        if (s1==str.length&&s2>=pattern.length)return true;
        if (s1<str.length&&s2>=pattern.length)return false;
        if (s2+1==pattern.length){
            if (pattern[s2]==str[s1]) {
                return match2(str,++s1,pattern,++s2);
            }
            return false;
        }
        if (s1<str.length&&pattern[s2+1]!='*'){
            if(str[s1]==pattern[s2]||pattern[s2]=='.'){
                return match2(str,++s1,pattern,++s2);
            }
            return false;
        }else {
            if (str[s1]==pattern[s2]||pattern[s2]=='.'){
                return match2(str,s1,pattern,s2+2)||
                        match2(str,++s1,pattern,s2+2)||
                        match2(str,++s1,pattern,s2);
            }else {
                return match2(str,s1,pattern,s2+2);
            }
        }
    }


    public static void print(String[][] arr1){
        for (int i=0;i<arr1.length;i++){
            if (arr1[i][0]==null)break;
            for (int j=0;j<arr1[0].length;j++){
                System.out.print(arr1[i][j]+"    ");
            }
            System.out.println();
        }
    }
}
