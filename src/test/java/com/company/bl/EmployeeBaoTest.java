package com.company.bl;

import org.junit.Test;

public class EmployeeBaoTest {

    @Test
    public void ceoCheck1() throws Exception {

        EmployeeBao employeeBao1 = new EmployeeBao("input1.txt");
        employeeBao1.prettyPrint();
        assert employeeBao1.getCeo().getName().equals("Jamie");
    }

    @Test
    public void ceoCheck2() throws Exception {

        try {
            EmployeeBao employeeBao2 = new EmployeeBao("input2.txt");
            employeeBao2.prettyPrint();
            assert employeeBao2.getCeo().getName().equals("Jamie");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void ceoCheck3() throws Exception {

        EmployeeBao employeeBao3 = new EmployeeBao("input3.txt");
        employeeBao3.prettyPrint();
        assert employeeBao3.getCeo().getName().equals("Alan");
    }

    @Test
    public void ceoCheck4() throws Exception {

        EmployeeBao employeeBao4 = new EmployeeBao("input4.txt");
        employeeBao4.prettyPrint();
        assert employeeBao4.getCeo() == null;
    }
}
