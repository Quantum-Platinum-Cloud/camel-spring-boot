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
package org.apache.camel.spring.boot.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;

@CamelSpringBootTest
@DirtiesContext
@SpringBootApplication
@SpringBootTest(
    classes = {
        GroupCondition2Test.TestConfiguration.class
    },
    properties = {
        "test.group.enabled=false",
        "test.group.my-class.enabled=false"
    }
)
public class GroupCondition2Test extends GroupConditionTestBase {
    @Autowired
    ApplicationContext context;

    @Test
    public void testCondition() {
        Assertions.assertEquals(0, context.getBeansOfType(MyClass.class).size());
    }
}
