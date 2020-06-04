package com.andrecordeiro;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("integrationTest")
public abstract class AbstractIntegrationTest {}
