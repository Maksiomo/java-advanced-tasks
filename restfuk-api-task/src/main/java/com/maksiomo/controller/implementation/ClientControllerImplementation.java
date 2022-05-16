package com.maksiomo.controller.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.maksiomo.controller.ClientController;
import com.maksiomo.model.domain.Client;
import com.maksiomo.model.dto.ClientDTO;
import com.maksiomo.service.ClientService;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
public class ClientControllerImplementation {

}
