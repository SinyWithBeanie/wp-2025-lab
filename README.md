<form method="GET" action="/books" style="margin-bottom: 20px">
    <label>Title:</label>
    <input type="text"
           name="title"
           th:value="${title}"
           placeholder="Enter title"/>

    <label>Author:</label>
    <select name="authorId">
        <option th:value=""
                th:selected="${authorId == null}">
            -- All authors --
        </option>

        <option th:each="a : ${authors}"
                th:value="${a.id}"
                th:text="${a.name + ' ' + a.surname}"
                th:selected="${authorId != null and authorId == a.id}">
        </option>
    </select>

    <input type="submit" value="Filter"/>
</form>

# wp-2025-lab

Laboratory extercises for Web Programming 2025

Building a Book Reservation Service website.

<form method="GET" action="/books" style="margin-bottom: 20px">
    <label>Title:</label>
    <input type="text"
           name="title"
           th:value="${title}"
           placeholder="Enter title"/>

    <label>Author:</label>
    <select name="authorId">
        <option th:value=""
                th:selected="${authorId == null}">
            -- All authors --
        </option>

        <option th:each="a : ${authors}"
                th:value="${a.id}"
                th:text="${a.name + ' ' + a.surname}"
                th:selected="${authorId != null and authorId == a.id}">
        </option>
    </select>

    <input type="submit" value="Filter"/>
</form>

2025-12-01T13:32:16.213+01:00 ERROR 10784 --- [lab-wp] [nio-9090-exec-1] org.thymeleaf.TemplateEngine             : [THYMELEAF][http-nio-9090-exec-1] Exception processing template "listBooks": Could not parse as expression: "" (template: "listBooks" - line 149, col 21)

org.thymeleaf.exceptions.TemplateProcessingException: Could not parse as expression: "" (template: "listBooks" - line 149, col 21)
	at org.thymeleaf.standard.expression.StandardExpressionParser.parseExpression(StandardExpressionParser.java:131) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.standard.expression.StandardExpressionParser.parseExpression(StandardExpressionParser.java:62) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.standard.expression.StandardExpressionParser.parseExpression(StandardExpressionParser.java:44) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.EngineEventUtils.parseAttributeExpression(EngineEventUtils.java:220) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.EngineEventUtils.computeAttributeExpression(EngineEventUtils.java:207) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.standard.processor.AbstractStandardExpressionAttributeTagProcessor.doProcess(AbstractStandardExpressionAttributeTagProcessor.java:125) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.processor.element.AbstractAttributeTagProcessor.doProcess(AbstractAttributeTagProcessor.java:74) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.processor.element.AbstractElementTagProcessor.process(AbstractElementTagProcessor.java:95) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.util.ProcessorConfigurationUtils$ElementTagProcessorWrapper.process(ProcessorConfigurationUtils.java:633) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.ProcessorTemplateHandler.handleOpenElement(ProcessorTemplateHandler.java:1314) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.OpenElementTag.beHandled(OpenElementTag.java:205) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.TemplateModel.process(TemplateModel.java:136) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.TemplateManager.parseAndProcess(TemplateManager.java:661) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1103) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1077) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.view.ThymeleafView.renderFragment(ThymeleafView.java:372) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.view.ThymeleafView.render(ThymeleafView.java:192) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1438) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1168) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1106) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564) ~[tomcat-embed-core-10.1.48.jar:6.0]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658) ~[tomcat-embed-core-10.1.48.jar:6.0]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:138) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51) ~[tomcat-embed-websocket-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:138) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-6.2.12.jar:6.2.12]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.12.jar:6.2.12]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:138) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-6.2.12.jar:6.2.12]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.12.jar:6.2.12]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:138) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-6.2.12.jar:6.2.12]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.12.jar:6.2.12]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:138) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:165) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:88) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:482) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:113) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:83) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:72) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:342) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:903) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1774) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:973) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:491) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at java.base/java.lang.Thread.run(Thread.java:1474) ~[na:na]

2025-12-01T13:32:16.216+01:00 ERROR 10784 --- [lab-wp] [nio-9090-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.thymeleaf.exceptions.TemplateProcessingException: Could not parse as expression: "" (template: "listBooks" - line 149, col 21)] with root cause

org.thymeleaf.exceptions.TemplateProcessingException: Could not parse as expression: "" (template: "listBooks" - line 149, col 21)
	at org.thymeleaf.standard.expression.StandardExpressionParser.parseExpression(StandardExpressionParser.java:131) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.standard.expression.StandardExpressionParser.parseExpression(StandardExpressionParser.java:62) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.standard.expression.StandardExpressionParser.parseExpression(StandardExpressionParser.java:44) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.EngineEventUtils.parseAttributeExpression(EngineEventUtils.java:220) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.EngineEventUtils.computeAttributeExpression(EngineEventUtils.java:207) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.standard.processor.AbstractStandardExpressionAttributeTagProcessor.doProcess(AbstractStandardExpressionAttributeTagProcessor.java:125) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.processor.element.AbstractAttributeTagProcessor.doProcess(AbstractAttributeTagProcessor.java:74) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.processor.element.AbstractElementTagProcessor.process(AbstractElementTagProcessor.java:95) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.util.ProcessorConfigurationUtils$ElementTagProcessorWrapper.process(ProcessorConfigurationUtils.java:633) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.ProcessorTemplateHandler.handleOpenElement(ProcessorTemplateHandler.java:1314) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.OpenElementTag.beHandled(OpenElementTag.java:205) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.TemplateModel.process(TemplateModel.java:136) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.TemplateManager.parseAndProcess(TemplateManager.java:661) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1103) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1077) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.view.ThymeleafView.renderFragment(ThymeleafView.java:372) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.view.ThymeleafView.render(ThymeleafView.java:192) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1438) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1168) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1106) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564) ~[tomcat-embed-core-10.1.48.jar:6.0]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885) ~[spring-webmvc-6.2.12.jar:6.2.12]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658) ~[tomcat-embed-core-10.1.48.jar:6.0]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:138) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51) ~[tomcat-embed-websocket-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:138) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-6.2.12.jar:6.2.12]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.12.jar:6.2.12]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:138) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-6.2.12.jar:6.2.12]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.12.jar:6.2.12]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:138) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-6.2.12.jar:6.2.12]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.12.jar:6.2.12]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-10.1.48.jar:10.1.48]
	at org.apache.catalina.core.ApplicationFi
