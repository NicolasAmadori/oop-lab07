package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    public enum Month {
        JANUARY("JANUARY",31),
        FEBRUARY("FEBRUARY",28), 
        MARCH("MARCH", 31), 
        APRIL("APRIL", 30), 
        MAY("MAY", 31), 
        JUNE("JUNE", 30), 
        JULY("JULY", 31), 
        AUGUST("AUGUST", 31), 
        SEPTEMBER("SEPTEMBER", 30), 
        OCTOBER("OCTOBER", 31), 
        NOVEMBER("NOVEMBER", 30), 
        DECEMBER("DECEMBER", 31);

        private final String name;
        private final int daysNumber;

        private Month(final String name, final int daysNumber) {
            this.name = name;
            this.daysNumber = daysNumber;
        }

        public String getName() {
            return this.name;
        }

        public int getDaysNumber() {
            return this.daysNumber;
        }

        public static Month fromString(String name) throws IllegalArgumentException{
            int matchCounter = 0;
            Month match = null;

            for (Month m : Month.values()) {
                if(m.getName().startsWith(name.toUpperCase())){
                    matchCounter++;
                    match = m;
                }
            }
            
            if(matchCounter > 1) throw new IllegalArgumentException("String match with multiple months, ambigous");
            if(matchCounter < 1) throw new IllegalArgumentException("Input string do not match with any month");
            return match;
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            
            @Override
            public int compare(String s1, String s2){
                Month m1 = null, m2 = null;
                m1 = Month.fromString(s1);
                m2 = Month.fromString(s2);

                return Integer.compare(m1.getDaysNumber(), m2.getDaysNumber());
            };
        };            
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {
            
            @Override
            public int compare(String s1, String s2){
                int indexM1 = -1, indexM2 = -1;
                Month m1 = null, m2 = null;
                m1 = Month.fromString(s1);
                m2 = Month.fromString(s2);

                for (int i = 0; i < Month.values().length; i++) {
                    if(Month.values()[i] == m1) indexM1 = i;
                    else if(Month.values()[i] == m2) indexM2 = i;
                }
                return Integer.compare(indexM1, indexM2);
            };
        };   
    }
}
