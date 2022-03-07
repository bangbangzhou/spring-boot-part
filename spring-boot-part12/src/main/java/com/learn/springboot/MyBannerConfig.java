package com.learn.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.PrintStream;


public class MyBannerConfig implements Banner {
    public static final String MYBANNER=
                    ",--.   ,--.         ,--.                                   \n" +
                            "|  |   |  |  ,---.  |  |  ,---.  ,---.  ,--,--,--.  ,---.  \n" +
                            "|  |.'.|  | | .-. : |  | | .--' | .-. | |        | | .-. : \n" +
                            "|   ,'.   | \\   --. |  | \\ `--. ' '-' ' |  |  |  | \\   --. \n" +
                            "'--'   '--'  `----' `--'  `---'  `---'  `--`--`--'  `----' \n" +
                            "                                                           ";
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        out.println(MYBANNER);
        out.println();
    }
}
