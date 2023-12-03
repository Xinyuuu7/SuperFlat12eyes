package SuperFlat12eyes.MC1_16_1;


import java.util.List;

public class StrongholdStart extends StructureStart {
    public boolean hasAccurateY = false;

    public StrongholdPieces.Stairs2 ProcessLayout(long structureSeed, int chunkX, int chunkZ, boolean stopAtPortal) {
        StrongholdPieces.Stairs2 starterStaircase;
        this.hasAccurateY = !stopAtPortal;
        int i = 0;

        do {
            this.components.clear();
            this.rand.setLargeFeatureSeed(structureSeed + i++, chunkX, chunkZ);

            starterStaircase = new StrongholdPieces.Stairs2(this.rand, (chunkX << 4) + 2, (chunkZ << 4) + 2);
            StrongholdPieces.prepareStructurePieces(starterStaircase);
            this.components.add(starterStaircase);
            starterStaircase.buildComponent(starterStaircase, this.components, this.rand);

            List<StructurePiece> list = starterStaircase.pendingChildren;
            while (!list.isEmpty()) {
                int j = this.rand.nextInt(list.size());
                StructurePiece structurepiece = list.remove(j);
                structurepiece.buildComponent(starterStaircase, this.components, this.rand);
                if (stopAtPortal && starterStaircase.strongholdPortalRoom != null)
                    return starterStaircase;
            }

            recalculateStructureSize();
            moveBelowSeaLevel(63, this.rand, 10);

        } while (this.components.isEmpty() || starterStaircase.strongholdPortalRoom == null);

        return starterStaircase;
    }

    public void printPieces() {
        for (StructurePiece piece : this.components) {
            System.out.println(piece + " " + piece.getBoundingBox().toString());
        }
    }
}
