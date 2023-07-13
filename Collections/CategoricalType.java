import java.util.EnumSet;
import java.util.Set;

/**
 * @Author : Saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 13/07/2023
 */

/*
 * enum days contains days 
 */
enum days{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

/*
 * The CategoricalType class creates the set specified in the instance
 */
public class CategoricalType {
    public static void main(String[] args) {
        //creates a weekend set
        Set<days> weekend = EnumSet.of(days.SATURDAY, days.SUNDAY);

        System.out.println(weekend);

        //creates the allDays set
        Set<days> allDays = EnumSet.allOf(days.class);

        System.out.println(allDays);
    }
}