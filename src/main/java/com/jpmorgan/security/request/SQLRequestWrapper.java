package com.jpmorgan.security.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import static com.jpmorgan.security.lib.SQLUtil.stripSQL;

public class SQLRequestWrapper extends HttpServletRequestWrapper {

    Logger logger = LoggerFactory.getLogger(SQLRequestWrapper.class);

    public SQLRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        logger.info("Values length: {}",values);
        if (values == null) {
            return null;
        }

        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = stripSQL(values[i]);
        }

        return encodedValues;
    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);

        return stripSQL(value);
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        return stripSQL(value);
    }
}
