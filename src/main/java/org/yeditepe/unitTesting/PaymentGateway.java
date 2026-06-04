package org.yeditepe.unitTesting;

public interface PaymentGateway {
    boolean charge(String userId, double amount);
}
