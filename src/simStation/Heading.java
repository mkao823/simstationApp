package simStation;

import mvc.Utilities;

public enum Heading
{
    NORTH, EAST, SOUTH, WEST;

    public static Heading random() {
        int ran = Utilities.rng.nextInt(4);
        if(ran == 0) return NORTH;
        if(ran == 1) return EAST;
        if(ran == 2) return SOUTH;
        if(ran == 3) return WEST;
        return null;
    }


}