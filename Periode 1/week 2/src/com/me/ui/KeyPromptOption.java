package com.me.ui;

public class KeyPromptOption {
    public char key;
    public String label;

    public KeyPromptOption(char key, String label) {
        this.key = key;
        this.label = label;
    }

    public void onKey() {}

    public String toString() {
        return String.format("%s: %s", key, label);
    }
}
