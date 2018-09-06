package loop;

public class BreakOuterLoop {
    public static void main(String[] args){
        outLoop: //outloop这个标示是可以自定义的比如outloop1,ol2,out5
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                System.out.println(i+":"+j);
                if(0==j%2) {
                    break outLoop; //如果是双数，结束外部循环
                }
            }

        }
    }
}
