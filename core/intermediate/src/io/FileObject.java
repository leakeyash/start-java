package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author henry
 */
public class FileObject {
    public static void main(String[] args) throws IOException {
        String file = "F:\\test\\henry\\hawk\\a.txt";
        String dir = new File(file).getParent();
        createNewFile(file);
        createFiles(dir);
        createFiles(Paths.get(dir,"sub").toString());
        List<File> files = getAllFiles(dir);
        printMaxMinFileNames(files);
        testSplitMergeFile();
    }

    private static void printMaxMinFileNames(List<File> files) {
        String maxName = null;
        String minName = null;

        long min =Long.MAX_VALUE;
        long max =0;
        for(File item: files){
            if(item.length()>max){
                max = item.length();
                maxName = item.getName();
            }
            if(item.length()<min){
                min = item.length();
                minName = item.getName();
            }
        }
        System.out.println("Max name: "  + maxName +", max:"+max);
        System.out.println("Min name: "  + minName +", min:"+min);
    }

    private static List<File> getAllFiles(String dir) {
        List<File> files = new ArrayList<>();
        Stack<File> stack = new Stack<>();
        stack.push(Paths.get(dir).toFile());
        while(!stack.isEmpty()) {
            File child = stack.pop();
            if (child.isDirectory()) {
                for(File f : Objects.requireNonNull(child.listFiles())) {
                    stack.push(f);
                }
            } else if (child.isFile()) {
                files.add(child);
            }
        }
        return files;
    }

    private static boolean createNewFile(String file) throws IOException {
        File f = new File(file);
        if(f.getParentFile().mkdirs()){
            return f.createNewFile();
        }
        return false;
    }

    private static void createFiles(String dir){
        String str = "This is an example!\n";
        int n = 10;
        while(n>0){
            String fileName = "test"+n +".txt";
            String content = String.join("", Collections.nCopies(n,str));
            File f = Paths.get(dir,fileName).toFile();
            Paths.get(dir).toFile().mkdirs();
            try(FileOutputStream fop = new FileOutputStream(f)){
                if(!f.exists()){
                    f.createNewFile();
                }
                byte[] contentInBytes = content.getBytes();

                fop.write(contentInBytes);
            } catch (IOException ex){
                ex.printStackTrace();
            }
            n--;
        }
    }
    private static boolean createFile(String filePath, byte[] data){
        File file = Paths.get(filePath).toFile();
        if(file.getParentFile().exists() || file.getParentFile().mkdirs()){
            try(FileOutputStream fos = new FileOutputStream(file)){
                fos.write(data);
            } catch (IOException e){
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private static void testSplitMergeFile(){
        String filePath = "F:\\test\\henry\\file\\log.txt";
        byte[] bytes = new byte[2135*1024];
        for(int i=0;i<bytes.length;i++){
            bytes[i] = (byte)new Random().nextInt(10);
        }
        createFile(filePath,bytes);
        splitFile(filePath);
        mergeFile(Paths.get(filePath).getParent().toString(),"log.txt");
    }

    private static void splitFile(String filePath){
        int count =0;
        int interval = 100 * 1024;
        int len;
        try(FileInputStream fis = new FileInputStream(filePath)){
            byte[] bytes = new byte[interval];
            while((len=fis.read(bytes))!=-1){
                createFile(filePath+"-"+count, Arrays.copyOfRange(bytes,0,len-1));
                count++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void mergeFile(String dir, String name){
        List<File> files = Arrays.stream(Paths.get(dir).toFile().listFiles())
                .filter(x->x.getName().startsWith(name)&&!x.getName().equals(name))
                .sorted().collect(Collectors.toList());
        try(FileOutputStream fos = new FileOutputStream(Paths.get(dir,name+"-new").toFile(),true)) {
            for (File f : files) {
                fos.write(Files.readAllBytes(f.toPath()));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
