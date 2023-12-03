package SuperFlat12eyes.MC1_16_1;

import java.util.Random;

public class SharedSeedRandom extends Random {

   public SharedSeedRandom() {
   }

   protected int next(int p_next_1_) {
      return super.next(p_next_1_);
   }

   public long setLargeFeatureSeed(long seed, int x, int z) {
      this.setSeed(seed);
      long i = this.nextLong();
      long j = this.nextLong();
      long k = (long)x * i ^ (long)z * j ^ seed;
      this.setSeed(k);
      return k;
   }
}
