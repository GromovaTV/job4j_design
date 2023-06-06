package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GeneratorTest {
    @Test
    public void whenProduce() {
        Generator gen = new TemplGen();
        String temp = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "you");
        String exp = "I am a Petr, Who are you? ";
        assertEquals(exp, gen.produce(temp, map));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMapContainsExtraKeys() {
        Generator gen = new TemplGen();
        String temp = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("age", "20");
        gen.produce(temp, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTemplateContainsExtraKeys() {
        Generator gen = new TemplGen();
        String temp = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        gen.produce(temp, map);
    }

}