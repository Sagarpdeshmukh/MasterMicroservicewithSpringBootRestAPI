package com.example.group.demoArtifact.controller;

import com.example.group.demoArtifact.userDao.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("val1","val2","val3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        //mappingJacksonValue  allows to set filter
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanfilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filteringvia")
    public List<SomeBean> filteringList() {
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value1", "value2", "value3")

        );
    }
}
