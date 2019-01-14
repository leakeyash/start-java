package io;

import java.io.*;
import java.nio.file.Paths;

public class Stream {
    private static final String dir ="F:\\test\\henry";
    public static void main(String[] args){
        File encodingFile = setupFile();
        File encodedFile = Paths.get(dir,"encodedFile.g").toFile();
        encodeFile(encodingFile,encodedFile);
        try(FileReader fr = new FileReader(encodedFile)){
            char[] cs = new char[(int)encodedFile.length()];
            fr.read(cs);
            System.out.println(cs);
        } catch (IOException ex){

        }
    }
    private static File setupFile(){
        File encodingFile = Paths.get(dir,"encodingFile.g").toFile();
        try(FileWriter fw = new FileWriter(encodingFile)){
            String data = "la9zZ!@#$%^&*()_+|";
            char[] cs = data.toCharArray();
            fw.write(cs);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return encodingFile;
    }
    public static void encodeFile(File encodingFile, File encodedFile){
        try(FileReader fr = new FileReader(encodingFile)){

            char[] all = new char[(int)encodingFile.length()];
            int count = fr.read(all);
            char[] result = new char[count];
            for(int i=0;i<count;i++){
                result[i] = encoding(all[i]);
            }
            try(FileWriter fw = new FileWriter(encodedFile)){
                fw.write(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char encoding(char origin){
        if(Character.isDigit(origin)){
            char result = origin;
            if(origin!='9'){
                result++;
            }
            else {
                result = '0';
            }
            return (char)result;
        }
        else if(Character.isAlphabetic(origin)){
            char result =(char)(origin +1);
            if(origin == 'z'){
                result = 'a';
            } else if (origin == 'Z'){
                result = 'A';
            }
            return result;
        }
        return origin;
    }
}
