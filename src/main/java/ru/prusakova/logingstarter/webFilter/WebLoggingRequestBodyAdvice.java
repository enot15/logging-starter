package ru.prusakova.logingstarter.webFilter;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;
import ru.prusakova.logingstarter.service.LoggingService;

import java.lang.reflect.Type;

public class WebLoggingRequestBodyAdvice extends RequestBodyAdviceAdapter {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LoggingService loggingService;

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        loggingService.logRequestBody(request, body);

        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }


}
