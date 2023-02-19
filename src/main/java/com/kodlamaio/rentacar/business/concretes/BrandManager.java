package com.kodlamaio.rentacar.business.concretes;

import com.kodlamaio.rentacar.business.abstracts.BrandService;
import com.kodlamaio.rentacar.business.requests.CreateBrandsRequest;
import com.kodlamaio.rentacar.business.requests.UpdateBrandRequest;
import com.kodlamaio.rentacar.business.responses.GetAllBrandResponse;
import com.kodlamaio.rentacar.business.responses.GetByIdBrandResponse;
import com.kodlamaio.rentacar.core.utilities.mappers.ModelMapperService;
import com.kodlamaio.rentacar.dataAccess.abstracts.BrandRepository;
import com.kodlamaio.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllBrandResponse > getAll(){
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }


    @Override
    public void add(CreateBrandsRequest createBrandsRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandsRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(Long id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        this.brandRepository.deleteById(id);
    }
}
