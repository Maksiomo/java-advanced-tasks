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
    ResponseEntity<String> createClient(@RequestBody(required = false) ClientDTO dto);

    @GetMapping("/alter/{id}")
    @Operation(description = "Request for alteration of a client.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "400", description = "Invalid client id")
    })
    ResponseEntity<Client> alterClient(@RequestParam ClientDTO newData, @RequestParam Integer idClient);

    @GetMapping("/delete/{id}")
    @Operation(description = "Request for deletion of a client.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "400", description = "Invalid client id")
    })
    ResponseEntity<String> deleteClient(@RequestParam String idClient);

    @GetMapping("/list")
    @Operation(description = "Request for a list of clients.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "400", description = "DB is empty!")
    })
    ResponseEntity<Page<Client>> getClients(@RequestParam Integer page,
            @RequestParam(defaultValue = "20") Integer size);

    @GetMapping("/listBy/domain/{domain}")
    @Operation(description = "Request for a list of clients with certian domain.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "400", description = "Invalid domain")
    })
    ResponseEntity<List<Client>> listClientsByDomain(@RequestParam Integer page,
            @RequestParam(defaultValue = "20") Integer size,
            @RequestParam String domain);

    @GetMapping("/listBy/secondName")
    @Operation(description = "Request for a list of clients with certian second name.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "400", description = "Invalid second name in request")
    })
    ResponseEntity<List<Client>> listClientsBySecondName(@RequestParam Integer page,
            @RequestParam(defaultValue = "20") Integer size);

    @GetMapping("/{id}")
    @Operation(description = "Request for a client info.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "400", description = "Invalid client id")
    })
    ResponseEntity<Client> getClientById(@PathVariable(required = false) String id,
            @RequestParam(defaultValue = "FirstName") String firstName);

}
