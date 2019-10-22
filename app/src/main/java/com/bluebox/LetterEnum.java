package com.bluebox;

public enum LetterEnum {
    A('a', "100000"),
    B('b', "110000"),
    C('c', "100100"),
    D('d', "100110"),
    E('e', "100010"),
    F('f', "110100"),
    G('g', "110110"),
    H('h', "110010"),
    I('i', "010100"),
    J('j', "010110"),
    K('k', "101000"),
    L('l', "111000"),
    M('m', "101100"),
    N('n', "101110"),
    O('o', "101010"),
    P('p', "111100"),
    Q('q', "111110"),
    R('r', "111010"),
    S('s', "011100"),
    T('t', "011110"),
    U('u', "101001"),
    V('v', "111001"),
    W('w', "010111"),
    X('x', "101101"),
    Y('y', "101111"),
    Z('z', "101011"),
    UM('1', "100000"),
    DOIS('2', "110000"),
    TRES('3', "100100"),
    QUATRO('4', "100110"),
    CINCO('5', "100010"),
    SEIS('6', "110100"),
    SETE('7', "110110"),
    OITO('8', "110010"),
    NOVE('9', "010100"),
    ZERO('0', "010110"),
    PONTO('.', "010011"),
    VIRGULA(',', "010000"),
    INTERROGACAO('?', "011001"),
    EXCLAMACAO('!', "011010"),
    DOISPONTOS(':', "010010"),
    PONTOEVIRGULA(';', "001010"),
    ESPACO(' ', "000000");

    private final Character key;
    private final String value;

    LetterEnum(Character key, String value) {
        this.key = key;
        this.value = value;
    }

    public Character getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static LetterEnum fromKey(Character character) {
        for (LetterEnum braille : LetterEnum.values()) {
            if (braille.getKey().equals(character)) {
                return braille;
            }
        }
        return INTERROGACAO;
    }

}
