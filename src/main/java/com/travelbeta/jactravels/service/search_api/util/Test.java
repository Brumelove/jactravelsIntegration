package com.travelbeta.jactravels.service.search_api.util;

public class Test {

    public static void main(String[] args) {
        String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";
        if (xml.contains("<?xml")) {
            xml = xml.substring(xml.indexOf("?>") + 3);
        }


        System.out.println(":::: " + xml);
    }
}
