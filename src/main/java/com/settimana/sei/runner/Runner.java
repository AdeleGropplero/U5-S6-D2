package com.settimana.sei.runner;

import com.settimana.sei.Service.AutoreService;
import com.settimana.sei.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private PostService postService;
    @Autowired
    private AutoreService autoreService;


    @Override
    public void run(String... args) throws Exception {

    }
}
