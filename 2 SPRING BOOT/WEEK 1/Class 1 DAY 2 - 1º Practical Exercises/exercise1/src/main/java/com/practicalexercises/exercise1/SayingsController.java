package com.practicalexercises.exercise1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class SayingsController {

    List<String> sayings = new ArrayList<>(List.of(
            "Haz el bien sin mirar a quién",
            "La avaricia rompe el saco",
            "Más vale prevenir que curar",
            "No es oro todo lo que reluce",
            "No hay mal que por bien no venga",
            "Al mal tiempo buena cara",
            "Quien tiene un amigo tiene un tesoro",
            "No dejes para mañana lo que puedas hacer hoy",
            "Quien no arriesga no gana",
            "De los errores se aprende",
            "Hoy por ti, mañana por mí",
            "Más vale pájaro en mano que ciento volando",
            "El que tiene boca se equivoca",
            "Primero es la obligación que la devoción",
            "El saber no ocupa lugar",
            "El que lee mucho y anda mucho, ve mucho y sabe mucho",
            "El que algo quiere, algo le cuesta",
            "A palabras necias, oídos sordos",
            "Preguntando se llega a Roma",
            "El hábito no hace al monje",
            "El que a hierro mata, a hierro muere",
            "A enemigo que huye, puente de plata",
            "Ande yo caliente, ríase la gente"
    ));

    @GetMapping
    public String getSayings() {
        Random r = new Random();
        return sayings.get(r.nextInt(sayings.size()-1));
    }
}
