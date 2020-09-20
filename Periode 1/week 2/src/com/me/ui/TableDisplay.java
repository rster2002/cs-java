package com.me.ui;

import java.util.List;

public class TableDisplay {
    private final String[] headers;
    private final String padding = "\t\t";

    public TableDisplay(List<String> headers) {
        this(headers.toArray(new String[0]));
    }

    public TableDisplay(String[] headers) {
        this.headers = headers;
    }

    public String formatColumn(String column) {
        return String.format("%12s", column);
    }

    public void printHeader() {
        // Prints the header names
        for (String header : headers) {
            System.out.print(formatColumn(header));
        }

        System.out.print("\n");

        // Prints the underline
        for (String header : headers) {
            System.out.print(formatColumn(createUnderlineFromString(header)));
        }

        System.out.print("\n");
    }

    private String createUnderlineFromString(String string) {
        // Thx IntelliJ
        return "*".repeat(string.length());
    }

    public void printRow(List<String> rowValues) {
        printRow(rowValues.toArray(new String[0]));
    }

    public void printRow(String[] rowValues) {
        for (String value : rowValues) {
            System.out.print(formatColumn(value));
        }

        System.out.print("\n");
    }
}
