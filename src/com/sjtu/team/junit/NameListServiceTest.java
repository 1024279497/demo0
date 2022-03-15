package com.sjtu.team.junit;

import com.sjtu.team.domain.Employee;
import com.sjtu.team.service.NameListService;
import com.sjtu.team.service.TeamException;

public class NameListServiceTest {
    public static void main(String[] args) throws TeamException {
        NameListService nls = new NameListService();
        Employee[] list = nls.getAllEmployees();
        for(int i =0;i<list.length;i++){
            System.out.println(list[i]);
        }
        int id = 10;
        try{
            Employee em = nls.getEmployee(id);
            System.out.println(em);
        } catch (TeamException e) {
            System.out.println(e.getMessage());;
        }
    }



}
