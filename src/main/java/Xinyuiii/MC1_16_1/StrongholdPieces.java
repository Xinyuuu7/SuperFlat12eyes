package SuperFlat12eyes.MC1_16_1;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class StrongholdPieces {
   public static void prepareStructurePieces(Stairs2 stairs2piece) {
      PieceWeight[] PIECE_WEIGHTS = {
              new PieceWeight(Straight.class, 40, 0),
              new PieceWeight(Prison.class, 5, 5),
              new PieceWeight(LeftTurn.class, 20, 0),
              new PieceWeight(RightTurn.class, 20, 0),
              new PieceWeight(RoomCrossing.class, 10, 6),
              new PieceWeight(StairsStraight.class, 5, 5),
              new PieceWeight(Stairs.class, 5, 5),
              new PieceWeight(Crossing.class, 5, 4),
              new PieceWeight(ChestCorridor.class, 5, 4),
              new PieceWeight(Library.class, 10, 2) {
                 public boolean canSpawnMoreStructuresOfType(int p_75189_1_) {
                    return (super.canSpawnMoreStructuresOfType(p_75189_1_) && p_75189_1_ > 4);
                 }
              },
              new PieceWeight(PortalRoom.class, 20, 1) {
                 public boolean canSpawnMoreStructuresOfType(int p_75189_1_) {
                    return (super.canSpawnMoreStructuresOfType(p_75189_1_) && p_75189_1_ > 5);
                 }
              } };
      stairs2piece.structurePieceList = new ArrayList<>();
      byte b;
      int i;
      PieceWeight[] arrayOfPieceWeight1;
      for (i = (arrayOfPieceWeight1 = PIECE_WEIGHTS).length, b = 0; b < i; ) {
         PieceWeight strongholdpieces$pieceweight = arrayOfPieceWeight1[b];
         strongholdpieces$pieceweight.instancesSpawned = 0;
         stairs2piece.structurePieceList.add(strongholdpieces$pieceweight);
         b++;
      }
      stairs2piece.strongComponentType = null;
   }

   private static boolean canAddStructurePieces(Stairs2 stairs2piece) {
      boolean flag = false;
      stairs2piece.totalWeight = 0;
      for (PieceWeight strongholdpieces$pieceweight : stairs2piece.structurePieceList) {
         if (strongholdpieces$pieceweight.instancesLimit > 0 && strongholdpieces$pieceweight.instancesSpawned < strongholdpieces$pieceweight.instancesLimit)
            flag = true;
         stairs2piece.totalWeight += strongholdpieces$pieceweight.pieceWeight;
      }
      return flag;
   }

   private static Stronghold findAndCreatePieceFactory(Class<? extends Stronghold> clazz, List<StructurePiece> p_175954_1_, Random p_175954_2_, int p_175954_3_, int p_175954_4_, int p_175954_5_,  Direction p_175954_6_, int p_175954_7_) {
      Stronghold strongholdpieces$stronghold = null;
      if (clazz == Straight.class) {
         strongholdpieces$stronghold = Straight.createPiece(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if (clazz == Prison.class) {
         strongholdpieces$stronghold = Prison.createPiece(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if (clazz == LeftTurn.class) {
         strongholdpieces$stronghold = LeftTurn.createPiece(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if (clazz == RightTurn.class) {
         strongholdpieces$stronghold = RightTurn.func_214824_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if (clazz == RoomCrossing.class) {
         strongholdpieces$stronghold = RoomCrossing.createPiece(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if (clazz == StairsStraight.class) {
         strongholdpieces$stronghold = StairsStraight.createPiece(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if (clazz == Stairs.class) {
         strongholdpieces$stronghold = Stairs.createPiece(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if (clazz == Crossing.class) {
         strongholdpieces$stronghold = Crossing.createPiece(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if (clazz == ChestCorridor.class) {
         strongholdpieces$stronghold = ChestCorridor.createPiece(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if (clazz == Library.class) {
         strongholdpieces$stronghold = Library.createPiece(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if (clazz == PortalRoom.class) {
         strongholdpieces$stronghold = PortalRoom.createPiece(p_175954_1_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      }

      return strongholdpieces$stronghold;
   }

   private static Stronghold generatePieceFromSmallDoor(Stairs2 p_175955_0_, List<StructurePiece> p_175955_1_, Random p_175955_2_, int p_175955_3_, int p_175955_4_, int p_175955_5_, Direction p_175955_6_, int p_175955_7_) {
      if (!canAddStructurePieces(p_175955_0_)) {
         return null;
      } else {
         if (p_175955_0_.strongComponentType != null) {
            Stronghold strongholdpieces$stronghold = findAndCreatePieceFactory(p_175955_0_.strongComponentType, p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_, p_175955_7_);
            p_175955_0_.strongComponentType = null;
            if (strongholdpieces$stronghold != null) {
               return strongholdpieces$stronghold;
            }
         }

         int j = 0;

         while(j < 5) {
            ++j;
            int i = p_175955_2_.nextInt(p_175955_0_.totalWeight);
            for(PieceWeight strongholdpieces$pieceweight : p_175955_0_.structurePieceList) {
               i -= strongholdpieces$pieceweight.pieceWeight;
               if (i < 0) {
                  if (!strongholdpieces$pieceweight.canSpawnMoreStructuresOfType(p_175955_7_) || strongholdpieces$pieceweight == p_175955_0_.lastPlaced) {
                     break;
                  }

                  Stronghold strongholdpieces$stronghold1 = findAndCreatePieceFactory(strongholdpieces$pieceweight.pieceClass, p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_, p_175955_7_);
                  if (strongholdpieces$stronghold1 != null) {
                     ++strongholdpieces$pieceweight.instancesSpawned;
                     p_175955_0_.lastPlaced = strongholdpieces$pieceweight;
                     if (!strongholdpieces$pieceweight.canSpawnMoreStructures()) {
                        p_175955_0_.structurePieceList.remove(strongholdpieces$pieceweight);
                     }
                     return strongholdpieces$stronghold1;
                  }
               }
            }
         }

         MutableBoundingBox mutableboundingbox = Corridor.findPieceBox(p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_);
         return mutableboundingbox != null && mutableboundingbox.minY > 1 ? new Corridor(p_175955_7_, mutableboundingbox, p_175955_6_) : null;
      }
   }

   private static StructurePiece generateAndAddPiece(Stairs2 p_175953_0_, List<StructurePiece> p_175953_1_, Random p_175953_2_, int p_175953_3_, int p_175953_4_, int p_175953_5_,  Direction p_175953_6_, int p_175953_7_) {
      if (p_175953_7_ > 50) {
         return null;
      } else if (Math.abs(p_175953_3_ - p_175953_0_.getBoundingBox().minX) <= 112 && Math.abs(p_175953_5_ - p_175953_0_.getBoundingBox().minZ) <= 112) {
         StructurePiece structurepiece = generatePieceFromSmallDoor(p_175953_0_, p_175953_1_, p_175953_2_, p_175953_3_, p_175953_4_, p_175953_5_, p_175953_6_, p_175953_7_ + 1);
         if (structurepiece != null) {
            p_175953_1_.add(structurepiece);
            p_175953_0_.pendingChildren.add(structurepiece);
         }

         return structurepiece;
      } else {
         return null;
      }
   }

   public static class ChestCorridor extends Stronghold {
      public ChestCorridor(int p_i45582_1_, Random p_i45582_2_, MutableBoundingBox p_i45582_3_, Direction p_i45582_4_) {
         super(p_i45582_1_);
         this.setCoordBaseMode(p_i45582_4_);
         this.entryDoor = this.getRandomDoor(p_i45582_2_);
         this.boundingBox = p_i45582_3_;
      }

      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 1, 1);
      }

      public static ChestCorridor createPiece(List<StructurePiece> p_175868_0_, Random p_175868_1_, int p_175868_2_, int p_175868_3_, int p_175868_4_, Direction p_175868_5_, int p_175868_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175868_2_, p_175868_3_, p_175868_4_, -1, -1, 0, 5, 5, 7, p_175868_5_);
         return canStrongholdGoDeeper(mutableboundingbox) && StructurePiece.findIntersecting(p_175868_0_, mutableboundingbox) == null ? new ChestCorridor(p_175868_6_, p_175868_1_, mutableboundingbox, p_175868_5_) : null;
      }
   }

   public static class Corridor extends Stronghold {
      private final int steps;

      public Corridor(int p_i50137_1_, MutableBoundingBox p_i50137_2_, Direction p_i50137_3_) {
         super(p_i50137_1_);
         this.setCoordBaseMode(p_i50137_3_);
         this.boundingBox = p_i50137_2_;
         this.steps = p_i50137_3_ != Direction.NORTH && p_i50137_3_ != Direction.SOUTH ? p_i50137_2_.getXSize() : p_i50137_2_.getZSize();
      }

      public static MutableBoundingBox findPieceBox(List<StructurePiece> p_175869_0_, Random p_175869_1_, int p_175869_2_, int p_175869_3_, int p_175869_4_, Direction p_175869_5_) {
         int i = 3;
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, 4, p_175869_5_);
         StructurePiece structurepiece = StructurePiece.findIntersecting(p_175869_0_, mutableboundingbox);
         if (structurepiece == null) {
            return null;
         } else {
            if (structurepiece.getBoundingBox().minY == mutableboundingbox.minY) {
               for(int j = 3; j >= 1; --j) {
                  mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, j - 1, p_175869_5_);
                  if (!structurepiece.getBoundingBox().intersectsWith(mutableboundingbox)) {
                     return MutableBoundingBox.getComponentToAddBoundingBox(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, j, p_175869_5_);
                  }
               }
            }

            return null;
         }
      }
   }

   public static class Crossing extends Stronghold {
      private final boolean leftLow;
      private final boolean leftHigh;
      private final boolean rightLow;
      private final boolean rightHigh;

      public Crossing(int p_i45580_1_, Random p_i45580_2_, MutableBoundingBox p_i45580_3_, Direction p_i45580_4_) {
         super(p_i45580_1_);
         this.setCoordBaseMode(p_i45580_4_);
         this.entryDoor = this.getRandomDoor(p_i45580_2_);
         this.boundingBox = p_i45580_3_;
         this.leftLow = p_i45580_2_.nextBoolean();
         this.leftHigh = p_i45580_2_.nextBoolean();
         this.rightLow = p_i45580_2_.nextBoolean();
         this.rightHigh = p_i45580_2_.nextInt(3) > 0;
      }

      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         int i = 3;
         int j = 5;
         Direction direction = this.getCoordBaseMode();
         if (direction == Direction.WEST || direction == Direction.NORTH) {
            i = 8 - i;
            j = 8 - j;
         }

         this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 5, 1);
         if (this.leftLow) {
            this.getNextComponentX((Stairs2)componentIn, listIn, rand, i, 1);
         }

         if (this.leftHigh) {
            this.getNextComponentX((Stairs2)componentIn, listIn, rand, j, 7);
         }

         if (this.rightLow) {
            this.getNextComponentZ((Stairs2)componentIn, listIn, rand, i, 1);
         }

         if (this.rightHigh) {
            this.getNextComponentZ((Stairs2)componentIn, listIn, rand, j, 7);
         }

      }

      public static Crossing createPiece(List<StructurePiece> p_175866_0_, Random p_175866_1_, int p_175866_2_, int p_175866_3_, int p_175866_4_, Direction p_175866_5_, int p_175866_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175866_2_, p_175866_3_, p_175866_4_, -4, -3, 0, 10, 9, 11, p_175866_5_);
         return canStrongholdGoDeeper(mutableboundingbox) && StructurePiece.findIntersecting(p_175866_0_, mutableboundingbox) == null ? new Crossing(p_175866_6_, p_175866_1_, mutableboundingbox, p_175866_5_) : null;
      }
   }

   public static class LeftTurn extends Turn {
      public LeftTurn(int p_i45579_1_, Random p_i45579_2_, MutableBoundingBox p_i45579_3_, Direction p_i45579_4_) {
         super(p_i45579_1_);
         this.setCoordBaseMode(p_i45579_4_);
         this.entryDoor = this.getRandomDoor(p_i45579_2_);
         this.boundingBox = p_i45579_3_;
      }

      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         Direction direction = this.getCoordBaseMode();
         if (direction != Direction.NORTH && direction != Direction.EAST) {
            this.getNextComponentZ((Stairs2)componentIn, listIn, rand, 1, 1);
         } else {
            this.getNextComponentX((Stairs2)componentIn, listIn, rand, 1, 1);
         }

      }

      public static LeftTurn createPiece(List<StructurePiece> p_175867_0_, Random p_175867_1_, int p_175867_2_, int p_175867_3_, int p_175867_4_, Direction p_175867_5_, int p_175867_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175867_2_, p_175867_3_, p_175867_4_, -1, -1, 0, 5, 5, 5, p_175867_5_);
         return canStrongholdGoDeeper(mutableboundingbox) && StructurePiece.findIntersecting(p_175867_0_, mutableboundingbox) == null ? new LeftTurn(p_175867_6_, p_175867_1_, mutableboundingbox, p_175867_5_) : null;
      }
   }

   public static class Library extends Stronghold {
      private final boolean isLargeRoom;

      public Library(int p_i45578_1_, Random p_i45578_2_, MutableBoundingBox p_i45578_3_, Direction p_i45578_4_) {
         super(p_i45578_1_);
         this.setCoordBaseMode(p_i45578_4_);
         this.entryDoor = this.getRandomDoor(p_i45578_2_);
         this.boundingBox = p_i45578_3_;
         this.isLargeRoom = p_i45578_3_.getYSize() > 6;
      }

      public static Library createPiece(List<StructurePiece> p_175864_0_, Random p_175864_1_, int p_175864_2_, int p_175864_3_, int p_175864_4_, Direction p_175864_5_, int p_175864_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175864_2_, p_175864_3_, p_175864_4_, -4, -1, 0, 14, 11, 15, p_175864_5_);
         if (!canStrongholdGoDeeper(mutableboundingbox) || StructurePiece.findIntersecting(p_175864_0_, mutableboundingbox) != null) {
            mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175864_2_, p_175864_3_, p_175864_4_, -4, -1, 0, 14, 6, 15, p_175864_5_);
            if (!canStrongholdGoDeeper(mutableboundingbox) || StructurePiece.findIntersecting(p_175864_0_, mutableboundingbox) != null) {
               return null;
            }
         }

         return new Library(p_175864_6_, p_175864_1_, mutableboundingbox, p_175864_5_);
      }
   }

   static class PieceWeight {
      public final Class<? extends Stronghold> pieceClass;
      public final int pieceWeight;
      public int instancesSpawned;
      public final int instancesLimit;

      public PieceWeight(Class<? extends Stronghold> p_i2076_1_, int p_i2076_2_, int p_i2076_3_) {
         this.pieceClass = p_i2076_1_;
         this.pieceWeight = p_i2076_2_;
         this.instancesLimit = p_i2076_3_;
      }

      public boolean canSpawnMoreStructuresOfType(int p_75189_1_) {
         return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
      }

      public boolean canSpawnMoreStructures() {
         return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
      }
   }

   public static class PortalRoom extends Stronghold {

      public PortalRoom(int p_i50131_1_, MutableBoundingBox p_i50131_2_, Direction p_i50131_3_) {
         super(p_i50131_1_);
         this.setCoordBaseMode(p_i50131_3_);
         this.boundingBox = p_i50131_2_;
      }

      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         if (componentIn != null) {
            ((Stairs2)componentIn).strongholdPortalRoom = this;
         }

      }

      public static PortalRoom createPiece(List<StructurePiece> p_175865_0_, int p_175865_1_, int p_175865_2_, int p_175865_3_, Direction p_175865_4_, int p_175865_5_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175865_1_, p_175865_2_, p_175865_3_, -4, -1, 0, 11, 8, 16, p_175865_4_);
         return canStrongholdGoDeeper(mutableboundingbox) && StructurePiece.findIntersecting(p_175865_0_, mutableboundingbox) == null ? new PortalRoom(p_175865_5_, mutableboundingbox, p_175865_4_) : null;
      }
   }

   public static class Prison extends Stronghold {
      public Prison(int p_i45576_1_, Random p_i45576_2_, MutableBoundingBox p_i45576_3_, Direction p_i45576_4_) {
         super(p_i45576_1_);
         this.setCoordBaseMode(p_i45576_4_);
         this.entryDoor = this.getRandomDoor(p_i45576_2_);
         this.boundingBox = p_i45576_3_;
      }

      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 1, 1);
      }

      public static Prison createPiece(List<StructurePiece> p_175860_0_, Random p_175860_1_, int p_175860_2_, int p_175860_3_, int p_175860_4_, Direction p_175860_5_, int p_175860_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175860_2_, p_175860_3_, p_175860_4_, -1, -1, 0, 9, 5, 11, p_175860_5_);
         return canStrongholdGoDeeper(mutableboundingbox) && StructurePiece.findIntersecting(p_175860_0_, mutableboundingbox) == null ? new Prison(p_175860_6_, p_175860_1_, mutableboundingbox, p_175860_5_) : null;
      }
   }

   public static class RightTurn extends Turn {
      public RightTurn(int p_i50127_1_, Random p_i50127_2_, MutableBoundingBox p_i50127_3_, Direction p_i50127_4_) {
         super(p_i50127_1_);
         this.setCoordBaseMode(p_i50127_4_);
         this.entryDoor = this.getRandomDoor(p_i50127_2_);
         this.boundingBox = p_i50127_3_;
      }

      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         Direction direction = this.getCoordBaseMode();
         if (direction != Direction.NORTH && direction != Direction.EAST) {
            this.getNextComponentX((Stairs2)componentIn, listIn, rand, 1, 1);
         } else {
            this.getNextComponentZ((Stairs2)componentIn, listIn, rand, 1, 1);
         }

      }

      public static RightTurn func_214824_a(List<StructurePiece> p_214824_0_, Random p_214824_1_, int p_214824_2_, int p_214824_3_, int p_214824_4_, Direction p_214824_5_, int p_214824_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_214824_2_, p_214824_3_, p_214824_4_, -1, -1, 0, 5, 5, 5, p_214824_5_);
         return canStrongholdGoDeeper(mutableboundingbox) && StructurePiece.findIntersecting(p_214824_0_, mutableboundingbox) == null ? new RightTurn(p_214824_6_, p_214824_1_, mutableboundingbox, p_214824_5_) : null;
      }
   }

   public static class RoomCrossing extends Stronghold {
      protected final int roomType;

      public RoomCrossing(int p_i45575_1_, Random p_i45575_2_, MutableBoundingBox p_i45575_3_, Direction p_i45575_4_) {
         super(p_i45575_1_);
         this.setCoordBaseMode(p_i45575_4_);
         this.entryDoor = this.getRandomDoor(p_i45575_2_);
         this.boundingBox = p_i45575_3_;
         this.roomType = p_i45575_2_.nextInt(5);
      }

      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 4, 1);
         this.getNextComponentX((Stairs2)componentIn, listIn, rand, 1, 4);
         this.getNextComponentZ((Stairs2)componentIn, listIn, rand, 1, 4);
      }

      public static RoomCrossing createPiece(List<StructurePiece> p_175859_0_, Random p_175859_1_, int p_175859_2_, int p_175859_3_, int p_175859_4_, Direction p_175859_5_, int p_175859_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175859_2_, p_175859_3_, p_175859_4_, -4, -1, 0, 11, 7, 11, p_175859_5_);
         return canStrongholdGoDeeper(mutableboundingbox) && StructurePiece.findIntersecting(p_175859_0_, mutableboundingbox) == null ? new RoomCrossing(p_175859_6_, p_175859_1_, mutableboundingbox, p_175859_5_) : null;
      }
   }

   public static class Stairs extends Stronghold {
      private final boolean source;

      public Stairs(int p_i50120_2_, Random p_i50120_3_, int p_i50120_4_, int p_i50120_5_) {
         super(p_i50120_2_);
         this.source = true;
         this.setCoordBaseMode(Direction.Plane.HORIZONTAL.random(p_i50120_3_));
         this.entryDoor = Door.OPENING;
         if (this.getCoordBaseMode().getAxis() == Direction.Axis.Z) {
            this.boundingBox = new MutableBoundingBox(p_i50120_4_, 64, p_i50120_5_, p_i50120_4_ + 5 - 1, 74, p_i50120_5_ + 5 - 1);
         } else {
            this.boundingBox = new MutableBoundingBox(p_i50120_4_, 64, p_i50120_5_, p_i50120_4_ + 5 - 1, 74, p_i50120_5_ + 5 - 1);
         }
      }

      public Stairs(int p_i45574_1_, Random p_i45574_2_, MutableBoundingBox p_i45574_3_, Direction p_i45574_4_) {
         super(p_i45574_1_);
         this.source = false;
         this.setCoordBaseMode(p_i45574_4_);
         this.entryDoor = this.getRandomDoor(p_i45574_2_);
         this.boundingBox = p_i45574_3_;
      }

      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         if (this.source) {
            ((Stairs2)componentIn).strongComponentType = Crossing.class;
         }

         this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 1, 1);
      }

      public static Stairs createPiece(List<StructurePiece> p_175863_0_, Random p_175863_1_, int p_175863_2_, int p_175863_3_, int p_175863_4_, Direction p_175863_5_, int p_175863_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175863_2_, p_175863_3_, p_175863_4_, -1, -7, 0, 5, 11, 5, p_175863_5_);
         return canStrongholdGoDeeper(mutableboundingbox) && StructurePiece.findIntersecting(p_175863_0_, mutableboundingbox) == null ? new Stairs(p_175863_6_, p_175863_1_, mutableboundingbox, p_175863_5_) : null;
      }
   }

   public static class Stairs2 extends Stairs {
      public List<PieceWeight> structurePieceList;
      public Class<? extends Stronghold> strongComponentType;
      public int totalWeight;
      public PieceWeight lastPlaced;

      public StrongholdPieces.PortalRoom strongholdPortalRoom;
      public final List<StructurePiece> pendingChildren = new ArrayList<>();

      public Stairs2(Random p_i50117_1_, int p_i50117_2_, int p_i50117_3_) {
         super(0, p_i50117_1_, p_i50117_2_, p_i50117_3_);
      }
   }

   public static class StairsStraight extends Stronghold {
      public StairsStraight(int p_i45572_1_, Random p_i45572_2_, MutableBoundingBox p_i45572_3_, Direction p_i45572_4_) {
         super(p_i45572_1_);
         this.setCoordBaseMode(p_i45572_4_);
         this.entryDoor = this.getRandomDoor(p_i45572_2_);
         this.boundingBox = p_i45572_3_;
      }

      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 1, 1);
      }

      public static StairsStraight createPiece(List<StructurePiece> p_175861_0_, Random p_175861_1_, int p_175861_2_, int p_175861_3_, int p_175861_4_, Direction p_175861_5_, int p_175861_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175861_2_, p_175861_3_, p_175861_4_, -1, -7, 0, 5, 11, 8, p_175861_5_);
         return canStrongholdGoDeeper(mutableboundingbox) && StructurePiece.findIntersecting(p_175861_0_, mutableboundingbox) == null ? new StairsStraight(p_175861_6_, p_175861_1_, mutableboundingbox, p_175861_5_) : null;
      }
   }
   public static class Straight extends Stronghold {
      private final boolean expandsX;
      private final boolean expandsZ;

      public Straight(int p_i45573_1_, Random p_i45573_2_, MutableBoundingBox p_i45573_3_, Direction p_i45573_4_) {
         super(p_i45573_1_);
         this.setCoordBaseMode(p_i45573_4_);
         this.entryDoor = this.getRandomDoor(p_i45573_2_);
         this.boundingBox = p_i45573_3_;
         this.expandsX = p_i45573_2_.nextInt(2) == 0;
         this.expandsZ = p_i45573_2_.nextInt(2) == 0;
      }

      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((Stairs2)componentIn, listIn, rand, 1, 1);
         if (this.expandsX) {
            this.getNextComponentX((Stairs2)componentIn, listIn, rand, 1, 2);
         }

         if (this.expandsZ) {
            this.getNextComponentZ((Stairs2)componentIn, listIn, rand, 1, 2);
         }

      }

      public static Straight createPiece(List<StructurePiece> p_175862_0_, Random p_175862_1_, int p_175862_2_, int p_175862_3_, int p_175862_4_, Direction p_175862_5_, int p_175862_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175862_2_, p_175862_3_, p_175862_4_, -1, -1, 0, 5, 5, 7, p_175862_5_);
         return canStrongholdGoDeeper(mutableboundingbox) && StructurePiece.findIntersecting(p_175862_0_, mutableboundingbox) == null ? new Straight(p_175862_6_, p_175862_1_, mutableboundingbox, p_175862_5_) : null;
      }
   }

   abstract static class Stronghold extends StructurePiece {
      protected Door entryDoor = Door.OPENING;

      protected Stronghold(int p_i50110_2_) {
         super(p_i50110_2_);
      }

      protected Door getRandomDoor(Random p_74988_1_) {
         int i = p_74988_1_.nextInt(5);
         switch(i) {
            case 0:
            case 1:
            default:
               return Door.OPENING;
            case 2:
               return Door.WOOD_DOOR;
            case 3:
               return Door.GRATES;
            case 4:
               return Door.IRON_DOOR;
         }
      }


      protected StructurePiece getNextComponentNormal(Stairs2 p_74986_1_, List<StructurePiece> p_74986_2_, Random p_74986_3_, int p_74986_4_, int p_74986_5_) {
         Direction direction = this.getCoordBaseMode();
         if (direction != null) {
            switch(direction) {
               case NORTH:
                  return StrongholdPieces.generateAndAddPiece(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX + p_74986_4_, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ - 1, direction, this.getComponentType());
               case SOUTH:
                  return StrongholdPieces.generateAndAddPiece(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX + p_74986_4_, this.boundingBox.minY + p_74986_5_, this.boundingBox.maxZ + 1, direction, this.getComponentType());
               case WEST:
                  return StrongholdPieces.generateAndAddPiece(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ + p_74986_4_, direction, this.getComponentType());
               case EAST:
                  return StrongholdPieces.generateAndAddPiece(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ + p_74986_4_, direction, this.getComponentType());
               default:
                  return null;
            }
         }
         return null;
      }


      protected StructurePiece getNextComponentX(Stairs2 p_74989_1_, List<StructurePiece> p_74989_2_, Random p_74989_3_, int p_74989_4_, int p_74989_5_) {
         Direction direction = this.getCoordBaseMode();
         if (direction != null) {
            switch(direction) {
               case NORTH:
                  return StrongholdPieces.generateAndAddPiece(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ + p_74989_5_, Direction.WEST, this.getComponentType());
               case SOUTH:
                  return StrongholdPieces.generateAndAddPiece(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ + p_74989_5_, Direction.WEST, this.getComponentType());
               case WEST:
                  return StrongholdPieces.generateAndAddPiece(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX + p_74989_5_, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ - 1, Direction.NORTH, this.getComponentType());
               case EAST:
                  return StrongholdPieces.generateAndAddPiece(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX + p_74989_5_, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ - 1, Direction.NORTH, this.getComponentType());
               default:
                  return null;
            }
         }

         return null;
      }


      protected StructurePiece getNextComponentZ(Stairs2 p_74987_1_, List<StructurePiece> p_74987_2_, Random p_74987_3_, int p_74987_4_, int p_74987_5_) {
         Direction direction = this.getCoordBaseMode();
         if (direction != null) {
            switch(direction) {
               case NORTH:
                  return StrongholdPieces.generateAndAddPiece(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74987_4_, this.boundingBox.minZ + p_74987_5_, Direction.EAST, this.getComponentType());
               case SOUTH:
                  return StrongholdPieces.generateAndAddPiece(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74987_4_, this.boundingBox.minZ + p_74987_5_, Direction.EAST, this.getComponentType());
               case WEST:
                  return StrongholdPieces.generateAndAddPiece(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.minX + p_74987_5_, this.boundingBox.minY + p_74987_4_, this.boundingBox.maxZ + 1, Direction.SOUTH, this.getComponentType());
               case EAST:
                  return StrongholdPieces.generateAndAddPiece(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.minX + p_74987_5_, this.boundingBox.minY + p_74987_4_, this.boundingBox.maxZ + 1, Direction.SOUTH, this.getComponentType());
               default:
                  return null;
            }
         }

         return null;
      }

      protected static boolean canStrongholdGoDeeper(MutableBoundingBox p_74991_0_) {
         return p_74991_0_ != null && p_74991_0_.minY > 10;
      }

      public enum Door {
         OPENING,
         WOOD_DOOR,
         GRATES,
         IRON_DOOR
      }
   }

   public abstract static class Turn extends Stronghold {
      protected Turn(int p_i50108_2_) {
         super(p_i50108_2_);
      }
   }
}
