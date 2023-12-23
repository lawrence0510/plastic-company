// LaunchUtil.java
package com.example.digitalbusiness.backend;

import java.io.IOException;

public class LaunchUtil {

    public static void openBrowser(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();

        try {
            if (os.contains("win")) {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("mac")) {
                rt.exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                rt.exec(new String[] { "sh", "-c", "firefox " + url + " || chrome " + url + " || opera " + url });
            } else {
                System.err.println("Unsupported operating system for browser launch");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
