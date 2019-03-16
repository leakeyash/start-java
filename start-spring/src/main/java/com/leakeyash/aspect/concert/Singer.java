package com.leakeyash.aspect.concert;

import org.springframework.stereotype.Component;

/**
 * @author henry
 */
@Component
public class Singer implements Performance {
    @Override
    public void perform() {
        System.out.println("Singer is singing.");
    }
}
