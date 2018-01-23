package ca.zaher.m.caesarapp;

/**
 * Created by zaher on 2018-01-23.
 */

public class CaesarCipher {
    private String input;
    private String cryptedInput;
    private Integer shiftValue;

    public CaesarCipher() {
    }


    public void setInput(String input) {
        this.input = input;
    }

    public String getCryptedInput() {
        return cryptedInput;
    }

    public Integer getShiftValue() {
        return shiftValue;
    }

    public void setShiftValue(Integer shiftValue) {
        this.shiftValue = shiftValue;
    }

    public void caesar() {
        String cryptedInput = "";
        char letter;
        int ascii;
        for (int i = 0; i < this.input.length(); i++) {
            letter = this.input.charAt(i);
            if (letter != ' ') {
                ascii = (int) letter;
                ascii = ascii + (this.shiftValue % 26);
                ascii = ascii > 'Z' ? ascii - 26 : ascii;
                cryptedInput = cryptedInput + (char) ascii;
            } else {
                cryptedInput = cryptedInput + ' ';
            }
        }
        this.cryptedInput = cryptedInput;
    }
}
