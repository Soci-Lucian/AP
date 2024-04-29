package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
    private List<Token> tokens;

    public Sequence() {
        this.tokens = new ArrayList<>();
    }

    public boolean canExtend(Token token) {
        if (tokens.isEmpty()) {
            return true; // The sequence is empty, any token can extend it
        }
        Token lastToken = tokens.get(tokens.size() - 1);
        return lastToken.second() == token.first();
    }

    public void extend(Token token) {
        tokens.add(token);
    }

    public int getLength() {
        return tokens.size();
    }
}
