package SuperFlat12eyes.MC1_16_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class StructureStart {
   public final List<StructurePiece> components = new ArrayList<>();
   protected MutableBoundingBox bounds;
   protected final SharedSeedRandom rand = new SharedSeedRandom();

   protected void recalculateStructureSize() {
      this.bounds = MutableBoundingBox.getNewBoundingBox();

      for (StructurePiece structurepiece : this.components) {
         this.bounds.expandTo(structurepiece.getBoundingBox());
      }

   }

   protected void moveBelowSeaLevel(int seaLevel, Random jrand, int deltaY) {
      int i = seaLevel - deltaY;
      int j = this.bounds.getYSize() + 1;
      if (j < i) {
         j += jrand.nextInt(i - j);
      }

      int k = j - this.bounds.maxY;
      this.bounds.offset(0, k, 0);

      for (StructurePiece structurepiece : this.components) {
         structurepiece.offset(0, k, 0);
      }

   }
}