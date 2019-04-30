package com.example.final__project;

import java.util.Stack;

public class Calculator {
    public static boolean error = false;
    char[] operator = { '+', '-', '*', '/', '^', '~', 's', 'c', 't', '@', '!', '%', ')', '(',
            'l', 'z', 'x', 'v', 'n', 'e'};
    char[] last = { 's', 'c', 't', '@', '(', 'l', 'z', 'x', 'v', 'e'};

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




    public int[] checkParen(String word) {
        int[] answer = new int[2];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '(') {
                answer[0] += 1;
            }
            if (word.charAt(i) == ')') {
                answer[1] += 1;
            }
        }
        return answer;
    }

    public String[] receive(String word) {
        String string = "";
        String[] array;
        word = word.trim();
        word = word.replaceAll("\\s+"," ");
        int [] parenthesis = checkParen(word);
        for (int i = 0; i < (parenthesis[0] - parenthesis[1]); i++) {
            word += ')';
        }
        for (int i = 0; i < word.length(); i++) {
            boolean checked = false;
            for (int j = 0; j < last.length; j++) {
                if (last[j] == word.charAt(i)) {
                    checked = true;
                    break;
                }
            }
            if (i > 0 || Character.isDigit(word.charAt(i - 1)) || (word.charAt(i - 1) == 'π')) {
                if (checked) {
                    if (word.charAt(i - 1) == ')') {
                        string += "*";
                    }
                }
            }
            if ((i == 0 || (i > 0 && !Character.isDigit(word.charAt(i - 1))
                    || !(word.charAt(i - 1) == 'π'))) && word.charAt(i) == '-'
                    && Character.isDigit(word.charAt(i + 1)) || (word.charAt(i + 1) == 'π')) {
                string += "~";
            } else if (i > 0 && (Character.isDigit(word.charAt(i - 1))
                    || (word.charAt(i - 1) == 'π') || word.charAt(i - 1) == ')')) {
                if ((word.charAt(i) == 'π')) {
                    string = string + "*" + word.charAt(i);
                }
            } else {
                string += word.charAt(i);
            }
        }
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            boolean checked = false;
            for (int j = 0; j < operator.length; j++) {
                if (operator[j] == word.charAt(i + 1)) {
                    checked = true;
                    break;
                }
            }
            boolean checked2 = false;
            for (int j = 0; j < operator.length; j++) {
                if (operator[j] == temp) {
                    checked2 = true;
                    break;
                }
            }
            if (i < word.length() - 1) {
                if (temp == 'π') {
                    if (!checked) {
                        return null;
                    }
                }
            } else {
                if (!checked2) {
                    string = string + temp;
                } else {
                    string = string + " " + temp + " ";
                }
            }
        }
        string = string.trim();
        string = string.replaceAll("\\s+"," ");
        array = string.split(" ");
        return array;
    }

    public String[] stackParen(String[] array) {
        String string = "";
        String[] arrayString;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            char word = array[i].charAt(0);
            boolean checked = false;
            for (int j = 0; j < operator.length; j++) {
                if (operator[j] == word) {
                    checked = true;
                    break;
                }
            }
            if (!checked) {
                string = string + array[i] + " ";
            } else if (word == '(') {
                stack.push(array[i]);
            } else if (word == ')') {
                char temp = ' ';
                while (temp != '(') {
                    temp = stack.peek().charAt(0);
                    if (temp != '(') {
                        string = string + stack.peek() + " ";
                    }
                    stack.pop();
                }
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        break;
                    }
                    if (this.order(stack.peek().charAt(0)) < this.order(word)) {
                        break;
                    }
                    string = string + stack.pop() + " ";
                }
                stack.push(array[i]);
            }
        }
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            string = string + stack.pop() + " ";
        }
        arrayString = string.split(" ");
        return arrayString;
    }

    public String advanced(String[] array) {
        Stack<Double> stack = new Stack<>();
        double answer = 0.0;
        for (int i = 0; i < array.length; i++) {
            char word = array[i].charAt(0);
            if (word == 'π') {
                stack.push(Math.PI);
            } else if (word == 'e') {
                stack.push(Math.E);
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

