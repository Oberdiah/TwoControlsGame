package printer;

/**
 * Created by Oberdiah on 22/07/2017.
 */
public class P {
    public static void p(Object o) {System.out.println(o);}
    public static void d(Object o) {if (EBUG) {System.out.println(o);}}
    public static boolean EBUG  = true;
}
