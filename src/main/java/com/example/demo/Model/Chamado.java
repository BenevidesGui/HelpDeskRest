package com.example.demo.Model;

import com.example.demo.StatusChamado;

import java.time.LocalDate;

public class Chamado {
    Long customer_id;
    LocalDate DataResolucao;
    String DadosMaquininha;
    Long device_id;
    Long serial_number;
    String motivoChamado;
    StatusChamado status;
}
