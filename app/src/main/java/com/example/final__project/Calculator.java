package com.example.final__project;

import java.util.Arrays;
import java.util.Stack;

public class Calculator {
    boolean error;
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

    public String[] stackParen(String[] array) {
        String string = "";
        String[] arrayString;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            char word = array[i].charAt(0);
            if (!this.checkSign(word)) {
                string = string + array[i] + " ";
            } else {
                if (word == '(') {
                    stack.push(array[i]);
                } else {
                    if (word == ')') {
                        char temp;
                        do {
                            temp = stack.peek().charAt(0);
                            if (temp != '(') {
                                string = string + stack.peek() + " ";
                            }
                            stack.pop();
                        } while (temp != '(');
                    } else {
                        while (!stack.isEmpty() && this.order(stack.peek().charAt(0))
                                >= this.order(word)) {
                            string = string + stack.pop() + " ";
                        }
                        stack.push(array[i]);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            string = string + stack.pop() + " ";
        }
        arrayString = string.split(" ");
        return arrayString;
    }

    public String advanced(String[] array) {
        Stack<Double> stack = new Stack<>();
        Calculator cal = new Calculator();
        double answer = 0.0;
        for (int i = 0; i < array.length; i++) {
            char word = array[i].charAt(0);
            if (word == 'π') {
                stack.push(Math.PI);
            } else {
                double first = stack.pop();
                if (word == '~') {
                    answer = -first;
                } else if (word == 's') {
                    answer = Math.sin(first);
                } else if (word == 'c') {
                    answer = Math.cos(first);
                } else if (word == 't') {
                    answer = Math.tan(first);
                } else if (word == 'z') {
                    answer = Math.asin(first);
                } else if (word == 'x') {
                    answer = Math.acos(first);
                } else if (word == 'v') {
                    answer = Math.atan(first);
                } else if (word == 'l') {
                    answer = Math.log10(first);
                } else if (word == 'n') {
                    answer = Math.log(first);
                } else if (word == 'e') {
                    answer = Math.exp(first);
                } else if (word == '%') {
                    answer = first / 100;
                } else if (word == '@') {
                    if (first < 0) {
                        error = true;
                    }
                    answer = Math.sqrt(first);
                } else if (word == '!') {
                    if (first == 0) {
                        answer = 1;
                    } else if (first < 0) {
                        error = true;
                    } else {
                        for (int k = (int) first - 1; k > -1; k--) {
                            answer *= (first - k);
                        }
                    }
                }
                if (!stack.empty()) {
                    double second = stack.peek();
                    if (word == '+') {
                        answer = second + first;
                        stack.pop();
                    } else if (word == '-') {
                        answer = second - first;
                        stack.pop();
                    } else if (word == '*') {
                        answer = second * first;
                        stack.pop();
                    } else if (word == '/') {
                        if (first != 0) {
                            answer = second / first;
                        } else {
                            error = true;
                        }
                        stack.pop();
                    } else if (word == '^') {
                        answer = Math.pow(second, first);
                        stack.pop();
                    }
                }
                stack.push(answer);
            }
        }
        if (stack.pop() == Math.PI) {
            return "π";
        } else {
            int i = stack.pop().intValue();
            if (stack.pop() == i) {
                return Integer.toString(i);
            } else {
                return Double.toString(answer);
            }
        }
    }
}

