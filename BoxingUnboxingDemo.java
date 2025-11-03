import java.util.*;

public class BoxingUnboxingDemo {
    public static void main(String[] args) {
        // 1) explicit boxing/unboxing
        int p = 5;
        Integer boxedExplicit = Integer.valueOf(p);   // explicit boxing
        int unboxedExplicit = boxedExplicit.intValue(); // explicit unboxing
        System.out.println("boxedExplicit = " + boxedExplicit + ", unboxedExplicit = " + unboxedExplicit);

        // 2) autoboxing / auto-unboxing
        Integer autoBoxed = p;           // autoboxing
        int autoUnboxed = autoBoxed;     // auto-unboxing
        System.out.println("autoBoxed = " + autoBoxed + ", autoUnboxed = " + autoUnboxed);

        // 3) Collections need wrappers (generics)
        List<Integer> list = new ArrayList<>();
        list.add(10);          // autoboxing from int -> Integer
        int fromList = list.get(0); // unboxing Integer -> int
        System.out.println("fromList = " + fromList);

        // 4) NullPointerException on unboxing null
        Integer maybeNull = null;
        try {
            int crash = maybeNull; // unboxing null -> NPE
        } catch (NullPointerException e) {
            System.out.println("Unboxing null causes NPE: " + e);
        }

        // 5) == vs .equals() and caching behaviour
        Integer a = 127;  // cached by Integer.valueOf (typically -128..127)
        Integer b = 127;
        System.out.println("127: a == b ? " + (a == b)); // usually true (cached)

        Integer c = 128;
        Integer d = 128;
        System.out.println("128: c == d ? " + (c == d)); // usually false (no cache)

        // new Integer(...) always creates new object
        Integer e1 = new Integer(1000);
        Integer e2 = new Integer(1000);
        System.out.println("new Integer equality: e1 == e2 ? " + (e1 == e2) + ", e1.equals(e2) ? " + e1.equals(e2));

        // 6) comparison between Integer and int: Integer is unboxed
        Integer big = 1000;
        int prim = 1000;
        System.out.println("Integer vs int: big == prim ? " + (big == prim)); // true: big unboxed

        // 7) Performance note demonstration (conceptual)
        // Avoid unnecessary boxing in tight loops; use primitive arrays or IntStream
        long start = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i; // primitives: no boxing
        }
        long end = System.nanoTime();
        System.out.println("Primitive loop took (ns): " + (end - start));
    }
}
