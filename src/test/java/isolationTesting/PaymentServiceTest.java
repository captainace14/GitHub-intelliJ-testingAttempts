package isolationTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.yeditepe.unitTesting.PaymentGateway;
import org.yeditepe.unitTesting.PaymentService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    //invoking the mock object
    @Mock
    PaymentGateway paymentGateway;

    @Test
    void testSuccessfulPayment() {
        //Implementing our mock object inside of our real object
        PaymentService paymentService = new PaymentService(paymentGateway);

        //when(paymentGateway.)


    }
}
