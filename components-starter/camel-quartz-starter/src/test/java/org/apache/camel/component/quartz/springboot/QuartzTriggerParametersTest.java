/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.quartz.springboot;



import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.component.quartz.QuartzEndpoint;
import org.apache.camel.spring.boot.CamelAutoConfiguration;

import org.junit.jupiter.api.Test;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;


@DirtiesContext
@CamelSpringBootTest
@SpringBootTest(
    classes = {
        CamelAutoConfiguration.class,
        QuartzTriggerParametersTest.class,
        QuartzTriggerParametersTest.TestConfiguration.class
    }
)
public class QuartzTriggerParametersTest extends BaseQuartzTest {

    
    @Autowired
    ProducerTemplate template;
    
    @Autowired
    CamelContext context;
    
    @EndpointInject("mock:result")
    MockEndpoint resultEndpoint;
    
    @Test
    public void testTriggerParameters() throws Exception {
        resultEndpoint.expectedBodiesReceived("Europe/Berlin");

        resultEndpoint.assertIsSatisfied();
    }

    
    // *************************************
    // Config
    // *************************************

    @Configuration
    public class TestConfiguration {

        @Bean
        public RouteBuilder routeBuilder() {
            return new RouteBuilder() {
                @Override
                public void configure() {
                    String cron = String.format("quartz://job?cron=0+%s+%s+?+*+*&trigger.timeZone=%s&trigger.misfireInstruction=2",
                            59, 23, "Europe/Berlin");

                    from(cron).to("mock:cron");

                    from("timer://foo?repeatCount=1")
                            .process(exchange -> {
                                QuartzEndpoint endPoint = getContext().getEndpoint(cron, QuartzEndpoint.class);
                                Map<String, Object> triggers = endPoint.getTriggerParameters();
                                exchange.getIn().setBody(triggers.get("timeZone"));
                            })
                            .to("mock:result");
                }
            };
        }
    }
    
   

}
