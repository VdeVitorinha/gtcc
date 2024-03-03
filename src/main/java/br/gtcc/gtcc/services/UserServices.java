/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gtcc.gtcc.services;

import br.gtcc.gtcc.model.Users;
import java.util.List;
import org.dizitart.no2.collection.FindOptions;
import org.dizitart.no2.common.SortOrder;
import org.dizitart.no2.common.WriteResult;
import org.dizitart.no2.filters.FluentFilter;
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
           Users getU = this.getUsers(users);
        
        if( users != null ){
            
            if( users.getRegistration() != null ){
            
                if( getU != null ){
                
                    WriteResult result = repositoryUsers.update(where("id").eq(users.getRegistration()), users);
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

    public List<Users> getAllUsers(){

        List<Users> list = repositoryUsers.find(FindOptions.orderBy("name", SortOrder.Ascending)).toList(); 
        
        if( list != null){
        
             return list; 
            
        }else{
        
            //Exeção caso não encontra nada
            return null;
            
        }

    }
    
    public Users getUsers(Users users){
        
        if( users != null ){
            
            if( users.getRegistration() != null ){
            
                //Realiza  buscano banco de dados
               Users user = repositoryUsers.find(FluentFilter.where("registration").eq(users.getRegistration())).firstOrNull();
               
               if( user != null ){
               
                    return user;
                   
               }else{
               
                   //Exeção caso o usuário não é encontrado
                   return null;
               
               }
                
            }else{
                
                //Execeção caso o usuário não tenha uma matricula
                return null;
                
            }
            
        } else {
        
            //Execeção caso o usuário fornecido seja nulo 
            return null;
                    
        }
    
    }
    
}
