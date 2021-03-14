package com.example.binary_conversion.Model;

public class InputModel {
    private int bin, dec = 0, carry, i = 1;

    public void setBin(int bin) {
        this.bin = bin;
    }

    public void setDec(int dec) {
        this.dec = dec;
    }

    public int getBin() {
        return bin;
    }

    public int getDec() {
        return dec;
    }

    public int calcDec() {
        while (bin != 0) {
            carry = bin % 10; // binary dividible by 10
            dec = dec + carry * i;
            i *= 2; // same as i = i * 2
            bin /= 10; // same as bin = bin / 10
        }
        return dec;
    }

    public int calcBothBin() {
        return dec == 0 ? 0 : dec < 0 ? calcNegBin() : calcBin();
    }

    public int calcBin() {
        String binary = "";
        while (dec > 0) {
            carry = dec % 2; // decimal dividible by 2
            binary = carry + binary;
            dec /= 2; // same as dec = dec / 2
        }
        bin = Integer.parseInt("0" + binary); // Making it to Int
        return bin;
    }

    private int calcNegBin() {
        dec *= -1; // making the number non negative
        String binary = "";
        while (dec > 0) {
            carry = dec % 2; // decimal dividible by 2
            binary = carry + binary;
            dec /= 2; // same as dec = dec / 2
        }
        // Shifting our 1 to 0 and 0 to 1
        binary = binary.replaceAll("0", "2");
        binary = binary.replaceAll("1", "0");
        binary = binary.replaceAll("2", "1");

        // Summing our result with 1
        binary = sumBin("1" + binary, "1");
        bin = Integer.parseInt(binary); // Making it to Int
        return bin;
    }

    private String sumBin(String b1, String b2) {
        int len1 = b1.length(); // Length of 1st Binary
        int len2 = b2.length(); // Length of 2nd Binary
        int carry = 0;
        String binary = "";
        int maxLen = Math.max(len1, len2); // Max Length
        for (int i = 0; i < maxLen; i++) {
            int p = i < len1 ? b1.charAt(len1 - 1 - i) - '0' : 0;
            int q = i < len2 ? b2.charAt(len2 - 1 - i) - '0' : 0;
            int tmp = p + q + carry;
            carry = tmp / 2;
            binary = tmp % 2 + binary;
        }
        return (carry == 0) ? binary : "1" + binary;
    }
}
