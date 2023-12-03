package SuperFlat12eyes.MC1_16_1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum Direction {
   DOWN(0, 1, -1, "down", AxisDirection.NEGATIVE, Axis.Y, new Vector3i(0, -1, 0)),
   UP(1, 0, -1, "up", AxisDirection.POSITIVE, Axis.Y, new Vector3i(0, 1, 0)),
   NORTH(2, 3, 2, "north", AxisDirection.NEGATIVE, Axis.Z, new Vector3i(0, 0, -1)),
   SOUTH(3, 2, 0, "south", AxisDirection.POSITIVE, Axis.Z, new Vector3i(0, 0, 1)),
   WEST(4, 5, 1, "west", AxisDirection.NEGATIVE, Axis.X, new Vector3i(-1, 0, 0)),
   EAST(5, 4, 3, "east", AxisDirection.POSITIVE, Axis.X, new Vector3i(1, 0, 0));

   private final int index;

   private final int horizontalIndex;

   private final String name;

   private final Axis axis;

   private final AxisDirection axisDirection;

   private final Vector3i directionVec;

   private static final Direction[] VALUES;

   static {
      VALUES = values();
   }

   Direction(int indexIn, int oppositeIn, int horizontalIndexIn, String nameIn, AxisDirection axisDirectionIn, Axis axisIn, Vector3i directionVecIn) {
      this.index = indexIn;
      this.horizontalIndex = horizontalIndexIn;
      this.name = nameIn;
      this.axis = axisIn;
      this.axisDirection = axisDirectionIn;
      this.directionVec = directionVecIn;
   }

   public int getXOffset() {
      return this.directionVec.getX();
   }

   public int getYOffset() {
      return this.directionVec.getY();
   }

   public int getZOffset() {
      return this.directionVec.getZ();
   }

   public Axis getAxis() {
      return this.axis;
   }

   public String toString() {
      return this.name;
   }

   public enum Axis implements Predicate<Direction> {
      X("x") {
         public int getCoordinate(int x, int y, int z) {
            return x;
         }

         public double getCoordinate(double x, double y, double z) {
            return x;
         }
      },
      Y("y") {
         public int getCoordinate(int x, int y, int z) {
            return y;
         }

         public double getCoordinate(double x, double y, double z) {
            return y;
         }
      },
      Z("z") {
         public int getCoordinate(int x, int y, int z) {
            return z;
         }

         public double getCoordinate(double x, double y, double z) {
            return z;
         }
      };

      private static final Axis[] field_239633_e_ = values();
      private static final Map<String, Axis> NAME_LOOKUP;
      private final String name;

      static {
         NAME_LOOKUP = Arrays.stream(field_239633_e_).collect(Collectors.toMap(Axis::getName2, p_199785_0_ -> p_199785_0_));
      }

      Axis(String nameIn) {
         this.name = nameIn;
      }

      public String getName2() {
         return this.name;
      }

      public String toString() {
         return this.name;
      }

      public boolean test(Direction p_test_1_) {
         return (p_test_1_ != null && p_test_1_.getAxis() == this);
      }

      public Direction.Plane getPlane() {
         if (this == Z) {
            return Direction.Plane.HORIZONTAL;
         }
         if (this == Y) {
            return Direction.Plane.VERTICAL;
         }
         throw new Error("Someone's been tampering with the universe!");
      }

      public abstract int getCoordinate(int param1Int1, int param1Int2, int param1Int3);

      public abstract double getCoordinate(double param1Double1, double param1Double2, double param1Double3);
   }

   public enum AxisDirection {
      POSITIVE(1, "Towards positive"),
      NEGATIVE(-1, "Towards negative");

      private final int offset;

      private final String description;

      AxisDirection(int offset, String description) {
         this.offset = offset;
         this.description = description;
      }

      public String toString() {
         return this.description;
      }

   }

   public enum Plane implements Iterable<Direction>, Predicate<Direction> {
      HORIZONTAL(new Direction[] { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST }, new Direction.Axis[] { Direction.Axis.X, Direction.Axis.Z }),
      VERTICAL(new Direction[] { Direction.UP, Direction.DOWN }, new Direction.Axis[] { Direction.Axis.Y });

      private final Direction[] facingValues;

      Plane(Direction[] facingValuesIn, Direction.Axis[] axisValuesIn) {
         this.facingValues = facingValuesIn;
      }

      public Direction random(Random rand) {
         return Util.getRandomObject(this.facingValues, rand);
      }

      public boolean test(Direction p_test_1_) {
         return (p_test_1_ != null && p_test_1_.getAxis().getPlane() == this);
      }

      public Iterator<Direction> iterator() {
         return null;
      }
   }
}