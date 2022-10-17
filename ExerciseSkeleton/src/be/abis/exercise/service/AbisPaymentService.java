package be.abis.exercise.service;

import be.abis.exercise.exception.SalaryTooLowException;
import be.abis.exercise.model.Person;

public class AbisPaymentService implements PaymentService{


    @Override
    public void paySalary(Person p) throws SalaryTooLowException {
        System.out.println("Paying " + p.calculateNetSalary() + " euro to " + p.getFirstName());
    }
}
