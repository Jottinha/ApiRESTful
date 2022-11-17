package com.restful.demo.controller;

import com.restful.demo.model.PhonesVersions;
import com.restful.demo.repository.RepositoryPhonesVersion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST produtos")
@CrossOrigin(origins = "*")
public class WebController {

    @Autowired
    RepositoryPhonesVersion phones;

    @GetMapping("/products")
    @ApiOperation(value = "Retorna uma lista de produtos")
    public ResponseEntity<List<PhonesVersions>> getAllPhones(){
        List<PhonesVersions> phonesList = phones.findAll();
        if (phonesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            for ( PhonesVersions phoneSeparete : phonesList){
                long id = phoneSeparete.getIdPhone();
                phoneSeparete.add(linkTo(methodOn(WebController.class).getOnePhone(id)).withSelfRel());
            }
        }
        return new ResponseEntity<List<PhonesVersions>>(phonesList, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "Retorna um produto especifico")
    public ResponseEntity<PhonesVersions> getOnePhone(@PathVariable(value="id") long id){
        Optional<PhonesVersions> phoneId = phones.findById(id);
        if (!phoneId.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            phoneId.get().add(linkTo(methodOn(WebController.class).getAllPhones()).withRel("Lista telefones"));
            return new ResponseEntity<PhonesVersions>(phoneId.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/products")
    @ApiOperation(value = "Adiciona um produto")
    public ResponseEntity<PhonesVersions> postPhones(@RequestBody PhonesVersions newPhones){
        return new ResponseEntity<PhonesVersions>(phones.save(newPhones), HttpStatus.OK);
    }

    @PutMapping("/products")
    @ApiOperation(value = "Atualiza um produto")
    public ResponseEntity<PhonesVersions> putPhones(@RequestBody PhonesVersions updatePhone){
        Optional<PhonesVersions> updateDataId = phones.findById(updatePhone.getIdPhone());
        if (!updateDataId.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<PhonesVersions>(phones.save(updatePhone),HttpStatus.OK);
        }
    }

    @DeleteMapping("/products")
    @ApiOperation(value = "Deleta um produto")
    public ResponseEntity<PhonesVersions> deletePhones(@RequestBody PhonesVersions deletePhones){
        Optional<PhonesVersions> idToDelete = phones.findById(deletePhones.getIdPhone());
        if (idToDelete.isPresent()) {
            phones.delete(deletePhones);
            return new ResponseEntity<PhonesVersions>(HttpStatus.OK);
        }else{
            return new ResponseEntity<PhonesVersions>(HttpStatus.NOT_FOUND);
        }
    }
}
