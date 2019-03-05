package amrutyu.jaxbinding;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import amrutyu.patient.Patient;


public class JaxMarshalling {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller createMarshaller = context.createMarshaller();
			
			Patient patient = new Patient();
			patient.setId(1);
			patient.setName("Patient 1");
			patient.setAge(30);
			
			StringWriter stringWriter = new StringWriter();
			createMarshaller.marshal(patient, stringWriter);
			System.out.println(stringWriter.toString());
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Patient patient1 = (Patient) unmarshaller.unmarshal(new StringReader(stringWriter.toString()));
			System.out.println(patient1.getName());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
