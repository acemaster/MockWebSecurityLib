package com.jpmorgan.security.lib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class SQLUtil {
    private static Logger logger = LoggerFactory.getLogger(SQLUtil.class);

    public static String stripSQL(String value) {
        logger.info("Value {}",value);
        if(value != null){

            value = value.replaceAll("", "");

            Pattern queryPattern = Pattern.compile("('.+--)|(--)|(\\|)|(%7C)", Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll( "");

            queryPattern = Pattern.compile("INSERT INTO (.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("UPDATE (.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("DELETE FROM (.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("UPSERT (.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("DROP TABLE (.*?)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("DESCRIBE (.*)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("DESC (.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

        }

        return value;
    }
}
