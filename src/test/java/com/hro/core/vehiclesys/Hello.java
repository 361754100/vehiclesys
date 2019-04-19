package com.hro.core.vehiclesys;

public class Hello implements IHello {
    @Override
    public void sayHello(String words) {
        System.out.println("words --->"+ words);
    }
}
