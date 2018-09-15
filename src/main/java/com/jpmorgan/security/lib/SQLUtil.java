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

            queryPattern = Pattern.compile("(?i)(.*)(\\\\b)+INSERT(\\\\b)+\\\\s.*(\\\\b)+INTO(\\\\b)+\\\\s.*(.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("(?i)(.*)(\\\\b)+UPDATE(\\\\b)+\\\\s.*(.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("(?i)(.*)(\\\\b)+DELETE(\\\\b)+\\\\s.*(\\\\b)+FROM(\\\\b)+\\\\s.*(.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("(?i)(.*)(\\\\b)+UPSERT(\\\\b)+\\\\s.*(.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("(?i)(.*)(\\\\b)+DROP(\\\\b)+\\\\s.*(.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("(.*)(/\\\\*|\\\\*/|;){1,}(.*)", Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("(.*)(-){2,}(.*)", Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("(?i)(.*)(\\\\b)+DESCRIBE(\\\\b)+(\\\\w)*\\\\s.*(.*)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

            queryPattern = Pattern.compile("(?i)(.*)(\\\\b)+DESC(\\\\b)+(\\\\w)*\\\\s.*(.*)", Pattern.CASE_INSENSITIVE| Pattern.MULTILINE | Pattern.DOTALL);
            value = queryPattern.matcher(value).replaceAll("");

        }

        return value;
    }
}
