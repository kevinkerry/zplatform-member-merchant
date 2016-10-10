/* 
 * Money.java  
 * 
 * version 1.0
 *
 * 2015年8月25日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.merchant.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Money class,it currency is "CNY",the default fraction digits is 0,means its
 * default unit is "fen".
 *
 * @author yangying
 * @version
 * @date 2015年8月25日 下午12:15:05
 * @since
 */

public class Money implements Comparable<Money>, Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6056245945644338941L;

    private static final int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_HALF_EVEN;
    private static final Currency CNY = Currency.getInstance("CNY");
    private static final int FRACTION_DIGITS = 0;
    private static final BigDecimal HUNDRED = new BigDecimal(100);
    public static final Money ZERO = valueOf(0.00);

    private Currency currency = CNY;
    private BigDecimal amount;

    private Money() {
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Currency getCurrency() {
        return currency;
    }

    private Money(BigDecimal amount) {
        this(amount, CNY);
    }

    private Money(BigDecimal amount, Currency currency) {
        if (amount.scale() != FRACTION_DIGITS) {
            throw new IllegalArgumentException(
                    "Scale of amount does not match 0");
        }
        this.currency = currency;
        this.amount = amount;
    }
    /**
     * Returns the Money representation of the BigDecimal argument,and round off
     * by default rounding mode:ROUND_HALF_EVEN
     * 
     * @param amount
     * @return
     */
    public static Money valueOf(BigDecimal amount) {
        return valueOf(amount, DEFAULT_ROUNDING_MODE);
    }

    /**
     * Returns the Money representation of the BigDecimal argument,and round off
     * by roundingMode
     * 
     * @param amount
     * @param roundingMode
     * @return
     */
    public static Money valueOf(BigDecimal amount, int roundingMode) {
        BigDecimal _amount = amount.setScale(FRACTION_DIGITS, roundingMode);
        return new Money(_amount);
    }
    /**
     * Returns the Money representation of the double argument,and round off by
     * default rounding mode:ROUND_HALF_EVEN
     * 
     * @param amount
     * @return
     */
    public static Money valueOf(double amount) {
        BigDecimal _amount = new BigDecimal(amount);
        return valueOf(_amount);
    }
    /**
     * Returns the Money representation of the double argument,and round off by
     * roundingMode
     * 
     * @param amount
     * @param roundingMode
     * @return
     */
    public static Money valueOf(double amount, int roundingMode) {
        BigDecimal _amount = new BigDecimal(amount);
        return valueOf(_amount, roundingMode);
    }
    /**
     * Returns the Money representation of the BigDecimal argument,and round off
     * by default rounding mode:ROUND_HALF_EVEN.The unit of the argument is
     * "yuan".
     * 
     * @param amount
     * @param roundingMode
     * @return
     */
    public static Money yuanValueOf(BigDecimal amount) {
        return yuanValueOf(amount, DEFAULT_ROUNDING_MODE);
    }
    /**
     * Returns the Money representation of the BigDecimal argument,and round off
     * by roundingMode.The unit of the argument is "yuan".
     * 
     * @param amount
     * @param roundingMode
     * @return
     */
    public static Money yuanValueOf(BigDecimal amount, int roundingMode) {
        BigDecimal _amount = amount.multiply(HUNDRED);
        return valueOf(_amount, roundingMode);
    }
    /**
     * Returns the Money representation of the double argument,and round off by
     * default rounding mode:ROUND_HALF_EVEN.The unit of the argument is "yuan".
     * 
     * @param amount
     * @return
     */
    public static Money yuanValueOf(double amount) {
        return yuanValueOf(amount, DEFAULT_ROUNDING_MODE);
    }
    /**
     * Returns the Money representation of the double argument,and round off by
     * roundingMode.The unit of the argument is "yuan".
     * 
     * @param amount
     * @param roundingMode
     * @return
     */
    public static Money yuanValueOf(double amount, int roundingMode) {
        BigDecimal _amount = new BigDecimal(amount);
        return yuanValueOf(_amount, roundingMode);
    }
    /**
     * 
     * @param money
     * @return
     */
    public Money plus(Money money) {
        assertHasSameCurrencyAs(money);
        return Money.valueOf(amount.add(money.amount));
    }
    /**
     * 
     * @param money
     * @return
     */
    public Money minus(Money money) {
        assertHasSameCurrencyAs(money);
        return Money.valueOf(amount.subtract(money.amount));
    }
    /**
     * 
     * @param money
     * @return
     */
    public Money multiply(Money money) {
        assertHasSameCurrencyAs(money);
        return Money.valueOf(amount.multiply(money.amount));
    }
    /**
     * 
     * @param money
     * @return
     */
    public Money divis(Money money) {
        return divis(money, DEFAULT_ROUNDING_MODE);
    }
    /**
     * 
     * @param money
     * @param roundingMode
     * @return
     */
    public Money divis(Money money, int roundingMode) {
        assertHasSameCurrencyAs(money);
        return Money.valueOf(amount.divide(money.amount, roundingMode));
    }

    /**
     * return the double value represent amount with unit of "yuan"
     * 
     * @return
     */
    public String  toYuan() { 
        BigDecimal rtnAmount = amount.divide(HUNDRED);
        rtnAmount = rtnAmount.setScale(2);
        return rtnAmount.toPlainString();
    }

    private void assertHasSameCurrencyAs(Money aMoney) {
        if (!hasSameCurrencyAs(aMoney)) {
            throw new IllegalArgumentException(aMoney.toString()
                    + " is not same currency as " + this.toString());
        }
    }

    private boolean hasSameCurrencyAs(Money other) {
        if (currency.equals(other.currency)
                && (other.amount.scale() == FRACTION_DIGITS)) {
            return true;
        }
        return false;
    }

    public boolean equalsZero() {
        return this.equals(Money.valueOf(BigDecimal.ZERO));
    }

    @Override
    public int compareTo(Money other) {
        if (!other.currency.equals(currency)) {
            throw new IllegalArgumentException(
                    "Compare is not defined between different currencies");
        }
        return amount.compareTo(other.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money)) {
            return false;
        }

        Money object = (Money) o;
        return object.currency.equals(currency) && amount.equals(object.amount);
    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }

    @Override
    public String toString() {
        return amount.toString();
    }
    /**
     * . 判断是否是正数（比0大的数叫正数）
     * 
     * @return
     */
    public boolean equalsPositiveNumber() {
        return amount.compareTo(BigDecimal.ZERO) > 0 ? true : false;
    }
    /**
     * . 返回相反的方向，比如是1就返回-1
     * 
     * @return
     */
    public Money negate() {
        return Money.valueOf(amount.negate());
    }

      public static void main(String args[]){
          Money money =Money.valueOf(100);
                  System.out.println(money.toYuan());
                  
                  BigDecimal a = new BigDecimal(10); 
                  a=a.setScale(3);
                  BigDecimal b =new BigDecimal(3); 
                 b= b.setScale(1);
                  BigDecimal c = a.divide(b);
                  System.out.println(c.toString());
                  
      }
}
