package SuperFlat12eyes;

import com.seedfinding.latticg.util.LCG;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcreversal.ChunkRandomReverser;
import SuperFlat12eyes.MC1_16_1.StrongholdPieces;
import SuperFlat12eyes.MC1_16_1.StrongholdStart;
import SuperFlat12eyes.MC1_16_1.StructurePiece;

import java.util.Arrays;
import java.util.List;

public class StructureSeedGenerator {
    static List<CPos> STRONGHOLDSTART = Arrays.asList(new CPos(-13,-106), new CPos(128,55), new CPos(-106,79));

    public static void main(String[] args) {
        for (CPos start : STRONGHOLDSTART) {
            reverse(start.getX(),start.getZ());
        }
    }

    static void reverse(int startX,int startZ) {
        for (long eyeSeeds : SeedBank.populationSeeds) {
            for (int eyeChunkX = startX - 8 ; eyeChunkX <= startX + 8 ; eyeChunkX++) {
                for (int eyeChunkZ = startZ - 8 ; eyeChunkZ <= startZ + 8 ; eyeChunkZ++) {
                    long populationSeed = ChunkRandomReverser.reverseDecoratorSeed(eyeSeeds ^ LCG.JAVA.multiplier, 0, 5, MCVersion.v1_16_1);
                    List<Long> structureSeeds = ChunkRandomReverser.reversePopulationSeed(populationSeed, eyeChunkX << 4, eyeChunkZ << 4, MCVersion.v1_16_1);
                    for (long structureSeed : structureSeeds) {
                        StrongholdStart start = new StrongholdStart();
                        StrongholdPieces.Stairs2 stairs2piece = start.ProcessLayout(structureSeed, startX, startZ, true);
                        StrongholdPieces.PortalRoom portal = stairs2piece.strongholdPortalRoom;
                        int centerX = (portal.getBoundingBox().minX + portal.getBoundingBox().maxX) / 2;
                        int centerZ = (portal.getBoundingBox().minZ + portal.getBoundingBox().maxZ) / 2;
                        if (!CheckPositions(centerX, centerZ, eyeChunkX, eyeChunkZ))
                            continue;
                        int pieceNum = start.components.size();
                        for (int i = 0; i < pieceNum; i++) {
                            StructurePiece piece = start.components.get(i);
                            if (piece.getBoundingBox().intersectsWith(eyeChunkX << 4, eyeChunkZ << 4, (eyeChunkX << 4) + 15, (eyeChunkZ << 4) + 15)) {
                                if (piece == portal) {
                                    System.out.printf("%d %d %d\n", structureSeed, startX, startZ);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean CheckPositions(int centerX, int centerZ, int eyeChunkX, int eyeChunkZ) {
        for (int offX = -1; offX <= 1; offX++) {
            for (int offZ = -1; offZ <= 1; offZ++) {
                int chunkX = centerX + offX >> 4;
                int chunkZ = centerZ + offZ >> 4;
                if (chunkX == eyeChunkX && chunkZ == eyeChunkZ)
                    return true;
            }
        }
        return false;
    }
}
