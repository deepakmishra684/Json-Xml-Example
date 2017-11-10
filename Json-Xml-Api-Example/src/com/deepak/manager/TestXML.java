package com.deepak.manager;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.deepak.model.Employee1;

public class TestXML {
	
	public static void marshallingTest() throws JAXBException
	{
		Employee1 emp1 = new Employee1();
		emp1.setEmpId(222);
		emp1.setName("Mishra");
		emp1.setSalary(31000.00);
			
		JAXBContext context = JAXBContext.newInstance(Employee1.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// show on console genereted xml
		marshaller.marshal(emp1, System.out);
		
		// genereted xml store in to file
		File file = new File("emp.xml");
		marshaller.marshal(emp1, file);
		System.out.println("--DONE--");

	}
	
	public static void unmarshallingTest() throws JAXBException
	{
		JAXBContext context1 = JAXBContext.newInstance(Employee1.class);
		Unmarshaller unMarsh=context1.createUnmarshaller();
		Employee1 empUnMar=(Employee1)unMarsh.unmarshal(new File("emp.xml"));
		System.out.println(empUnMar.getEmpId()+" "+empUnMar.getName()+" "+empUnMar.getSalary());

		
	}
	public static void main(String[] args) throws JAXBException {
		// marshalling
		marshallingTest();
		
		//unmarshalling
		System.out.println("************************************************");
		unmarshallingTest();

	}
}
