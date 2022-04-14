package com.techzealot.examples.features;

import com.techzealot.examples.features.records.Person;
import org.junit.jupiter.api.Test;

public class RecordTest {

    @Test
    public void testRecord(){
        Person person=new Person("tom",22);
        System.out.println(person.name());
        System.out.println(person.age());
        person.print();
        System.out.println(Person.onlyStaticFieldAllow);
    }
}
