package com.tiagobani.persons.ports.viacep.impl;

import com.tiagobani.persons.ports.viacep.IFindAddressViaCep;
import com.tiagobani.persons.ports.viacep.dto.ViaCepAddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class FindAddressViaCep implements IFindAddressViaCep {

    private final static String BASEURL = "https://viacep.com.br/ws/";
    private final WebClient webClient;


    public ViaCepAddressResponseDto handle(String postalCode){
        return  webClient.get()
                .uri(BASEURL + postalCode+ "/json")
                .retrieve()
                .bodyToMono(ViaCepAddressResponseDto.class).block();
    }
}
