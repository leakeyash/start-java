package spittr.data;

import spittr.Spittle;

import java.util.List;

/**
 * @author henry
 */
public interface SpittleRepository {
    /**
     * @param max
     * @param count
     * @return
     */
    List<Spittle> findSpittles(long max, int count);
}
