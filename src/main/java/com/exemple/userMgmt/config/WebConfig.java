package com.exemple.userMgmt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.exemple.userMgmt.repository", "com.exemple.userMgmt.service"})
public class WebConfig { }
