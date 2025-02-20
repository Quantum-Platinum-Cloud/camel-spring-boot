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
package org.apache.camel.component.cron.springboot;


import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cron.CronComponent;
import org.apache.camel.component.cron.api.CamelCronService;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.apache.camel.spring.boot.CamelContextConfiguration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        CronLoaderTest.class,
        CronLoaderTest.TestConfiguration.class
    }
)
public class CronLoaderTest {

    @Autowired
    private CamelContext context;
    
    @Autowired
    ProducerTemplate template;

    @EndpointInject("mock:result")
    MockEndpoint mock;
    
    @Bean("dummy2")
    private DummyCamelCronService getDummyCamelCronService() {
        return new DummyCamelCronService("dummy2");
    }
    
    
    
    

    @Test
    void testDummyCronServiceLoading() throws Exception {
                
        mock.expectedMinimumMessageCount(1);

        mock.assertIsSatisfied();
    }
    
    @Test
    void testPreferRegistryOverServiceLoading() throws Exception {
        assertEquals("dummy2", getCamelCronService().getId());
    }
    
    
    
    private CamelCronService getCamelCronService() {
        return context.getComponent("cron", CronComponent.class).getService();
    }
    

    // *************************************
    // Config
    // *************************************

    @Configuration
    public static class TestConfiguration {

        @Bean
        public RouteBuilder routeBuilder() {
            return new RouteBuilder() {
                @Override
                public void configure() {
                    from("cron:tab?schedule=0/1 * * * * ?")
                            .setBody().constant("x")
                            .to("mock:result");
                }
            };
        }
    }
}
