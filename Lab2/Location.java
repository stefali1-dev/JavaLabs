enum LOCATION_TYPE{
    CITY,
    AIRPORT,
    GAS_STATION
}
class Location {
    String name;

    LOCATION_TYPE type;
    int x;
    int y;

    public Location(String name, LOCATION_TYPE type, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LOCATION_TYPE getType() {
        return type;
    }

    public void setType(LOCATION_TYPE type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" + "name='" + name + '\'' + ", x=" + x + ", y=" + y + '}';
    }
}
