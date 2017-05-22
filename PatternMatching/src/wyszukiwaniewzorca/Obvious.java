
package wyszukiwaniewzorca;


public class Obvious {
    
    public static void Obvious(String wzorzec, String lancuch) {
        int n = lancuch.length();
        int m = wzorzec.length();
        int i;
        for (i = 0; i < n - m + 1; i++) {

            if (wzorzec.equals(lancuch.subSequence(i, m + i))) {
               //System.out.println(i + 1);
            }

        }

    }
    
}
