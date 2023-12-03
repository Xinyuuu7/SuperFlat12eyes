package SuperFlat12eyes.MC1_16_1;

import java.util.Random;
import java.util.function.Consumer;

public class Util {
   public static <T> T make(T object, Consumer<T> consumer) {
      consumer.accept(object);
      return object;
   }

   public static <T> T getRandomObject(Object[] array, Random rand) {
      return (T)array[rand.nextInt(array.length)];
   }
}
