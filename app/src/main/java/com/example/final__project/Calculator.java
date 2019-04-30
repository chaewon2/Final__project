package com.example.final__project;

import java.util.Arrays;
import java.util.Stack;

public class Calculator {
    char[] operator = { '+', '-', '*', '/', '^', '~', 's', 'c', 't', '@', '!', '%', ')', '(',
            'l', 'z', 'x', 'v', 'n', 'e'};
    public int order(char kind) {
        if (kind == '+' || kind == '=') {
            return 1;
        } else if (kind == '*' || kind == '/') {
            return 2;
        } else if (kind == '~') {
            return 3;
        } else if (kind == '@' || kind == '!' || kind == '^' || kind == 'e') {
            return 4;
        } else if (kind == 's' || kind == 'c' || kind == 't' || kind == 'z' || kind == 'x'
                || kind == 'v' || kind == 'l' || kind == 'n') {
            return 5;
        } else {
            return 0;
        }
    }
}

