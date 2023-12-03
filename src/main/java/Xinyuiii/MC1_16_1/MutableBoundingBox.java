package SuperFlat12eyes.MC1_16_1;

public class MutableBoundingBox {
   public int minX;
   public int minY;
   public int minZ;

   public int maxX;
   public int maxY;
   public int maxZ;

   public static MutableBoundingBox getNewBoundingBox() {
      return new MutableBoundingBox(2147483647, 2147483647, 2147483647, -2147483648, -2147483648, -2147483648);
   }

   public static MutableBoundingBox getComponentToAddBoundingBox(int structureMinX, int structureMinY, int structureMinZ, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, Direction facing) {
      switch (facing) {
         case NORTH:
            return new MutableBoundingBox(structureMinX + xMin, structureMinY + yMin, structureMinZ - zMax + 1 + zMin, structureMinX + xMax - 1 + xMin, structureMinY + yMax - 1 + yMin, structureMinZ + zMin);
         case SOUTH:
            return new MutableBoundingBox(structureMinX + xMin, structureMinY + yMin, structureMinZ + zMin, structureMinX + xMax - 1 + xMin, structureMinY + yMax - 1 + yMin, structureMinZ + zMax - 1 + zMin);
         case WEST:
            return new MutableBoundingBox(structureMinX - zMax + 1 + zMin, structureMinY + yMin, structureMinZ + xMin, structureMinX + zMin, structureMinY + yMax - 1 + yMin, structureMinZ + xMax - 1 + xMin);
         case EAST:
            return new MutableBoundingBox(structureMinX + zMin, structureMinY + yMin, structureMinZ + xMin, structureMinX + zMax - 1 + zMin, structureMinY + yMax - 1 + yMin, structureMinZ + xMax - 1 + xMin);
         default:
            return new MutableBoundingBox(structureMinX + xMin, structureMinY + yMin, structureMinZ + zMin, structureMinX + xMax - 1 + xMin, structureMinY + yMax - 1 + yMin, structureMinZ + zMax - 1 + zMin);
      }
   }

   public MutableBoundingBox(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax) {
      this.minX = xMin;
      this.minY = yMin;
      this.minZ = zMin;
      this.maxX = xMax;
      this.maxY = yMax;
      this.maxZ = zMax;
   }

   public boolean intersectsWith(MutableBoundingBox structurebb) {
      return (this.maxX >= structurebb.minX && this.minX <= structurebb.maxX && this.maxZ >= structurebb.minZ && this.minZ <= structurebb.maxZ && this.maxY >= structurebb.minY && this.minY <= structurebb.maxY);
   }

   public boolean intersectsWith(int minXIn, int minZIn, int maxXIn, int maxZIn) {
      return (this.maxX >= minXIn && this.minX <= maxXIn && this.maxZ >= minZIn && this.minZ <= maxZIn);
   }

   public void expandTo(MutableBoundingBox sbb) {
      this.minX = Math.min(this.minX, sbb.minX);
      this.minY = Math.min(this.minY, sbb.minY);
      this.minZ = Math.min(this.minZ, sbb.minZ);
      this.maxX = Math.max(this.maxX, sbb.maxX);
      this.maxY = Math.max(this.maxY, sbb.maxY);
      this.maxZ = Math.max(this.maxZ, sbb.maxZ);
   }

   public void offset(int x, int y, int z) {
      this.minX += x;
      this.minY += y;
      this.minZ += z;
      this.maxX += x;
      this.maxY += y;
      this.maxZ += z;
   }

   public int getXSize() {
      return this.maxX - this.minX + 1;
   }

   public int getYSize() {
      return this.maxY - this.minY + 1;
   }

   public int getZSize() {
      return this.maxZ - this.minZ + 1;
   }

   public String toString() {
      return String.format("(%d,%d,%d),(%d,%d,%d)", this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
   }
}
