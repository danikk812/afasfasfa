package by.bsuir.model;

import java.io.File;

public class Hotel {
    private String hotelName;
    private int floor;
    private boolean conditioner;
    private boolean extraBathroom;
    private String clientWishes;
    private File image;

    public Hotel() {
    }

    public Hotel(String hotelName, int floor, boolean conditioner, boolean extraBathroom, String clientWishes) {
        this.hotelName = hotelName;
        this.floor = floor;
        this.conditioner = conditioner;
        this.extraBathroom = extraBathroom;
        this.clientWishes = clientWishes;
    }

    public Hotel(String hotelName, File image) {
        this.hotelName = hotelName;
        this.image = image;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    public void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }

    public boolean isExtraBathroom() {
        return extraBathroom;
    }

    public void setExtraBathroom(boolean extraBathroom) {
        this.extraBathroom = extraBathroom;
    }

    public String getClientWishes() {
        return clientWishes;
    }

    public void setClientWishes(String clientWishes) {
        this.clientWishes = clientWishes;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "RoomOrder{" +
                "hotelName='" + hotelName + '\'' +
                ", floor=" + floor +
                ", conditioner=" + conditioner +
                ", extraBathroom=" + extraBathroom +
                ", wishes='" + clientWishes + '\'' +
                '}';
    }
}
