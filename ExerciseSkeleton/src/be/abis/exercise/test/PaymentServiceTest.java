package be.abis.exercise.test;

import be.abis.exercise.exception.SalaryTooLowException;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.AbisPaymentService;
import be.abis.exercise.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class PaymentServiceTest {

    PaymentService ps;

    @Mock
    private Person p;

    @BeforeEach
    void setUp(){
        ps = new AbisPaymentService();
    }

    @Test
    void personThrowsSalaryTooLowException() throws SalaryTooLowException {
        when(p.calculateNetSalary()).thenThrow(SalaryTooLowException.class);
        assertThrows(SalaryTooLowException.class, () -> ps.paySalary(p));
    }

}
