package com.kodlamaio.rentacar.webApi.controllers;

import com.kodlamaio.rentacar.business.abstracts.BrandService;
import com.kodlamaio.rentacar.business.requests.CreateBrandsRequest;
import com.kodlamaio.rentacar.business.responses.GetAllBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;



    @GetMapping()
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateBrandsRequest createBrandsRequest){
        this.brandService.add(createBrandsRequest);
    }
}
