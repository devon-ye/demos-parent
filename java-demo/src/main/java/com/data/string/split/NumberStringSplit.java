package com.data.string.split;

public class NumberStringSplit {

    public static void main(String[] args) {
        String str = "3323d453453sssssssDfsdffs";
        NumberStringSplit.numberString(str);

    }

    public static void numberString(String str) {
        if (str == null) {
            return;
        }
      //  String[] strArray = str.split("", str.length());

        char ch[] = str.toCharArray();
        // a-z：97-122 A-Z：65-90 0-9：48-57
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 97 && ch[i] <= 122) {
                System.out.print(i);
                if (i != (i + 1)) {
                    // b = false;
                    // ch[i + 1] = " ";
                    count++;
                    // int a[]
                }
            }
            if (ch[i] >= 48 && ch[i] <= 57) {

            }
        }
        System.out.println("count=" + count);
    }

}
