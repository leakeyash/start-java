package io;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Encoding {
    public static void main(String[] args){
        decoding();
        removeDOM();
        File f=new File("F:\\test\\henry\\a.txt");
        try (FileInputStream fis=new FileInputStream(f);){
            byte[] b =new byte[(int)f.length()];
            fis.read(b);
            System.out.println("首先确认按照UTF-8识别出来有？");
            String st=new String(b,"UTF-8");
            System.out.println(st);
            System.out.println("根据前面的所学 知道‘中’字对应的UTF-8编码是：E4 B8 AD");
            System.out.println("打印出文件里所有的数据的16进制是:");
            print(b);
            System.out.println("通过观察得出 UTF-8 的BOM是ef bb bf");
            byte[] bom = new byte[3];
            b[0]=(byte)0xef;
            b[1]=(byte)0xbb;
            b[2]=(byte)0xbf;
            byte[] fileContentWithoutBom= removeBom(b,bom);
            System.out.println("去掉了BOM之后的数据的16进制是：");
            print(fileContentWithoutBom);
            System.out.println("对应的字符串就没有问号了：");
            String strWithoutBom=new String(fileContentWithoutBom,"UTF-8");
            System.out.println(strWithoutBom);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    private static void print(byte[] b) {
        for(byte s:b){
            int i=s&0xff;
            System.out.print(Integer.toHexString(i)+" ");
        }
        System.out.println();
    }

    private static byte []removeBom(byte[] b,byte[] bom){
        return Arrays.copyOfRange(b, bom.length, b.length);
    }

    public static void decoding() {
        //找出 E5 B1 8C 这3个十六进制数对应的UTF-8编码的汉字
        byte[] b=new byte[3];
        b[0]=(byte)0xE5;
        b[1]=(byte)0xB1;
        b[2]=(byte)0x8C;

        String str=new String(b, StandardCharsets.UTF_8);
        System.out.println("E5 B1 8C 对应的字符是："+str);
    }

    private static void removeDOM(){
        File file = new File("F:\\test\\henry\\a.txt");
        try(FileInputStream re=new FileInputStream(file)) {
            byte[] origin=new byte[(int)file.length()];
            re.read(origin);
            byte[] result=new byte[origin.length-3];
            System.arraycopy(origin, 3, result, 0, origin.length-3);
            for (byte b : result) {
                int i=b&0xff;
                System.out.println(Integer.toHexString(i));
            }
            System.out.println(new String(result, StandardCharsets.UTF_8));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
