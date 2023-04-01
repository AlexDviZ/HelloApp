import java.util.Scanner;

public class Program {
    public static <O> void main(String[] args) throws Exception {
        calc("");
    }

    public static String calc(String input) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] mas = s.split("\\s*(\\s|/|-|\\+|\\*)\\s*");
        if (mas.length > 2) {
            throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\")");
        }
        if (mas.length == 1) {
            throw new Exception("//т.к. строка не является математической операцией");
        }
        int ar = 0;
        int rm = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                if (mas[i].equals(Integer.toString(j + 1))) {
                    ar++;
                }
            }
        }
        if (ar == 1) {
            throw new Exception("//т.к. используются одновременно разные системы счисления");
        }
        if (ar == 2) {
            x = Integer.valueOf(mas[0]);
            y = Integer.valueOf(mas[1]);
        } else {
            try {
                x = Rim.valueOf(mas[0]).getValue();
                y = Rim.valueOf(mas[1]).getValue();
                rm = 2;
            } catch (IllegalArgumentException e) {
                throw new Exception("// не соответсвтвует заданному диапазону");
            }
        }
        int res = 0;
        if (s.contains("-")) {
            res = x - y;
        } else if (s.contains("+")) {
            res = x + y;
        } else if (s.contains("*")) {
            res = x * y;
        } else if (s.contains("/")) {
            res = x / y;
        }
        if (ar == 2) {
            System.out.println(res);
        } else if (rm == 2) {
            if (res <= 0) {
                throw new Exception("//т.к. в римской системе нет отрицательных чисел");
            } else if (res > 10) {
                System.out.println(Rim.values()[res / 10 + 8] + "" + Rim.values()[res % 10 - 1]);
            } else if (res < 10) {
                System.out.println(Rim.values()[res % 10 - 1]);
            } else {
                System.out.println(Rim.values()[res / 10 + 8]);
            }
        }
        return input;
    }
}

enum Rim {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XX(20), XXX(30), XL(40), L(50), LX(60), LXX(70), LXXX(80), XC(90), C(100);
    private final int value;

    private Rim(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}





