package io.interfiber.Pizza.utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class Log {
    protected static final Logger log = LogManager.getLogger();
    public static void init(){
    log.info("HI! THERE! BOB!");
    }
}
