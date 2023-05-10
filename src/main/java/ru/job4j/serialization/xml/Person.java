package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private boolean gender;
    private Contact contact;

    @XmlElementWrapper(name = "kids")
    @XmlElement(name = "kid")
    private String[] statuses;
    private String[] kids;

    public Person() {
    }

    public Person(String name, int age, boolean gender, Contact contact, String[] kids) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.kids = kids;
    }

    public static void main(String[] args) throws JAXBException {
        final Person person = new Person("Kate", 30, true,
                new Contact("11-111"), new String[] {"Tom", "Jane"});
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
        }
    }
}
