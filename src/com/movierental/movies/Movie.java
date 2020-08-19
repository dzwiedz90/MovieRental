package com.movierental.movies;

public class Movie {
    private String id;
    private String name;
    private String rentalPrice;
    private String priority;
    private String description;
    private String isRented;
    private String productionYear;
    private String genre;
    private String director;


    public void setId(String idIn) {
        this.id = idIn;
    }

    public void setName(String nameIn) {
        this.name = nameIn;
    }

    public void setRentalPrice(String rentalPriceIn) {
        this.rentalPrice = rentalPriceIn;
    }

    public void setPriority(String priorityIn) {
        this.priority = priorityIn;
    }

    public void setDescription(String descriptionIn) {
        this.description = descriptionIn;
    }

    public void setIsRented(String isRentedIn) {
        this.isRented = isRentedIn;
    }

    public void setProductionYear(String productionYearIn) {
        this.productionYear = productionYearIn;
    }

    public void setGenre(String genreIn) {
        this.genre = genreIn;
    }

    public void setDirector(String directorIn) {
        this.director = directorIn;
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRentalPrice() {
        return this.rentalPrice;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIsRented() {
        return this.isRented;
    }

    public String getProductionYear() {
        return this.productionYear;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getDirector() {
        return this.director;
    }
}
