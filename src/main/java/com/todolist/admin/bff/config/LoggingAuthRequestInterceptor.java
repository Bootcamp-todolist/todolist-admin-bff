package com.todolist.admin.bff.config;

import static com.todolist.admin.bff.common.Constant.USER_ID;
import static com.todolist.admin.bff.common.Constant.USER_ROLE;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class LoggingAuthRequestInterceptor implements RequestInterceptor {

  public static final String HEADER_REQUEST_ID = "X-Request-ID";
  public static final String HEADER_USER_ID = USER_ID;
  public static final String HEADER_USER_TOLE = USER_ROLE;

  @Override
  public void apply(RequestTemplate template) {
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    assert requestAttributes != null;
    String requestId = requestAttributes.getRequest().getHeader(HEADER_REQUEST_ID);
    ThreadContext.put(HEADER_REQUEST_ID, requestId);
    template.header(HEADER_REQUEST_ID, requestId);
    template.header(HEADER_USER_ID, requestAttributes.getRequest().getHeader(HEADER_USER_ID));
    template.header(HEADER_USER_TOLE, requestAttributes.getRequest().getHeader(HEADER_USER_TOLE));
  }
}
