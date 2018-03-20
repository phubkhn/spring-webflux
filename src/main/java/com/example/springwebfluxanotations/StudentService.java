package com.example.springwebfluxanotations;

import java.time.Duration;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

@Service
public class StudentService {

	public Flux<Student> all() {
        RandomStringGenerator rsg = new RandomStringGenerator.Builder()
            .withinRange('a', 'z')
            .build();
 
        return Flux.generate((SynchronousSink<Student> sink) -> sink.next(new Student(rsg.generate(10))))
            .delayElements(Duration.ofSeconds(1L));
    }
}
