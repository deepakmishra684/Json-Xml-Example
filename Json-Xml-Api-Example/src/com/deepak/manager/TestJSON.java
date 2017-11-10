package com.deepak.manager;

import com.deepak.model.Employee;
import com.deepak.util.JsonUtil;

public class TestJSON {
	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setEmpId(111);
		emp.setName("Deepak");
		emp.setSalary(30000.00);
		String jsonEmp = JsonUtil.convertJavaToJson(emp);
		System.out.println(jsonEmp);
		/*
		 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 */
		System.out.println("========================================================");
		Employee javaEmp = JsonUtil.convertJsonToJava(jsonEmp, Employee.class);
		System.out.println(javaEmp.getEmpId() + " " + javaEmp.getName() + " " + javaEmp.getSalary());
	}
}
