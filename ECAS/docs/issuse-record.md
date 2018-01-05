#issue-record
## 配置错误
### 1.同一类配置使用两种配置方式导致的解析错误
#### 方式1：
<bean id="propertyConfigurer">
          <!--class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">-->
        <property name="locations">-->
            <list>
                <value>classpath:bb.properties</value>
            </list>
        </property>
</bean>
#### 方式2：
<context:property-placeholder location="classpath:aa.properties" />

#### 解决方式：
<context:property-placeholder location="classpath:aa.properties" ignore-unresolvable="true" />