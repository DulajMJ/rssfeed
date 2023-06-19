package com.assignment.rssfeed;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Base class for test that needs to run with a Spring Context.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("integration-test")
public class SpringContextTest {

}
