package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 那么最特殊的一个数字，就是零. 零这个数字，就代表Java中的时间原点，其对应的日期是1970年1月1日 8点0分0秒 。
 * (为什么是8点，因为中国的太平洋时区是UTC-8，刚好和格林威治时间差8个小时)
 */
public class Simulator {
    public static void main(String[] args){
        // 当前时间
        Date d1 = new Date();
        System.out.println("当前时间:");
        System.out.println(d1);
        System.out.println();
        // 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
        Date d2 = new Date(5000);
        System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
        System.out.println(d2);

        getTime();
        getRandomTime();
        calendar();
    }

    static void getTime(){
        Date now= new Date();
        //打印当前时间
        System.out.println("当前时间:"+now.toString());
        //getTime() 得到一个long型的整数
        //这个整数代表 1970.1.1 08:00:00:000，每经历一毫秒，增加1
        System.out.println("当前时间getTime()返回的值是："+now.getTime());
        //通过System.currentTimeMillis()获取当前日期的毫秒数
        System.out.println("System.currentTimeMillis() \t返回值: "+System.currentTimeMillis());
        Date zero = new Date(0);
        System.out.println("用0作为构造方法，得到的日期是:"+zero);
    }

    static void getRandomTime(){
        //1995.1.1 00:00:00 到 1995.12.31 23:59:59
        String startStr = "1995.1.1 00:00:00";
        String endStr = "1995.12.31 23:59:59";
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        try {
            Date startDate = format.parse(startStr);
            Date endDate = format.parse(endStr);
            long s = startDate.getTime();
            long e = endDate.getTime();
            long rd = ThreadLocalRandom.current().nextLong(s,e);
            Date result = new Date(rd);
            System.out.println("随机时间:"+format.format(result));
        }
        catch (ParseException ex){
            ex.printStackTrace();
        }
    }

    static void calendar(){
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        Calendar cld = Calendar.getInstance();
        cld.add(Calendar.MONTH,2);
        Date d = cld.getTime();
        System.out.println("两个月后:"+format.format(d));
        //前一个月的最后一天
        cld.set(Calendar.DAY_OF_MONTH,0);
        cld.add(Calendar.DATE,-3);
        d = cld.getTime();
        System.out.println("后一个月的倒数第三天:"+format.format(d));
        cld.roll(Calendar.DAY_OF_MONTH,-1);
        d = cld.getTime();
        System.out.println("当前月最后一天:"+format.format(d));
    }
}
