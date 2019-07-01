import java.util.*;

public class caculator {
    static boolean point;
    static boolean error;
    static boolean conti;
    static Scanner scanner;
    static String tokens;
    static int pc;
    static int length;

    public static double caculate(double a, double b, int op) {
        if (op == 1) {
            return a + b;
        } else if (op == 2) {
            return a - b;
        } else if (op == 3) {
            return a * b;
        } else if (op == 4) {
            if (b==0) {
                if (error==false) {
                    System.out.print("Divided by 0!\n");
                    error = true;
                }
                return 0;
            } else {
                return a / b;
            }
        }
        return 0;
    }

    public static double doit() {
        double a = next();
        if (pc == length) {
            return a;
        }
        char operator = tokens.charAt(pc);
        pc++;
        if (pc==length) {
            if (error==false) {
                System.out.print("Wrong formula!\n");
                error = true;
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
        } else if (error==false) {
            System.out.print("Invalid operation!\n");
            error = true;
            return 0;
        }
        return 0;
    }

    public static double next() {
        point = false;
        char token = tokens.charAt(pc);
        pc++;
        if (token == '(') {
            double a = doit();
            if (pc==length) {
                if (error==false) {
                    System.out.print("Wrong formula!\n");
                    error = true;
                }
                return 0;
            }
            token = tokens.charAt(pc);
            pc++;
            if (token == ')') {
                token = tokens.charAt(pc);
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
                    else if (error==false) {
                        System.out.print("Wrong formula!\n");
                        error = true;
                        return 0;
                    }
                    else {
                        return 0;
                    }
                    pc++;
                }
                return a;
            }
            if (error==false) {
                System.out.print("Wrong formula!\n");
                error = true;
            }
            return 0;
        } else if ((token >= '0') && (token <= '9')) {
            double a = 1;
            int thetoken = token - '0';
            double dividetime = 10;
            a = a * thetoken;
            while (pc < length) {
                token = tokens.charAt(pc);
                if ((token >= '0') && (token <= '9')) {
                    thetoken = token - '0';
                    if (point == false) {
                        a = a * 10 + thetoken;
                    } else {
                        a = a + thetoken / dividetime;
                        dividetime = dividetime * 10;
                    }
                } else if (token == '.') {
                    if (point == false) {
                        point = true;
                    }
                    else if (error==false) {
                        System.out.print("Wrong formula!\n");
                        error = true;
                        return 0;
                    }
                    else {
                        return 0;
                    }
                } else if (token == '!') {
                    if (a == 0) {
                        pc++;
                        return 1;
                    }
                    if (a%1==0) {
                        int result = 1;
                        for (int i = 1; i <= a; i++) {
                            result = result * i;
                        }
                        a = result;
                    }
                    else if (error==false) {
                        System.out.print("Wrong formula!\n");
                        error = true;
                        return 0;
                    }
                    else {
                        return 0;
                    }
                } else if (token=='*') {
                    pc++;
                    double b = next();
                    return caculate(a,b,3);
                } else if (token=='/') {
                    pc++;
                    double b = next();
                    return caculate(a,b,4);
                } else {
                    return a;
                }
                pc++;
            }
            return a;
        } else if (error==false) {
            System.out.print("Wrong formula!\n");
            error = true;
            return 0;
        }
        else {
            return 0;
        }
    }

    public static double stream() {
        error = false;
        tokens = scanner.nextLine();
        if (tokens.equals("exit")) {
            conti = false;
            return 0;
        }
        pc = 0;
        length = tokens.length();
        if (length != 0) {
            return doit();
        }
        return 0;
    }

    public static void main(String[] args) {
        conti = true;
        error = false;
        scanner = new Scanner(System.in);
        double result;
        while (conti) {
            System.out.print(">");
            result = stream();
            if ((error == false) && (conti == true)) {
                System.out.print("= ");
                System.out.print(result);
                System.out.print("\n");
            }
        }
        System.out.print("Goodbye!\n");
    }
}