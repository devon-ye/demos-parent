package org.devon.switchs.demo;

public class NumberTransformChineseNumber {

    public static void moneyValueTransformChar(long value) {
        String moneyValueStr = String.valueOf(value);
        char ch[] = moneyValueStr.toCharArray();
        StringBuilder numberLine = new StringBuilder();
        for (char key : ch) {
            numberLine.append(key).append("\t");
        }
        numberLine.append("\n");
        System.out.println(numberLine);
        charTransformNumber(ch);

    }

    public static void charTransformNumber(char[] ch) {
        String str = "";
        for (char key : ch) {
            String temp = numberTransformChineseNumber(key);
            str += temp;
        }
        System.out.println(str);
    }

    public static String numberTransformChineseNumber(char ch) {
        switch (ch) {
            case '0':
                return "零";
            case '1':
                return "壹";
            case '2':
                return "贰";
            case '3':
                return "叁";
            case '4':
                return "肆";
            case '5':
                return "伍";
            case '6':
                return "陆";
            case '7':
                return "柒";
            case '8':
                return "捌";
            case '9':
                return "玖";
            default:
                return null;
        }

    }

}
