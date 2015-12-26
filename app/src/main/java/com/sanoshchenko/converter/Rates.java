package com.sanoshchenko.converter;

public enum Rates {
    UAH(1),
    USD(0.042),
    EUR(0.039),
    GBP(0.03),
    RUB(3.00);

    final double rate;

    Rates(double rate) {
        this.rate = rate;
    }
}
