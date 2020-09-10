package com.me.ui;

public class TableDisplay {
    private final String[] headers;
    private final String padding = "\t\t";

    public TableDisplay(String[] headers) {
        this.headers = headers;
    }

    public void printHeader() {
        // Prints the header names
        for (String header : headers) {
            System.out.print(header + padding);
        }

        System.out.print("\n");

        // Prints the underline
        for (String header : headers) {
            System.out.print(createUnderlineFromString(header) + padding);
        }

        System.out.print("\n");
    }

    private String createUnderlineFromString(String string) {
        // Thx IntelliJ
        return "*".repeat(string.length());
    }

    public void printRow(String[] rowValues) {
        for (String value : rowValues) {
            System.out.print(value + padding);
        }

        System.out.print("\n");
    }
}
