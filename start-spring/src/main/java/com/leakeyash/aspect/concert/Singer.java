package com.leakeyash.aspect.concert;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Singer implements Performance {
    @Override
    public void perform() {
        System.out.println("Singer is singing.");
    }
}
