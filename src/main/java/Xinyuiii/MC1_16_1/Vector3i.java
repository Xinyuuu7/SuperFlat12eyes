package SuperFlat12eyes.MC1_16_1;

public class Vector3i implements Comparable<Vector3i> {
   private int x;
   private int y;
   private int z;

   public Vector3i(int xIn, int yIn, int zIn) {
      this.x = xIn;
      this.y = yIn;
      this.z = zIn;
   }

   public boolean equals(Object p_equals_1_) {
      if (this == p_equals_1_)
         return true;
      if (!(p_equals_1_ instanceof Vector3i))
         return false;
      Vector3i vector3i = (Vector3i)p_equals_1_;
      if (getX() != vector3i.getX())
         return false;
      if (getY() != vector3i.getY())
         return false;
      return (getZ() == vector3i.getZ());
   }

   public int hashCode() {
      return (getY() + getZ() * 31) * 31 + getX();
   }

   public int compareTo(Vector3i p_compareTo_1_) {
      if (getY() == p_compareTo_1_.getY())
         return (getZ() == p_compareTo_1_.getZ()) ? (getX() - p_compareTo_1_.getX()) : (getZ() - p_compareTo_1_.getZ());
      return getY() - p_compareTo_1_.getY();
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public int getZ() {
      return this.z;
   }
}
