package shopsync

import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import pl.estrix.shopsync.SpringBootWebApplication
import spock.lang.Specification

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = SpringBootWebApplication.class)
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
//@WebappConfiguration
//@WebappConfiguration
abstract class AbstractTest extends Specification{

//    protected MockMvc mvc;
//
//    WebApplicationContext webApplicationContext;

//    protected void setUp() {
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationCntext).build();
//    }

//    protected void setup() {
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationCntext).build();
//    }
}
