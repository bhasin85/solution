package com.company.bl;

import org.junit.Test;

public class EmployeeBaoTest {

    @Test
    public void ceoCheck() throws Exception {

        EmployeeBao employeeBao1 = new EmployeeBao("input1.txt");
        assert employeeBao1.getCeo().getName().equals("Jamie");

        try {
            EmployeeBao employeeBao2 = new EmployeeBao("input2.txt");
            assert employeeBao2.getCeo().getName().equals("Jamie");
        } catch (Exception e) {
            System.out.println(e);
        }


        EmployeeBao employeeBao3 = new EmployeeBao("input3.txt");
        assert employeeBao3.getCeo().getName().equals("Alan");

        EmployeeBao employeeBao4 = new EmployeeBao("input4.txt");
        assert employeeBao4.getCeo() == null;
    }
}
