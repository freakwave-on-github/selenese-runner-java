package jp.vmi.selenium.selenese;

import java.io.PrintStream;

import org.openqa.selenium.internal.WrapsDriver;

import jp.vmi.selenium.selenese.command.CommandListIterator;
import jp.vmi.selenium.selenese.locator.WebDriverElementFinder;
import jp.vmi.selenium.selenese.subcommand.SubCommandMap;

/**
 * Selenese Runner Context.
 */
public interface Context extends WrapsDriver {

    /**
     * Get current test-case.
     * 
     * @return current test-case.
     */
    TestCase getCurrentTestCase();

    /**
     * Set current test-case.
     *
     * @param testCase current test-case.
     */
    void setCurrentTestCase(TestCase testCase);

    /**
     * Get PrintStream for logging.
     *
     * @return PrintStram object.
     */
    PrintStream getPrintStream();

    /**
     * Get base URL for overriding test-case base URL.
     *
     * @return base URL.
     */
    String getOverridingBaseURL();

    /**
     * Get current base URL.
     *
     * @return base URL.
     */
    String getCurrentBaseURL();

    /**
     * Get CommandListIterator.
     *
     * @return CommanListIterator.
     */
    CommandListIterator getCommandListIterator();

    /**
     * Set CommandListIterator.
     *
     * @param commandListIterator CommanListIterator.
     */
    void setCommandListIterator(CommandListIterator commandListIterator);

    /**
     * Get variables map.
     *
     * @return VarsMap.
     */
    VarsMap getVarsMap();

    /**
     * Get collection map.
     *
     * @return CollectionMap.
     */
    CollectionMap getCollectionMap();

    /**
     * Get initial window handle.
     *
     * @return window handle.
     */
    String getInitialWindowHandle();

    /**
     * Get elemnt finder.
     *
     * @return element finder.
     */
    WebDriverElementFinder getElementFinder();

    /**
     * Get evaluater.
     *
     * @return eval object.
     */
    Eval getEval();

    /**
     * Get boolean value of expr.
     * 
     * @param expr expression.
     * @return cast from result of expr to Javascript Boolean.
     */
    boolean isTrue(String expr);

    /**
     * Get SubCommandMap instance.
     * 
     * @return SubCommandMap instance.
     */
    SubCommandMap getSubCommandMap();

    /**
     * Get timeout for waiting. (ms)
     *
     * @return timeout for waiting.
     */
    public int getTimeout();

    /**
     * Reset speed as initial speed.
     */
    void resetSpeed();

    /**
     * Get speed for setSpeed command.
     *
     * @return speed.
     */
    long getSpeed();

    /**
     * Set speed for setSpeed command.
     *
     * @param speed speed.
     */
    void setSpeed(long speed);

    /**
     * Wait according to speed setting. 
     */
    void waitSpeed();
}
