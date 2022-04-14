package com.techzealot.examples.features;

import com.techzealot.examples.features.sealeds.BlackCat;
import com.techzealot.examples.features.sealeds.Cat;
import com.techzealot.examples.features.sealeds.Dog;
import com.techzealot.examples.features.sealeds.Pet;
import org.junit.jupiter.api.Test;

public class SealedTest {

    @Test
    public void testSealed() {
        Pet dog=new Dog();
        Pet cat=new Cat();
        Pet blackCat = new BlackCat();
        System.out.println(cat.type());
        System.out.println(dog.type());
        System.out.println(blackCat.type());
    }
}
