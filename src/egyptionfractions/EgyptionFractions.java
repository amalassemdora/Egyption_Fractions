
/*
*Programmer : Amal Assem Dora .
*experience :2 Years in Java programming language .
*Education : fourth year in computer science departement in faculty of electronic engineering (2019/2020).
*Egyption fractions code
 */

/*
n = ceil(4/3) = 2; remainder = 3/4 - 1/2 = 1/4
n = ceil(4) = 4; remainder = 1/4 - 1/4 = 0
3/4 = 1/2 + 1/4

And for 6/7:

n = ceil(7/6) = 2; remainder = 6/7 - 1/2 = 5/14
n = ceil(14/5) = 3; remainder = 5/14 - 1/3 = 1/42
n = ceil(42) = 42; remainder = 1/42 - 1/42 = 0
6/7 = 1/2 + 1/3 + 1/42
*/
package egyptionfractions;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EgyptionFractions {

    public static List<Integer> getDenominators(int numerator, int denominator) {
        List<Integer> denominatorList = new LinkedList<Integer>();

        int nr = numerator;
        int dr = denominator;

        while (dr % nr != 0) {
            // find the greatest possible unit fraction by finding the ceiling of dr / nr
            int ceiling = dr / nr + 1;
            denominatorList.add(ceiling);

            // nr/dr - 1 / ceiling = (ceiling * nr - dr) / (ceiling * dr)
            nr = nr * ceiling - dr;
            dr = dr * ceiling;
        }

        // last element nr / dr = 1 / (dr / nr)
        denominatorList.add(dr / nr);

        return denominatorList;
    }

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the numerator : ");
        int numerator = input.nextInt();
        System.out.println("Enter the denominator : ");
        int denominator = input.nextInt();

        List<Integer> denominatorList = getDenominators(numerator, denominator);
        int numOfDenominators = denominatorList.size();

        System.out.print("Egyptian Fractions of " + numerator + "/" + denominator + " are -->  ");
        System.out.print("1/" + denominatorList.get(0).toString());

        if (numOfDenominators > 1) {
            for (int i = 1; i < numOfDenominators; i++) {
                System.out.print(" + 1/" + denominatorList.get(i).toString());
            }
        }

        System.out.println();
    }
}
    
