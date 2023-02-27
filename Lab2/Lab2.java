public class Lab2 {
    public static void main(String[] args) {

        Location airport1 = new Location("Aeroport Iasi", LOCATION_TYPE.AIRPORT, 3, 5);
        Location Iasi = new Location("Iasi", LOCATION_TYPE.CITY, 2, 7);
        Location OMV = new Location("Omv Pacurari", LOCATION_TYPE.GAS_STATION, 52, 1);

        Road Independentei = new Road(ROAD_TYPE.COUNTRY, 20.5f, 60.f);
        Road Soarelui = new Road(ROAD_TYPE.HIGHWAY, 150.3f, 130.f);

        Independentei.setLocations(Iasi, OMV);

        System.out.println(airport1);
        System.out.println(Independentei);
        System.out.println(OMV);
        System.out.println(Soarelui);

    }
}
