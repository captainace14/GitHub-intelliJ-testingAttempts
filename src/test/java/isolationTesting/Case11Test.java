package isolationTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.Mock;

interface PaymentGateway { boolean charge(String userId, double amount); }

class PaymentService {
    private final PaymentGateway gateway;
    public PaymentService(PaymentGateway g) { this.gateway = g;}
    public boolean processPayment(String id, double amt) { return gateway.charge(id, amt);}

}


@ExtendWith(Extension.class)
public class Case11Test {

    @Mock
    private PaymentGateway mockGateway;


    @Test
    void testProcessPaymentTriggersCharge(){

    }
}
