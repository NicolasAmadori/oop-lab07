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

        public Month fromString(String name){
            for (Month m : this.values()) {
                if(m.getName().contains(name.toUpperCase())) return m;
            }
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
