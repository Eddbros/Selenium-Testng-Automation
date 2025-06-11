package com.CheckLinks.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckingLinks_Page {

    private WebDriver driver;

    public CheckingLinks_Page (WebDriver driver){
        this.driver = driver;
    }

    public boolean checkingPageLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        String url = "";
        List<String> brokenLinks = new ArrayList<String>();
        List<String> successLinks = new ArrayList<String>();

        HttpURLConnection httpsConection = null;
        int responseCode = 200;
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println(url + "url is not configure or it is empty");
                continue;
            }
            try {
                httpsConection = (HttpURLConnection) (new URL(url).openConnection());
                httpsConection.setRequestMethod("HEAD");
                httpsConection.connect();
                responseCode = httpsConection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println("Error Broken Link :" + url);
                    brokenLinks.add(url);
                } else {
                    System.out.println("Valid link :" + url);
                    successLinks.add(url);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Valid link :" + successLinks.size());
        System.out.println("Broken Links: " + brokenLinks.size());

        if(brokenLinks.size()>0) {
            System.out.println("*****ERROR**** Broken Links");
            for (int i=0;i<brokenLinks.size();i++){
                System.out.println(brokenLinks.get(i));
            }
            return false;
        } else {
            return true;
        }

    }
}

