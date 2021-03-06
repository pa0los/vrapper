package net.sourceforge.vrapper.vim.commands.motions;

import static net.sourceforge.vrapper.vim.commands.Utils.characterType;
import net.sourceforge.vrapper.vim.commands.BorderPolicy;

public class MoveWordEndRight extends MoveRightWithBounds {

    public static final MoveWordEndRight INSTANCE = new MoveWordEndRight(false);
    public static final MoveWordEndRight BAILS_OFF = new MoveWordEndRight(true);

    protected MoveWordEndRight(boolean bailOff) {
        super(bailOff);
    }

    @Override
    protected boolean atBoundary(char c1, char c2) {
        return !Character.isWhitespace(c1) && characterType(c1, keywords) != characterType(c2, keywords);
    }

    public BorderPolicy borderPolicy() {
        return BorderPolicy.INCLUSIVE;
    }

    @Override
    protected boolean shouldStopAtLeftBoundingChar() {
        return true;
    }

    @Override
    protected boolean stopsAtNewlines() {
        return false;
    }

}
