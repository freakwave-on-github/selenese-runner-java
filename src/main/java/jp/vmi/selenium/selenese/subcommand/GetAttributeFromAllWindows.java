// This code is based on:
//
//   com.thoughtworks.selenium.webdriven.commands.GetAttributeFromAllWindows
//
// in Selenium WebDriver.
//
// The following copyright is copied from original.
// ---
// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package jp.vmi.selenium.selenese.subcommand;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import jp.vmi.selenium.selenese.Context;
import jp.vmi.selenium.selenese.command.ArgumentType;

/**
 * Re-implementation of GetAttributeFromAllWindows.
 */
public class GetAttributeFromAllWindows extends AbstractSubCommand<String[]> {

    private static final int ARG_ATTR_NAME = 0;

    /**
     * Constructor.
     */
    public GetAttributeFromAllWindows() {
        super(ArgumentType.VALUE);
    }

    @Override
    public String[] execute(Context context, String... args) {
        String attrName = args[ARG_ATTR_NAME];
        WebDriver driver = context.getWrappedDriver();
        String current = driver.getWindowHandle();
        try {
            return driver.getWindowHandles().stream()
                .map(handle -> {
                    driver.switchTo().window(handle);
                    return ((JavascriptExecutor) driver).executeScript("return '' + window[arguments[0]];", attrName);
                })
                .toArray(String[]::new);
        } finally {
            driver.switchTo().window(current);
        }
    }
}
