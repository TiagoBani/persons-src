package com.tiagobani.persons.ports.viacep;

import com.tiagobani.persons.ports.viacep.dto.ViaCepAddressResponseDto;

public interface IFindAddressViaCep {

    ViaCepAddressResponseDto handle(String postalCode);
}
