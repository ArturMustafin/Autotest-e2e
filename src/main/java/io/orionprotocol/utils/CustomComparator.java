package io.orionprotocol.utils;

import java.util.Comparator;

public class CustomComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        Integer i1 = null;
        Integer i2 = null;
        try {
            i1 = Integer.parseInt(s1);
        } catch (NumberFormatException ignored) {
        }

        try {
            i2 = Integer.parseInt(s2);
        } catch (NumberFormatException ignored) {
        }

        if (i1 != null && i2 != null) {
            return i1.compareTo(i2);
        } else {
            return s1.compareTo(s2);
        }
    }

}
