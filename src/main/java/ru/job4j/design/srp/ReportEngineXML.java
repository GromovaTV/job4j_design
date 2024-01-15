package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

@XmlRootElement(name = "employees")
public class ReportEngineXML implements Report {

    private Store store;

    @XmlElement(name = "employee")
    private List<Employee> emps;

    public ReportEngineXML() {
    }

    public ReportEngineXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        emps = store.findBy(filter);
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(this.getClass());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Marshaller marshaller = null;
        try {
            marshaller = context.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(this, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
            return xml;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}