package be.abis.exercise.test;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompanyTest {

    Address a1;
    Address a2;
    Company c1;

    @BeforeEach
    void setUp(){
        a1 = mock(Address.class);
        when(a1.getCountryCode()).thenReturn("BE");
        a2 = mock(Address.class);
        when(a2.getCountryCode()).thenReturn("NL");
        c1 = new Company("Abis", a1);
    }

    @Test
    void taxForBelgianCompanyShouldBe51(){
        assertEquals(c1.calculateTaxToPay(), 51.0);
    }

}
