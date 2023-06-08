package packages.calculator;

import java.util.Locale;
import java.util.Scanner;

enum TokenType {
    Unknown, Integer, Double,
}

public class calculator {
    private String token;
    private TokenType tokenType;
    private Scanner scanner;
    private Boolean parsed = false;
    private Expr expr = null;

    public calculator(String input) {
        this.scanner = new Scanner(input).useDelimiter(" ").useLocale(Locale.US);
    }

    public Expr Parse() {
        try {
            if (!parsed) {
                next();
                expr = parseExpr();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        scanner.close();
        return expr;
    }

    private Expr parseExpr() throws Exception {
        return parseBinary(1);
    }

    private Expr parseBinary(int prec) throws Exception {
        var lhs = parseUnary();
        for (var p = precedence(); p >= prec; p--) {
            while (p == prec) {
                var op = text();
                next();
                lhs = new binary(op, lhs, parseBinary(prec + 1));
                p = precedence();
            }
        }
        return lhs;
    }

    private Expr parseUnary() throws Exception {
        var op = this.text();
        if (op == "+" || op == "-") {
            return new unary(op, parseUnary());
        }
        return parsePrimary();
    }

    private Expr parsePrimary() throws Exception {
        var text = text();
        var token = tokenType;
        next();
        switch (token) {
            case Integer:
                return new literal((double) Integer.parseInt(text));
            case Double:
                return new literal(Double.parseDouble(text));
            default:
                throw new Exception("unexpected token type: " + text);
        }
    }

    private int precedence() {
        switch (text()) {
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    private interface tokener {
        TokenType token();
    }

    private tokener[] tokens = new tokener[] {
            new tokener() {
                public TokenType token() {
                    if (scanner.hasNextInt()) {
                        return TokenType.Integer;
                    }
                    return TokenType.Unknown;
                }
            }, new tokener() {
                public TokenType token() {
                    if (scanner.hasNextDouble()) {
                        return TokenType.Double;
                    }
                    return TokenType.Unknown;
                }
            }
    };

    private void next() {
        TokenType newTokenType = TokenType.Unknown;
        for (tokener get : tokens) {
            newTokenType = get.token();
            if (newTokenType != TokenType.Unknown) {
                break;
            }
        }
        this.tokenType = newTokenType;
        if (this.scanner.hasNext()) {
            this.token = this.scanner.next();
        } else {
            this.token = "";
        }
    }

    private String text() {
        return this.token;
    }
}
