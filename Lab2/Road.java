import java.util.Arrays;

enum ROAD_TYPE{
    HIGHWAY,
    EXPRESS,
    COUNTRY
}

class Road {
    ROAD_TYPE type;
    float length;
    float speedLimit;

    Location[] locations; // array containing the two locations connected by the Road

    private float getDistanceBetweenPoints(int x1, int y1, int x2, int y2)
    {
        return (float) (Math.sqrt( Math.pow(x2 - x1, 2)) + Math.pow(y2 - y1, 2));
    }
    public Road(ROAD_TYPE type, float length, float speedLimit) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;

        locations = new Location[2];
    }

    public void setLocations(Location location1, Location location2)
    {
        locations[0] = location1;
        locations[1] = location2;
    }

    public ROAD_TYPE getType() {
        return type;
    }

    public void setType(ROAD_TYPE type) {
        this.type = type;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {

        float euclidianDistance = getDistanceBetweenPoints(locations[0].x, locations[0].y, locations[1].x, locations[0].y);

        if(length >= euclidianDistance)
            this.length = length;

        else
            System.out.println("The length of a road should not be less than the euclidian distance between the location coordinates.");
    }

    public float getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                ", locations=" + Arrays.toString(locations) +
                '}';
    }
}