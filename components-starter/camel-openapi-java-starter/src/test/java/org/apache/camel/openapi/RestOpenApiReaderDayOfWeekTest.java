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
package org.apache.camel.openapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.camel.BindToRegistry;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.engine.DefaultClassResolver;
import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.model.rest.RestParamType;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.openapi.models.OasDocument;

@DirtiesContext
@CamelSpringBootTest
@SpringBootTest(
		classes = {
				CamelAutoConfiguration.class,
				RestOpenApiReaderDayOfWeekTest.class,
				RestOpenApiReaderDayOfWeekTest.TestConfiguration.class,
				DummyRestConsumerFactory.class
		}
)
public class RestOpenApiReaderDayOfWeekTest {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@BindToRegistry("dummy-rest")
	private final DummyRestConsumerFactory factory = new DummyRestConsumerFactory();

	@Autowired
	CamelContext context;

	@Configuration
	public class TestConfiguration {

		@Bean
		public RouteBuilder routeBuilder() {
			return new RouteBuilder() {

				@Override
				public void configure() throws Exception {
					// this user REST service is json only
					rest("/day").tag("dude").description("Day service").consumes("application/json").produces("application/json")

							.get("/week").description("Day of week").param().name("day").type(RestParamType.query)
							.description("Day of week").defaultValue("friday").dataType("string")
							.allowableValues("monday", "tuesday", "wednesday", "thursday", "friday").endParam().responseMessage()
							.code(200).responseModel(DayResponse.class)
							.header("X-Rate-Limit-Limit").description("The number of allowed requests in the current period")
							.dataType("integer").endHeader().endResponseMessage()
							.to("log:week");
				}
			};
		}
	}

	@Test
	public void testReaderRead() throws Exception {
		BeanConfig config = new BeanConfig();
		config.setHost("localhost:8080");
		config.setSchemes(new String[] {"http"});
		config.setBasePath("/api");
		config.setTitle("Day");
		config.setLicense("Apache 2.0");
		config.setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html");
		config.setVersion("2.0");
		RestOpenApiReader reader = new RestOpenApiReader();

		OasDocument openApi = reader.read(context, ((ModelCamelContext) context).getRestDefinitions(), config, context.getName(),
				new DefaultClassResolver());
		assertNotNull(openApi);

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		Object dump = Library.writeNode(openApi);
		String json = mapper.writeValueAsString(dump);

		log.info(json);

		assertTrue(json.contains("\"host\" : \"localhost:8080\""));
		assertTrue(json.contains("\"default\" : \"friday\""));
		assertTrue(json.contains("\"enum\" : [ \"monday\", \"tuesday\", \"wednesday\", \"thursday\", \"friday\" ]"));
		assertTrue(json.contains("\"$ref\" : \"#/definitions/DayResponse\""));
		assertTrue(json.contains("\"format\" : \"org.apache.camel.openapi.DayResponse\""));
		assertTrue(json.contains("\"X-Rate-Limit-Limit\" : {"));
		assertTrue(json.contains("\"description\" : \"The number of allowed requests in the current period\""));

		context.stop();
	}

	@Test
	public void testReaderReadV3() throws Exception {
		BeanConfig config = new BeanConfig();
		config.setHost("localhost:8080");
		config.setSchemes(new String[] {"http"});
		config.setBasePath("/api");
		config.setTitle("Day");
		config.setLicense("Apache 2.0");
		config.setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html");
		//config.setVersion("2.0");
		RestOpenApiReader reader = new RestOpenApiReader();

		OasDocument openApi = reader.read(context, ((ModelCamelContext) context).getRestDefinitions(), config, context.getName(),
				new DefaultClassResolver());
		assertNotNull(openApi);

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		Object dump = Library.writeNode(openApi);
		String json = mapper.writeValueAsString(dump);

		log.info(json);

		assertTrue(json.contains("\"url\" : \"http://localhost:8080/api\""));
		assertTrue(json.contains("\"default\" : \"friday\""));
		assertTrue(json.contains("\"enum\" : [ \"monday\", \"tuesday\", \"wednesday\", \"thursday\", \"friday\" ]"));
		assertTrue(json.contains("\"$ref\" : \"#/components/schemas/DayResponse\""));
		assertTrue(json.contains("\"format\" : \"org.apache.camel.openapi.DayResponse\""));
		assertTrue(json.contains("\"X-Rate-Limit-Limit\" : {"));
		assertTrue(json.contains("\"description\" : \"The number of allowed requests in the current period\""));

		context.stop();
	}
}
