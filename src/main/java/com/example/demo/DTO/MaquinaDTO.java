package com.example.demo.DTO;

import com.example.demo.Views.View;
import com.fasterxml.jackson.annotation.JsonView;

public class MaquinaDTO {

    @JsonView({View.MaquinaView.class, View.UserView.class})
    private Long deviceId;

    @JsonView({View.MaquinaView.class, View.UserView.class})
    private String serialNumber;

    @JsonView({View.MaquinaView.class})
    private Long customerId;

    // Getters e Setters
    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
