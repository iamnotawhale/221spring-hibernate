package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "car_series")
    private int carSeries;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {
    }

    public Car(String carModel, int carSeries) {
        this.carModel = carModel;
        this.carSeries = carSeries;
    }

    public String getModel() {
        return carModel;
    }

    public void setModel(String carModel) {
        this.carModel = carModel;
    }

    public int getSeries() {
        return carSeries;
    }

    public void setSeries(int carSeries) {
        this.carSeries = carSeries;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long carId) {
        this.carId = carId;
    }

    public Long getId() {
        return carId;
    }
}
