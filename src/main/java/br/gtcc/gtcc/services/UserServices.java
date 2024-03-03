/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gtcc.gtcc.services;

import br.gtcc.gtcc.model.Users;
import java.util.List;
import org.dizitart.no2.common.WriteResult;
import static org.dizitart.no2.filters.FluentFilter.where;
import org.dizitart.no2.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mrbee
 * 
 * Classe que serve aos controllers, essa classe manipula diretamente as consultas e retornar as 
 * informações para as controllers
 * 
 */
@Service
public class UserServices {
   
    @Autowired
    ObjectRepository<Users> repositoryUsers;
    
    public Users createUsers(Users users){
        
        if( users != null ){
            
            if( users.getRegistration() != null ){
            
                repositoryUsers.insert(users);
                
            }else{
                
                return null;
                
            }
            
        }else{
            
            return null;
        
        }
        
        return users;
    }
    
    public Users deleteUsers(Users users){
        
        Users getU = this.getUsers(users);
        
        if( users != null ){
            
            if( users.getRegistration() != null ){
            
                if( getU != null ){
                
                    WriteResult result = repositoryUsers.remove(where("id").eq(users.getRegistration()));
                    users = (Users) result;
            
                } else {

                    return null;

                }
                
            } else {
                
                return null;
                
            }            
            
        } else {
            
            return null;
            
        }
        
        return users;
    }
    
    public Users updateUsers(Users users){
        return users;
    }

    public List<Users> getAllUsers(){
        return null;
    }
    
    public Users getUsers(Users users){
        return null;
    }
    
}
