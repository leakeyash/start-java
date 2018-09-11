package numberandstring;

import java.util.Arrays;

public class MyStringBuffer implements IStringBuffer {

    int capacity = 16;
    int length = 0;
    char[] values;
    public MyStringBuffer(){
        values = new char[capacity];
    }
    public MyStringBuffer(String str){
        this();
        if(null==str)
            return;

        if(capacity<str.length()){
            capacity  = values.length*2;
            values=new char[capacity];
        }

        if(capacity>=str.length())
            System.arraycopy(str.toCharArray(), 0, values, 0, str.length());

        length = str.length();
    }
    @Override
    public void append(String str) {
        insert(length,str);
    }

    @Override
    public void append(char c) {
        append(String.valueOf(c));
    }

    @Override
    public void insert(int pos, char b) {
        insert(pos,String.valueOf(b));
    }

    @Override
    public void insert(int pos, String b) {
        //边界条件判断
        if(pos<0)
            return;

        if(pos>length)
            return;

        if(null==b)
            return;

        //扩容
        while(length+b.length()>capacity){
            capacity = (int) ((length+b.length())*1.5f);
            char[] newValue = new char[capacity];
            System.arraycopy(values, 0, newValue, 0, length);
            values = newValue;
        }

        char[] cs = b.toCharArray();

        //先把已经存在的数据往后移

        System.arraycopy(values, pos, values,pos+ cs.length, length-pos);
        //把要插入的数据插入到指定位置
        System.arraycopy(cs, 0, values, pos, cs.length);

        length = length+cs.length;
    }

    @Override
    public void delete(int start) {
        delete(start,length);
    }

    @Override
    public void delete(int start, int end) {
        if(start<0)
            return;

        if(start>length)
            return;

        if(end<0)
            return;

        if(end>length)
            return;

        if(start>=end)
            return;

        System.arraycopy(values, end, values, start, length- end);
        length-=end-start;
    }

    @Override
    public void reverse() {
        for (int i = 0; i < length/2; i++) {
            char temp = values[i];
            values[i] = values[length-i-1];
            values[length-i-1] = temp;
        }
    }

    @Override
    public int length() {
        return length;
    }
    @Override
    public String toString(){

        char[] realValue = new char[length];

        System.arraycopy(values, 0, realValue, 0, length);

        return new String(realValue);

    }
}
