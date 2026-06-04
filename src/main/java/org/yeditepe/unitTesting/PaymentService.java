package org.yeditepe.unitTesting;

public class PaymentService {

    private PaymentGateway gateway;
    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;

    }

    public boolean processPayment(String userId, double amount) {
        return gateway.charge(userId, amount);
    }
}
