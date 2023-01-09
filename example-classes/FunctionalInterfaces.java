package com.interview.bootcamp.covid.adapter.in.web.covid;

import com.interview.bootcamp.covid.adapter.out.client.CovidRestClient;
import com.interview.bootcamp.covid.domain.DailyReport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

@RestController
@RequestMapping("/covid")
public class FunctionalInterfaces {

    @Value("${server.port}")
    private String propertyValue;

    @GetMapping
    public Boolean hello(){

        Predicate<DailyReport> is = (a) -> a.date.equals("hoy");

        Supplier<Integer> supplier = () -> 1 + 1 ;

        Consumer<DailyReport> consumer = (dr) -> System.out.println(dr.toString().concat(" <- Consumer"));

        Integer suma = supplier.get();
        System.out.println(suma);

        System.out.println(this.propertyValue);

        DailyReport dailyReport = DailyReport.builder().date("antier").build();

        consumer.accept(dailyReport);


        return  is.test(DailyReport.builder().date("ayer").build());
    }
}
