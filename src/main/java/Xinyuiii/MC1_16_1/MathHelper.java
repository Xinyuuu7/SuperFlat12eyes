package SuperFlat12eyes.MC1_16_1;

public class MathHelper {
   private static final float[] SIN_TABLE;

   static {
      SIN_TABLE = Util.make(new float[65536], p_203445_0_ -> {
         for (int i = 0; i < p_203445_0_.length; i++)
            p_203445_0_[i] = (float)Math.sin(i * Math.PI * 2.0D / 65536.0D);
      });
   }

   private static final double[] ASINE_TAB = new double[257];
   private static final double[] COS_TAB = new double[257];

   public static int floor(double value) {
      int i = (int)value;
      return (value < i) ? (i - 1) : i;
   }

   static {
      for (int i = 0; i < 257; i++) {
         double d0 = i / 256.0D;
         double d1 = Math.asin(d0);
         COS_TAB[i] = Math.cos(d1);
         ASINE_TAB[i] = d1;
      }
   }
}
