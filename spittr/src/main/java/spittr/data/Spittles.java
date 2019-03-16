package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Spittles implements SpittleRepository {
    private List<Spittle> spittles = new ArrayList<>();
    public Spittles(){
        for(int i=0;i<100;i++){
            spittles.add(new Spittle("Spittle"+i, new Date()));
        }
    }
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return spittles.subList((int)Math.min(max,spittles.size())-count,(int)Math.min(max,spittles.size()));
    }
}
