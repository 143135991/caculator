package com.cloud.provider.entity;

public class caculator {
    private boolean point;
    private boolean error;
    private String tokens;
    private int pc;
    private int length;
    private String errormessage;

    private double caculate(double a, double b, int op) {
        if (op == 1) {
            return a + b;
        } else if (op == 2) {
            return a - b;
        } else if (op == 3) {
            return a * b;
        } else if (op == 4) {
            if (b==0) {
                if (this.error==false) {
                    this.errormessage = "Divided by 0!";
                    this.error = true;
                }
                return 0;
            } else {
                return a / b;
            }
        }
        return 0;
    }

    private double doit() {
        double a = next();
        if (this.pc == this.length) {
            return a;
        }
        char operator = this.tokens.charAt(this.pc);
        this.pc++;
        if (this.pc==this.length) {
            if (this.error==false) {
                this.errormessage = "Wrong formula!";
                this.error = true;
            }
            return 0;
        }
        double b = next();
        if (operator == '+') {
            return caculate(a, b, 1);
        } else if (operator == '-') {
            return caculate(a, b, 2);
        } else if (operator == '*') {
            return caculate(a, b, 3);
        } else if (operator == '/') {
            return caculate(a, b, 4);
        } else if (this.error==false) {
            this.errormessage = "Invalid operation!";
            this.error = true;
            return 0;
        }
        return 0;
    }

    private double next() {
        this.point = false;
        char token = this.tokens.charAt(this.pc);
        this.pc++;
        if (token == '(') {
            double a = doit();
            if (this.pc==this.length) {
                if (this.error==false) {
                    this.errormessage = "Wrong formula!";
                    this.error = true;
                }
                return 0;
            }
            token = this.tokens.charAt(this.pc);
            this.pc++;
            if (token == ')') {
                token = this.tokens.charAt(this.pc);
                if (token == '!') {
                    if (a == 0) {
                        a = 1;
                    }  else if (a%1==0) {
                        int result = 1;
                        for (int i = 1; i <= a; i++) {
                            result = result * i;
                        }
                        a = result;
                    }
                    else if (this.error==false) {
                        this.errormessage = "Wrong formula!";
                        this.error = true;
                        return 0;
                    }
                    else {
                        return 0;
                    }
                    this.pc++;
                }
                return a;
            }
            if (this.error==false) {
                this.errormessage = "Wrong formula!";
                this.error = true;
            }
            return 0;
        } else if ((token >= '0') && (token <= '9')) {
            double a = 1;
            int thetoken = token - '0';
            double dividetime = 10;
            a = a * thetoken;
            while (this.pc < this.length) {
                token = this.tokens.charAt(this.pc);
                if ((token >= '0') && (token <= '9')) {
                    thetoken = token - '0';
                    if (this.point == false) {
                        a = a * 10 + thetoken;
                    } else {
                        a = a + thetoken / dividetime;
                        dividetime = dividetime * 10;
                    }
                } else if (token == '.') {
                    if (this.point == false) {
                        this.point = true;
                    }
                    else if (this.error==false) {
                        this.errormessage = "Wrong formula!";
                        this.error = true;
                        return 0;
                    }
                    else {
                        return 0;
                    }
                } else if (token == '!') {
                    if (a == 0) {
                        this.pc++;
                        return 1;
                    }
                    if (a%1==0) {
                        int result = 1;
                        for (int i = 1; i <= a; i++) {
                            result = result * i;
                        }
                        a = result;
                    }
                    else if (this.error==false) {
                        this.errormessage = "Wrong formula!";
                        this.error = true;
                        return 0;
                    }
                    else {
                        return 0;
                    }
                } else if (token=='*') {
                    this.pc++;
                    double b = next();
                    return caculate(a,b,3);
                } else if (token=='/') {
                    this.pc++;
                    double b = next();
                    return caculate(a,b,4);
                } else {
                    return a;
                }
                this.pc++;
            }
            return a;
        } else if (this.error==false) {
            this.errormessage = "Wrong formula!";
            this.error = true;
            return 0;
        }
        else {
            return 0;
        }
    }

    private double stream(String s) {
        this.tokens = s;
        this.pc = 0;
        this.length = this.tokens.length();
        if (this.length != 0) {
            return doit();
        }
        return 0;
    }

    public String putin(String tokens) {
        this.error = false;
        double result;
        result = stream(tokens);
        if (this.error == false) {
            String feedback = tokens + " = " + result;
            return feedback;
        }
        return this.errormessage;
    }
}