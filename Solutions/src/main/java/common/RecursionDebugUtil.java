/**
 * @author Everett
 * @date 6/29/2021 9:34 AM
 */
package common;

import java.util.Collection;

public class RecursionDebugUtil {
    public static void printIndent(int n) {
        for (int i = 0; i < n; i++) System.out.print("-");
    }

    public static void printCollection(String stack, Collection collection, boolean newline) {
        System.out.print(stack + "[");
        collection.stream().forEach(x -> System.out.print(x + " "));
        System.out.print("]");
        if (newline) System.out.println();
    }
}
