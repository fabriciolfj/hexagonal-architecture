package com.github.fabriciolfj.financial.account.application;


import com.github.fabriciolfj.financial.account.domain.Money;

public class ThresholdExceededException extends RuntimeException {

  public ThresholdExceededException(final Money threshold, final Money actual) {
    super(String.format("Maximum threshold for transferring money exceeded: tried to transfer %s but threshold is %s!", actual, threshold));
  }

}
