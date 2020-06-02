package com.company.bl;

import com.company.dao.FileHandler;
import com.company.entity.Employee;

import java.util.*;

public class EmployeeBao {

    private Map<Integer, String> lookup;
    private Map<String, List<String>> relationships;
    private List<Employee> employees;
    private Employee ceo;

    public EmployeeBao(String filename) throws Exception {
        this.employees = FileHandler.readEmployees(filename);
        this.lookup = this.createLookup();
        this.relationships = this.createRelationships();
    }

    private Map<String, List<String>> createRelationships() throws Exception {
        Map<String, List<String>> relationships = new HashMap<String, List<String>>();
        for (Employee employee: this.employees) {
            if (employee.getMid() != -1) {
                String manager = this.lookup.get(employee.getMid());
                if (manager == null)
                    throw new Exception("Unable to find employee with id "+ employee.getMid());
                if (relationships.containsKey(manager)) {
                    List<String> values = relationships.get(manager);
                    values.add(employee.getName());
                    relationships.put(manager, values);
                } else {
                    relationships.put(manager, new ArrayList<String>(Arrays.asList(employee.getName())));
                }

            } else {
                this.ceo = employee;
            }
        }
        return relationships;
    }

    private Map<Integer, String> createLookup() {
        Map<Integer, String> lookup = new HashMap<Integer, String>();
        for (Employee employee: this.employees) {
            lookup.put(employee.getId(), employee.getName());
        }
        return lookup;
    }

    public Map<String, List<String>> getRelationships() {
        return relationships;
    }

    public Employee getCeo() {
        return ceo;
    }

    public void prettyPrint() {
        if (this.ceo != null)
            this.prettyPrint(this.ceo.getName(), "--");
    }

    private void prettyPrint(String manager, String prefix) {
//        print("{}>{}".format(prefix, manager))
//        if manager in relationships:
//        for employee in relationships[manager]:
//        self._pretty_print(employee, relationships, prefix+"--")

        System.out.println(prefix + ">" + manager);
        if (this.relationships.containsKey(manager)) {
            for (String employee : relationships.get(manager)) {
                this.prettyPrint(employee, prefix + "--");
            }
        }
    }
}
