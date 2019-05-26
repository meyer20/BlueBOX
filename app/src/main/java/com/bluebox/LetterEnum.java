package com.bluebox;

public enum LetterEnum {
    A('a', "100000"), B('b', "101000"), C('c', "110000"), D('d', "110100"), E('e', "100100"), F('f', "111000"),
    G('g', "111100"), H('h', "101100"), I('i', "010100"), J('j', "011100"), K('k', "100010"), L('l', "101010"),
    M('m', "110010"), N('n', "110110"), O('o', "100110"), P('p', "111010"), Q('q', "111110"), R('r', "101110"),
    S('s', "011010"), T('t', "011110"), U('u', "100011"), V('v', "101011"), W('w', "011101"), X('x', "110011"),
    Y('y', "110111"), Z('z', "100111"), UM('1', "100000"), DOIS('2', "101000"), TRES('3', "110000"),
    QUATRO('4', "110100"), CINCO('5', "100100"), SEIS('6', "111000"), SETE('7', "111100"), OITO('8', "101100"),
    NOVE('9', "010100"), ZERO('0', "011100"), PONTO('.', "001101"), VIRGULA(',', "001000"),
    INTERROGACAO('?', "001011"), EXCLAMACAO('!', "001110"), DOISPONTOS(':', "001100"),
    PONTOEVIRGULA(';', "001010"), HASHTAG('#', "010111"), HIFEN('-', "000011"), ESPACO(' ', "000000");

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
