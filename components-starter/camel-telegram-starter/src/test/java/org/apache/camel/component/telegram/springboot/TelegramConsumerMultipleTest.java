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
package org.apache.camel.component.telegram.springboot;


import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.component.telegram.model.UpdateResult;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.junit.jupiter.api.Test;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;


@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@CamelSpringBootTest
@SpringBootTest(
    classes = {
        CamelAutoConfiguration.class,
        TelegramConsumerMultipleTest.class,
        TelegramConsumerMultipleTest.TestConfiguration.class
    }
)
public class TelegramConsumerMultipleTest extends TelegramTestSupport {

    
    static TelegramMockRoutes mockRoutes;
    
    @EndpointInject("mock:telegram")
    private MockEndpoint endpoint;

    @Test
    public void testReceptionOfThreeMessagesFromTwoUpdates() throws Exception {
        endpoint.expectedMinimumMessageCount(3);
        endpoint.expectedBodiesReceived("message1", "message2", "message3");

        endpoint.assertIsSatisfied(5000);
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
                    from("telegram:bots?authorizationToken=mock-token")
                            .convertBodyTo(String.class)
                            .to("mock:telegram");
                }
            };
        }

    }
    
    @Override
    @Bean
    protected TelegramMockRoutes createMockRoutes() {
        UpdateResult res1 = getJSONResource("messages/updates-single.json", UpdateResult.class);
        res1.getUpdates().get(0).getMessage().setText("message1");

        UpdateResult res2 = getJSONResource("messages/updates-multiple.json", UpdateResult.class);
        res2.getUpdates().get(0).getMessage().setText("message2");
        res2.getUpdates().get(1).getMessage().setText("message3");

        UpdateResult defaultRes = getJSONResource("messages/updates-empty.json", UpdateResult.class);

        mockRoutes = new TelegramMockRoutes(port)
                .addEndpoint(
                        "getUpdates",
                        "GET",
                        String.class,
                        TelegramTestUtil.serialize(res1),
                        TelegramTestUtil.serialize(res2),
                        TelegramTestUtil.serialize(defaultRes));
        return mockRoutes;
    }
}
