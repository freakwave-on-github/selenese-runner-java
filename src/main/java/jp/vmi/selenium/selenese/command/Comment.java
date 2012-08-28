package jp.vmi.selenium.selenese.command;

import jp.vmi.selenium.selenese.TestCase;
import jp.vmi.selenium.selenese.result.Result;

import static jp.vmi.selenium.selenese.result.Empty.*;

/**
 * <!-- comment -->
 */
public class Comment extends Command {

    private static final String COMMENT_PREFIX = "### ";

    private static final String COMMENT_SUFFIX = " ###";

    private static final int MESSAGE = 0;

    Comment(int index, String name, String[] args, String realName, boolean andWait) {
        super(-1, name, args);
    }

    @Override
    public Result doCommand(TestCase testCase) {
        return EMPTY;
    }

    @Override
    public String toString() {
        return COMMENT_PREFIX + args[MESSAGE] + COMMENT_SUFFIX;
    }
}
