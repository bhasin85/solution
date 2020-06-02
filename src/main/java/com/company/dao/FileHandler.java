package com.company.dao;

import com.company.entity.Employee;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    public static List<Employee> readEmployees(String filename) {
        List<Employee> employees = new ArrayList<Employee>();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(filename);

        Scanner scanner = new Scanner(is);
        boolean header = true;

        while(scanner.hasNext()){
            String[] row = scanner.nextLine().split(",");
            //System.out.println(Arrays.toString(row));

            if (header) {
                // Skipping for header line
                header = false;
            } else {
                String name = row[0];
                Integer id = Integer.parseInt(row[1].replaceAll("\\s",""));
                Integer mid = Integer.parseInt(row[2].replaceAll("\\s",""));
                employees.add(new Employee(name, id, mid));
            }
        }
        scanner.close();
        return employees;
    }

}
