package com.lanaco.movies.Exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanaco.movies.Utils.FormatUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e)
            throws IOException, ServletException {

        ErrorMessage errorMessage = new ErrorMessage(FormatUtils.getSimpleDateFormat().format(new Date()),
                HttpStatus.FORBIDDEN.value(),"Nemate privilegiju za ovu opciju!",
                httpServletRequest.getRequestURI().toString());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out,errorMessage);
        out.flush();
        out.close();
    }
}
