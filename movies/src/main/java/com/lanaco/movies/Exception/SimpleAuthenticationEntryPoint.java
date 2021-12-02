package com.lanaco.movies.Exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanaco.movies.Utils.FormatUtils;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.springframework.core.log.LogFormatUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@Component
public class SimpleAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        ErrorMessage errorMessage = new ErrorMessage(FormatUtils.getSimpleDateFormat().format(new Date()),
                HttpStatus.UNAUTHORIZED.value(),"Autentifikacija nije uspjela. Provjerite kredencijale.",
                httpServletRequest.getRequestURI().toString());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out,errorMessage);
        out.flush();
        out.close();
    }
}
