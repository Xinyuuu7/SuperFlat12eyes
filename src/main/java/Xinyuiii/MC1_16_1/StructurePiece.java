package SuperFlat12eyes.MC1_16_1;

import java.util.List;
import java.util.Random;

public abstract class StructurePiece {
   protected MutableBoundingBox boundingBox;

   private Direction coordBaseMode;
   protected int componentType;
   protected StructurePiece(int componentTypeIn) {
      this.componentType = componentTypeIn;
   }

   public MutableBoundingBox getBoundingBox() {
      return this.boundingBox;
   }

   public Direction getCoordBaseMode() {
      return this.coordBaseMode;
   }

   public int getComponentType() {
      return this.componentType;
   }

   public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
   }

   public void offset(int x, int y, int z) {
      this.boundingBox.offset(x, y, z);
   }

   public void setCoordBaseMode(Direction facing) {
      this.coordBaseMode = facing;
   }

   public static StructurePiece findIntersecting(List<StructurePiece> listIn, MutableBoundingBox boundingboxIn) {
      for(StructurePiece structurepiece : listIn) {
         if (structurepiece.getBoundingBox() != null && structurepiece.getBoundingBox().intersectsWith(boundingboxIn)) {
            return structurepiece;
         }
      }

      return null;
   }
}