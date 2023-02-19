package com.kodlamaio.rentacar.business.abstracts;

import com.kodlamaio.rentacar.business.requests.CreateBrandsRequest;
import com.kodlamaio.rentacar.business.requests.UpdateBrandRequest;
import com.kodlamaio.rentacar.business.responses.GetAllBrandResponse;
import com.kodlamaio.rentacar.business.responses.GetByIdBrandResponse;
import com.kodlamaio.rentacar.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BrandService {
     List<GetAllBrandResponse> getAll();
     GetByIdBrandResponse getById(Long id);
    void add(CreateBrandsRequest createBrandsRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(Long id);
}
