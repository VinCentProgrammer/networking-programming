/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinetaddress;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author admin
 */
public class MyURLCheckStatusWebsite {

    public static void main(String[] args) {
        String[] websites = {
            "https://facebook.com",
            "https://google.com",
            "https://dantri.com",
            "https://thanhnien1.vn",
            "https://vandung.devcv.online/admin/dashboard"
        };
        // Check status websites
        for (String website : websites) {
            checkStatus(website);
        }
    }

    public static void checkStatus(String website) {
        try {
            URL url = new URL(website);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // Http code: 200, 401, 403, 500, 404
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Website " + website + " hoat dong ");
            } else {
                System.out.println("Website " + website + "khong hoat dong - ma loi: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Khong the ket noi den website " + website);
        }
    }
}
