package pl.pjwstk.edu.jazapp.auction.parameter;


import pl.pjwstk.edu.jazapp.auction.entities.Parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ParameterController {

    @Inject
    ParameterRequest parameterRequest;

    @Inject
    ParameterRepository parameterRepository;


    public void add(){
        if(parameterRepository.checkIfParameterExists(parameterRequest.getName())){
            Parameter parameter = new Parameter(parameterRequest.getName());
            parameterRepository.addToDataBase(parameter);
            System.out.println("Added parameter: "+parameterRequest.getName());
        }
        else System.out.println("Error adding parameter "+parameterRequest.getName());
    }

    public void edit(){
        if(parameterRepository.checkIfParameterExists(parameterRequest.getName())){
            Parameter parameter = parameterRepository.getParameterById(parameterRequest.getId());
            System.out.println("Editing parameter "+parameter.getName()+" to "+parameterRequest.getName());
            parameter.setName(parameterRequest.getName());
            parameterRepository.editParameter(parameter);
        }
    }
}
