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
package org.apache.camel.component.rabbitmq.springboot;

import java.util.Map;
import javax.annotation.Generated;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Send and receive messages from RabbitMQ instances.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.springboot.maven.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.component.rabbitmq")
public class RabbitMQComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the rabbitmq component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * If this option is set, camel-rabbitmq will try to create connection based
     * on the setting of option addresses. The addresses value is a string which
     * looks like server1:12345, server2:12345
     */
    private String addresses;
    /**
     * If it is true, the exchange will be deleted when it is no longer in use
     */
    private Boolean autoDelete = true;
    /**
     * To use a custom RabbitMQ connection factory. When this option is set, all
     * connection options (connectionTimeout, requestedChannelMax...) set on URI
     * are not used. The option is a com.rabbitmq.client.ConnectionFactory type.
     */
    private String connectionFactory;
    /**
     * The name of the dead letter exchange
     */
    private String deadLetterExchange;
    /**
     * The type of the dead letter exchange
     */
    private String deadLetterExchangeType = "direct";
    /**
     * The name of the dead letter queue
     */
    private String deadLetterQueue;
    /**
     * The routing key for the dead letter exchange
     */
    private String deadLetterRoutingKey;
    /**
     * If the option is true, camel declare the exchange and queue name and bind
     * them together. If the option is false, camel won't declare the exchange
     * and queue name on the server.
     */
    private Boolean declare = true;
    /**
     * If we are declaring a durable exchange (the exchange will survive a
     * server restart)
     */
    private Boolean durable = true;
    /**
     * Exclusive queues may only be accessed by the current connection, and are
     * deleted when that connection closes.
     */
    private Boolean exclusive = false;
    /**
     * The hostname of the running RabbitMQ instance or cluster.
     */
    private String hostname;
    /**
     * Passive queues depend on the queue already to be available at RabbitMQ.
     */
    private Boolean passive = false;
    /**
     * Port number for the host with the running rabbitmq instance or cluster.
     */
    private Integer portNumber = 5672;
    /**
     * This can be used if we need to declare the queue but not the exchange
     */
    private Boolean skipExchangeDeclare = false;
    /**
     * If true the queue will not be bound to the exchange after declaring it
     */
    private Boolean skipQueueBind = false;
    /**
     * If true the producer will not declare and bind a queue. This can be used
     * for directing messages via an existing routing key.
     */
    private Boolean skipQueueDeclare = false;
    /**
     * The vhost for the channel
     */
    private String vhost = "/";
    /**
     * If messages should be auto acknowledged
     */
    private Boolean autoAck = true;
    /**
     * Allows for bridging the consumer to the Camel routing Error Handler,
     * which mean any exceptions occurred while the consumer is trying to pickup
     * incoming messages, or the likes, will now be processed as a message and
     * handled by the routing Error Handler. By default the consumer will use
     * the org.apache.camel.spi.ExceptionHandler to deal with exceptions, that
     * will be logged at WARN or ERROR level and ignored.
     */
    private Boolean bridgeErrorHandler = false;
    /**
     * Request exclusive access to the queue (meaning only this consumer can
     * access the queue). This is useful when you want a long-lived shared queue
     * to be temporarily accessible by just one consumer.
     */
    private Boolean exclusiveConsumer = false;
    /**
     * The maximum number of messages that the server will deliver, 0 if
     * unlimited. You need to specify the option of prefetchSize, prefetchCount,
     * prefetchGlobal at the same time
     */
    private Integer prefetchCount;
    /**
     * Enables the quality of service on the RabbitMQConsumer side. You need to
     * specify the option of prefetchSize, prefetchCount, prefetchGlobal at the
     * same time
     */
    private Boolean prefetchEnabled = false;
    /**
     * If the settings should be applied to the entire channel rather than each
     * consumer You need to specify the option of prefetchSize, prefetchCount,
     * prefetchGlobal at the same time
     */
    private Boolean prefetchGlobal = false;
    /**
     * The maximum amount of content (measured in octets) that the server will
     * deliver, 0 if unlimited. You need to specify the option of prefetchSize,
     * prefetchCount, prefetchGlobal at the same time
     */
    private Integer prefetchSize;
    /**
     * The consumer uses a Thread Pool Executor with a fixed number of threads.
     * This setting allows you to set that number of threads.
     */
    private Integer threadPoolSize = 10;
    /**
     * Allow pass null values to header
     */
    private Boolean allowNullHeaders = false;
    /**
     * Get maximum number of opened channel in pool
     */
    private Integer channelPoolMaxSize = 10;
    /**
     * Set the maximum number of milliseconds to wait for a channel from the
     * pool
     */
    private Long channelPoolMaxWait = 1000L;
    /**
     * When true, an exception will be thrown when the message cannot be
     * delivered (basic.return) and the message is marked as mandatory.
     * PublisherAcknowledgement will also be activated in this case. See also
     * publisher acknowledgements - When will messages be confirmed.
     */
    private Boolean guaranteedDeliveries = false;
    /**
     * This flag tells the server how to react if the message cannot be routed
     * to a queue consumer immediately. If this flag is set, the server will
     * return an undeliverable message with a Return method. If this flag is
     * zero, the server will queue the message, but with no guarantee that it
     * will ever be consumed. If the header is present rabbitmq.IMMEDIATE it
     * will override this option.
     */
    private Boolean immediate = false;
    /**
     * Whether the producer should be started lazy (on the first message). By
     * starting lazy you can use this to allow CamelContext and routes to
     * startup in situations where a producer may otherwise fail during starting
     * and cause the route to fail being started. By deferring this startup to
     * be lazy then the startup failure can be handled during routing messages
     * via Camel's routing error handlers. Beware that when the first message is
     * processed then creating and starting the producer may take a little time
     * and prolong the total processing time of the processing.
     */
    private Boolean lazyStartProducer = false;
    /**
     * This flag tells the server how to react if the message cannot be routed
     * to a queue. If this flag is set, the server will return an unroutable
     * message with a Return method. If this flag is zero, the server silently
     * drops the message. If the header is present rabbitmq.MANDATORY it will
     * override this option.
     */
    private Boolean mandatory = false;
    /**
     * When true, the message will be published with publisher acknowledgements
     * turned on
     */
    private Boolean publisherAcknowledgements = false;
    /**
     * The amount of time in milliseconds to wait for a basic.ack response from
     * RabbitMQ server
     */
    private Long publisherAcknowledgementsTimeout;
    /**
     * Specify arguments for configuring the different RabbitMQ concepts, a
     * different prefix is required for each: Exchange: arg.exchange. Queue:
     * arg.queue. Binding: arg.binding. For example to declare a queue with
     * message ttl argument:
     * http://localhost:5672/exchange/queueargs=arg.queue.x-message-ttl=60000
     */
    private Map<String, Object> args;
    /**
     * Whether to auto-detect looking up RabbitMQ connection factory from the
     * registry. When enabled and a single instance of the connection factory is
     * found then it will be used. An explicit connection factory can be
     * configured on the component or endpoint level which takes precedence.
     */
    private Boolean autoDetectConnectionFactory = true;
    /**
     * Enables connection automatic recovery (uses connection implementation
     * that performs automatic recovery when connection shutdown is not
     * initiated by the application)
     */
    private Boolean automaticRecoveryEnabled;
    /**
     * Whether the component should use basic property binding (Camel 2.x) or
     * the newer property binding with additional capabilities
     */
    private Boolean basicPropertyBinding = false;
    /**
     * Connection client properties (client info used in negotiating with the
     * server)
     */
    private Map<String, Object> clientProperties;
    /**
     * Custom rabbitmq ExceptionHandler for ConnectionFactory. The option is a
     * com.rabbitmq.client.ExceptionHandler type.
     */
    private String connectionFactoryExceptionHandler;
    /**
     * Connection timeout
     */
    private Integer connectionTimeout = 60000;
    /**
     * Network recovery interval in milliseconds (interval used when recovering
     * from network failure)
     */
    private Integer networkRecoveryInterval = 5000;
    /**
     * Connection requested channel max (max number of channels offered)
     */
    private Integer requestedChannelMax = 2047;
    /**
     * Connection requested frame max (max size of frame offered)
     */
    private Integer requestedFrameMax = 0;
    /**
     * Connection requested heartbeat (heart-beat in seconds offered)
     */
    private Integer requestedHeartbeat = 60;
    /**
     * Set timeout for waiting for a reply when using the InOut Exchange Pattern
     * (in milliseconds)
     */
    private Long requestTimeout = 20000L;
    /**
     * Set requestTimeoutCheckerInterval for inOut exchange
     */
    private Long requestTimeoutCheckerInterval = 1000L;
    /**
     * Enables connection topology recovery (should topology recovery be
     * performed)
     */
    private Boolean topologyRecoveryEnabled;
    /**
     * When true and an inOut Exchange failed on the consumer side send the
     * caused Exception back in the response
     */
    private Boolean transferException = false;
    /**
     * Password for authenticated access
     */
    private String password = "guest";
    /**
     * Enables SSL on connection, accepted value are true, TLS and 'SSLv3
     */
    private String sslProtocol;
    /**
     * Configure SSL trust manager, SSL should be enabled for this option to be
     * effective. The option is a javax.net.ssl.TrustManager type.
     */
    private String trustManager;
    /**
     * Username in case of authenticated access
     */
    private String username = "guest";

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public Boolean getAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(Boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    public String getConnectionFactory() {
        return connectionFactory;
    }

    public void setConnectionFactory(String connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public String getDeadLetterExchange() {
        return deadLetterExchange;
    }

    public void setDeadLetterExchange(String deadLetterExchange) {
        this.deadLetterExchange = deadLetterExchange;
    }

    public String getDeadLetterExchangeType() {
        return deadLetterExchangeType;
    }

    public void setDeadLetterExchangeType(String deadLetterExchangeType) {
        this.deadLetterExchangeType = deadLetterExchangeType;
    }

    public String getDeadLetterQueue() {
        return deadLetterQueue;
    }

    public void setDeadLetterQueue(String deadLetterQueue) {
        this.deadLetterQueue = deadLetterQueue;
    }

    public String getDeadLetterRoutingKey() {
        return deadLetterRoutingKey;
    }

    public void setDeadLetterRoutingKey(String deadLetterRoutingKey) {
        this.deadLetterRoutingKey = deadLetterRoutingKey;
    }

    public Boolean getDeclare() {
        return declare;
    }

    public void setDeclare(Boolean declare) {
        this.declare = declare;
    }

    public Boolean getDurable() {
        return durable;
    }

    public void setDurable(Boolean durable) {
        this.durable = durable;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Boolean getPassive() {
        return passive;
    }

    public void setPassive(Boolean passive) {
        this.passive = passive;
    }

    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    public Boolean getSkipExchangeDeclare() {
        return skipExchangeDeclare;
    }

    public void setSkipExchangeDeclare(Boolean skipExchangeDeclare) {
        this.skipExchangeDeclare = skipExchangeDeclare;
    }

    public Boolean getSkipQueueBind() {
        return skipQueueBind;
    }

    public void setSkipQueueBind(Boolean skipQueueBind) {
        this.skipQueueBind = skipQueueBind;
    }

    public Boolean getSkipQueueDeclare() {
        return skipQueueDeclare;
    }

    public void setSkipQueueDeclare(Boolean skipQueueDeclare) {
        this.skipQueueDeclare = skipQueueDeclare;
    }

    public String getVhost() {
        return vhost;
    }

    public void setVhost(String vhost) {
        this.vhost = vhost;
    }

    public Boolean getAutoAck() {
        return autoAck;
    }

    public void setAutoAck(Boolean autoAck) {
        this.autoAck = autoAck;
    }

    public Boolean getBridgeErrorHandler() {
        return bridgeErrorHandler;
    }

    public void setBridgeErrorHandler(Boolean bridgeErrorHandler) {
        this.bridgeErrorHandler = bridgeErrorHandler;
    }

    public Boolean getExclusiveConsumer() {
        return exclusiveConsumer;
    }

    public void setExclusiveConsumer(Boolean exclusiveConsumer) {
        this.exclusiveConsumer = exclusiveConsumer;
    }

    public Integer getPrefetchCount() {
        return prefetchCount;
    }

    public void setPrefetchCount(Integer prefetchCount) {
        this.prefetchCount = prefetchCount;
    }

    public Boolean getPrefetchEnabled() {
        return prefetchEnabled;
    }

    public void setPrefetchEnabled(Boolean prefetchEnabled) {
        this.prefetchEnabled = prefetchEnabled;
    }

    public Boolean getPrefetchGlobal() {
        return prefetchGlobal;
    }

    public void setPrefetchGlobal(Boolean prefetchGlobal) {
        this.prefetchGlobal = prefetchGlobal;
    }

    public Integer getPrefetchSize() {
        return prefetchSize;
    }

    public void setPrefetchSize(Integer prefetchSize) {
        this.prefetchSize = prefetchSize;
    }

    public Integer getThreadPoolSize() {
        return threadPoolSize;
    }

    public void setThreadPoolSize(Integer threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    public Boolean getAllowNullHeaders() {
        return allowNullHeaders;
    }

    public void setAllowNullHeaders(Boolean allowNullHeaders) {
        this.allowNullHeaders = allowNullHeaders;
    }

    public Integer getChannelPoolMaxSize() {
        return channelPoolMaxSize;
    }

    public void setChannelPoolMaxSize(Integer channelPoolMaxSize) {
        this.channelPoolMaxSize = channelPoolMaxSize;
    }

    public Long getChannelPoolMaxWait() {
        return channelPoolMaxWait;
    }

    public void setChannelPoolMaxWait(Long channelPoolMaxWait) {
        this.channelPoolMaxWait = channelPoolMaxWait;
    }

    public Boolean getGuaranteedDeliveries() {
        return guaranteedDeliveries;
    }

    public void setGuaranteedDeliveries(Boolean guaranteedDeliveries) {
        this.guaranteedDeliveries = guaranteedDeliveries;
    }

    public Boolean getImmediate() {
        return immediate;
    }

    public void setImmediate(Boolean immediate) {
        this.immediate = immediate;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Boolean getPublisherAcknowledgements() {
        return publisherAcknowledgements;
    }

    public void setPublisherAcknowledgements(Boolean publisherAcknowledgements) {
        this.publisherAcknowledgements = publisherAcknowledgements;
    }

    public Long getPublisherAcknowledgementsTimeout() {
        return publisherAcknowledgementsTimeout;
    }

    public void setPublisherAcknowledgementsTimeout(
            Long publisherAcknowledgementsTimeout) {
        this.publisherAcknowledgementsTimeout = publisherAcknowledgementsTimeout;
    }

    public Map<String, Object> getArgs() {
        return args;
    }

    public void setArgs(Map<String, Object> args) {
        this.args = args;
    }

    public Boolean getAutoDetectConnectionFactory() {
        return autoDetectConnectionFactory;
    }

    public void setAutoDetectConnectionFactory(
            Boolean autoDetectConnectionFactory) {
        this.autoDetectConnectionFactory = autoDetectConnectionFactory;
    }

    public Boolean getAutomaticRecoveryEnabled() {
        return automaticRecoveryEnabled;
    }

    public void setAutomaticRecoveryEnabled(Boolean automaticRecoveryEnabled) {
        this.automaticRecoveryEnabled = automaticRecoveryEnabled;
    }

    public Boolean getBasicPropertyBinding() {
        return basicPropertyBinding;
    }

    public void setBasicPropertyBinding(Boolean basicPropertyBinding) {
        this.basicPropertyBinding = basicPropertyBinding;
    }

    public Map<String, Object> getClientProperties() {
        return clientProperties;
    }

    public void setClientProperties(Map<String, Object> clientProperties) {
        this.clientProperties = clientProperties;
    }

    public String getConnectionFactoryExceptionHandler() {
        return connectionFactoryExceptionHandler;
    }

    public void setConnectionFactoryExceptionHandler(
            String connectionFactoryExceptionHandler) {
        this.connectionFactoryExceptionHandler = connectionFactoryExceptionHandler;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Integer getNetworkRecoveryInterval() {
        return networkRecoveryInterval;
    }

    public void setNetworkRecoveryInterval(Integer networkRecoveryInterval) {
        this.networkRecoveryInterval = networkRecoveryInterval;
    }

    public Integer getRequestedChannelMax() {
        return requestedChannelMax;
    }

    public void setRequestedChannelMax(Integer requestedChannelMax) {
        this.requestedChannelMax = requestedChannelMax;
    }

    public Integer getRequestedFrameMax() {
        return requestedFrameMax;
    }

    public void setRequestedFrameMax(Integer requestedFrameMax) {
        this.requestedFrameMax = requestedFrameMax;
    }

    public Integer getRequestedHeartbeat() {
        return requestedHeartbeat;
    }

    public void setRequestedHeartbeat(Integer requestedHeartbeat) {
        this.requestedHeartbeat = requestedHeartbeat;
    }

    public Long getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(Long requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public Long getRequestTimeoutCheckerInterval() {
        return requestTimeoutCheckerInterval;
    }

    public void setRequestTimeoutCheckerInterval(
            Long requestTimeoutCheckerInterval) {
        this.requestTimeoutCheckerInterval = requestTimeoutCheckerInterval;
    }

    public Boolean getTopologyRecoveryEnabled() {
        return topologyRecoveryEnabled;
    }

    public void setTopologyRecoveryEnabled(Boolean topologyRecoveryEnabled) {
        this.topologyRecoveryEnabled = topologyRecoveryEnabled;
    }

    public Boolean getTransferException() {
        return transferException;
    }

    public void setTransferException(Boolean transferException) {
        this.transferException = transferException;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSslProtocol() {
        return sslProtocol;
    }

    public void setSslProtocol(String sslProtocol) {
        this.sslProtocol = sslProtocol;
    }

    public String getTrustManager() {
        return trustManager;
    }

    public void setTrustManager(String trustManager) {
        this.trustManager = trustManager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}