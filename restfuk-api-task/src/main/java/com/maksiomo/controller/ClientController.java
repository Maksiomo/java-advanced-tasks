package com.maksiomo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.maksiomo.model.domain.Client;
import com.maksiomo.model.dto.ClientDTO;

@RequestMapping(ClientController.MAPPING)
public interface ClientController {
        String MAPPING = "/clients";

        @PostMapping("/create")
        @Operation(description = "Request for creation of a new client.")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "400", description = "If full name does not consist of 3 elements")
        })
        ResponseEntity<Client> createClient(@RequestBody(required = false) ClientDTO dto);

        @PostMapping("/alter/{idClient}")
        @Operation(description = "Request for alteration of a client.")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "400", description = "Invalid client id")
        })
        ResponseEntity<Client> alterClient(@RequestBody ClientDTO newData, @PathVariable Integer idClient);

        @PostMapping("/delete/{idClient}")
        @Operation(description = "Request for deletion of a client.")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "400", description = "Invalid client id")
        })
        ResponseEntity<String> deleteClient(@PathVariable Integer idClient);

        @GetMapping("/list")
        @Operation(description = "Request for a list of clients.")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "400", description = "DB is empty!")
        })
        ResponseEntity<Page<Client>> getClients(@RequestParam Integer page,
                        @RequestParam(defaultValue = "20") Integer size);

        @GetMapping("/listBy/domain")
        @Operation(description = "Request for a list of clients with certian domain.")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "400", description = "Invalid domain")
        })
        ResponseEntity<Page<Client>> listClientsByDomain(@RequestParam Integer page,
                        @RequestParam(defaultValue = "20") Integer size,
                        @RequestParam String domain);

        @GetMapping("/{idClient}")
        @Operation(description = "Request for a client info.")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "400", description = "Invalid client id")
        })
        ResponseEntity<Client> getClientById(@PathVariable(required = false) Integer idClient);

        @GetMapping("/order")
        @Operation(description = "Request for getting clients ordered by last name.")
        ResponseEntity<Page<Client>> getClientsByLastNameByOrder(@RequestParam Integer page,
                        @RequestParam(defaultValue = "20") Integer size);

}
