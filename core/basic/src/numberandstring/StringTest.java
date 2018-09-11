package numberandstring;

import java.util.Arrays;

public class StringTest {
    public void test(){
        String str1 = "let there be light";
        String[] sl = str1.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String s : sl) {
            char[] cc = s.toCharArray();
            cc[0] = Character.toUpperCase(cc[0]);
            sb.append(new String(cc)).append(" ");
        }
        System.out.println(sb.toString().trim());

        String str2 ="peter piper picked a peck of pickled peppers";
        String[] sl2 = str2.split(" ");
        System.out.println(Arrays.toString(sl2));
        int count =0;
        for (String s : sl2) {
            if(s.startsWith("p")){
                count++;
            }
        }
        System.out.println(count);

        String str3 ="lengendary";
        char[] cl = str3.toCharArray();
        for(int i=0;i<cl.length;i+=2){
            cl[i]= Character.toUpperCase(cl[i]);
        }
        System.out.println(new String(cl));

        String str4 ="Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
        int index = str4.lastIndexOf("two");
        char[] word = str4.toCharArray();
        word[index] = Character.toUpperCase(word[index]);
        System.out.println(new String(word));
    }
}
